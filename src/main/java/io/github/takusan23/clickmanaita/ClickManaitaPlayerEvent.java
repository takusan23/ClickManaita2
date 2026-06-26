package io.github.takusan23.clickmanaita;

import io.github.takusan23.clickmanaita.block.ClickManaitaBlockItem;
import io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchant;
import io.github.takusan23.clickmanaita.item.ClickManaitaBaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * プレイヤーがアイテムを拾ったなど、イベントを受け取るクラス
 * <p>
 * どうやら、引数のクラス（なんちゃらEvent）ってのが大事らしく、メソッド名はどうでもよいらしい（ただしアクセス修飾子はpublicにする）
 * <p>
 * MinecraftForge.EVENT_BUS.register()で登録できます
 */
public class ClickManaitaPlayerEvent {

    /**
     * ツールチップを出すメソッドが非推奨になってしまったので
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        List<Component> toolTip = event.getToolTip();

        MutableComponent text = switch (itemStack.getItem()) {
            case ClickManaitaBaseItem baseItem -> baseItem.getHoverText(itemStack);
            case ClickManaitaBlockItem blockItem -> blockItem.getHoverText();
            default -> null;
        };
        if (text != null) {
            toolTip.add(text);
        }
    }

    /**
     * 右クリックイベントを購読する
     */
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onBlockRightClickEvent(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        BlockPos blockPos = event.getPos();
        BlockState blockState = world.getBlockState(blockPos);
        Player playerEntity = event.getEntity();
        Vec3 blockPosVec3d = Vec3.atCenterOf(blockPos);

        // 持ち手によって分岐
        // 最近の Java、これも出来るのか...
        ItemStack currentItem = switch (event.getHand()) {
            case MAIN_HAND -> playerEntity.getMainHandItem();
            case OFF_HAND -> playerEntity.getOffhandItem();
        };

        // サーバー側であること
        if (world.isClientSide()) return;

        // チェスト等インベントリを持つアイテムででスニーク状態じゃない場合はreturn
        if (!playerEntity.isShiftKeyDown() && blockState.hasBlockEntity()) return;

        // ドア（とその亜種）をクリックした場合、開けるのを優先。でもスニーク状態ならやらない
        if (!playerEntity.isShiftKeyDown() && blockState.hasProperty(BlockStateProperties.OPEN)) return;

        // clickmanaita:block_right_click エフェクトコンポーネントを呼び出す
        // 動作は minecraft:hit_block のそれと同じ、それの右クリック板。
        ItemEnchantments itemEnchantmentsComponent = currentItem.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        EnchantedItemInUse enchantedItemInUse = new EnchantedItemInUse(currentItem, EquipmentSlot.MAINHAND, playerEntity, item -> playerEntity.onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
        itemEnchantmentsComponent.entrySet().forEach(holderEntry -> {
            Enchantment enchantment = holderEntry.getKey().get();
            int level = holderEntry.getIntValue();
            List<ConditionalEffect<EnchantmentEntityEffect>> effectEntries = enchantment.getEffects(ClickManaitaEnchant.BLOCK_RIGHT_CLICK_EFFECT_COMPONENT.get());
            // エフェクトがトリガーされる
            applyEffects(
                    effectEntries,
                    createHitBlockLootContext((ServerLevel) world, level, playerEntity, blockPosVec3d, blockState),
                    effect -> effect.apply((ServerLevel) world, level, enchantedItemInUse, playerEntity, blockPosVec3d)
            );
        });
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinLevelEvent event){

    }

    private static LootContext createHitBlockLootContext(
            ServerLevel serverWorld,
            int level,
            Entity entity,
            Vec3 pos,
            BlockState state
    ) {
        LootParams lootContextParameterSet = (new LootParams.Builder(serverWorld))
                .withParameter(LootContextParams.THIS_ENTITY, entity)
                .withParameter(LootContextParams.ENCHANTMENT_LEVEL, level)
                .withParameter(LootContextParams.ORIGIN, pos)
                .withParameter(LootContextParams.BLOCK_STATE, state)
                .create(LootContextParamSets.HIT_BLOCK);
        return (new LootContext.Builder(lootContextParameterSet)).create(Optional.empty());
    }

    private static <T> void applyEffects(
            List<ConditionalEffect<T>> entries,
            LootContext lootContext,
            Consumer<T> onEffect
    ) {
        entries
                .stream()
                .filter(entry -> entry.matches(lootContext))
                .forEach(entry -> onEffect.accept(entry.effect()));
    }

}
