package io.github.takusan23.clickmanaita;

import io.github.takusan23.clickmanaita.enchant.RegisterEnchant;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * プレイヤーがアイテムを拾ったなど、イベントを受け取るクラス
 * <p>
 * どうやら、引数のクラス（なんちゃらEvent）ってのが大事らしく、メソッド名はどうでもよいらしい（ただしアクセス修飾子はpublicにする）
 * <p>
 * MinecraftForge.EVENT_BUS.register()で登録できます
 */
public class ClickManaitaPlayerEvent {

    /**
     * 右クリックイベントを取る
     * <p>
     * todo なんでか知らんけど右クリックイベントがclient/server共に２回呼ばれるんだけど？
     */
    @SubscribeEvent
    public void onBlockRightClickEvent(PlayerInteractEvent.RightClickBlock event) {
        // エンチャントレベル取得
        int enchantLevel = EnchantmentHelper.getEnchantmentLevel(RegisterEnchant.CLICKMANAITA_ENCHANT.get(), event.getPlayer());
        // チェスト等インベントリを持つアイテムででスニーク状態じゃない場合はreturn
        if (event.getWorld().getBlockState(event.getPos()).hasBlockEntity() && !event.getPlayer().isShiftKeyDown()) {
            return;
        }
        if (enchantLevel > 0) {
            // Java 16以降この書き方ができる模様
            int dropSize = switch (enchantLevel) {
                case 1 -> 2;
                case 2 -> 4;
                case 3 -> 8;
                case 4 -> 16;
                case 5 -> 32;
                default -> 0;
            };

            // まな板発動
            Level level = event.getWorld();
            BlockPos blockPos = event.getPos();
            BlockState blockState = level.getBlockState(blockPos);
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            Player player = event.getPlayer();
            Block copyBlock = blockState.getBlock();

            // アイテム化するかどうか
            boolean isNotItemDrop = copyBlock.getLootTable() == BuiltInLootTables.EMPTY || copyBlock.getCloneItemStack(blockState, null, level, blockPos, player) == ItemStack.EMPTY;
            for (int i = 0; i < dropSize; i++) {
                // アイテム化しない場合
                if (isNotItemDrop) {
                    ItemStack copyItem = new ItemStack(copyBlock.asItem());
                    // NBTタグを移す
                    if (blockEntity != null) {
                        CompoundTag compoundTag = blockEntity.serializeNBT();
                        if (!compoundTag.isEmpty()) {
                            copyItem.addTagElement("BlockEntityTag", compoundTag.copy());
                        }
                    }
                    // アイテムを地面に生成
                    Block.popResource(level, blockPos, copyItem);
                }
                // チェストの中身も増やす
                if (blockEntity instanceof Container) {
                    for (int l = 0; l < ((Container) blockEntity).getContainerSize(); l++) {
                        Block.popResource(level, blockPos, ((Container) blockEntity).getItem(l).copy());
                    }
                }
                // ブロック複製
                if (player != null) {
                    copyBlock.playerDestroy(level, player, blockPos, blockState, blockEntity, player.getMainHandItem());
                    // なんか経験値を吐き出す実装がなくなった？ので自前で用意
                    if (level instanceof ServerLevel) {
                        int exp = blockState.getExpDrop(level, level.random, blockPos, 0, 0);
                        copyBlock.popExperience((ServerLevel) level, blockPos, exp);
                    }
                }
            }
        }
    }

}
