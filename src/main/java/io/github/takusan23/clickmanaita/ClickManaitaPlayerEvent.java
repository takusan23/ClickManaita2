package io.github.takusan23.clickmanaita;

import io.github.takusan23.clickmanaita.enchant.RegisterEnchant;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnderEyeItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.text.BreakIterator;

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
     *
     * todo なんでか知らんけど右クリックイベントがclient/server共に２回呼ばれるんだけど？
     */
    @SubscribeEvent
    public void onBlockRightClickEvent(PlayerInteractEvent.RightClickBlock event) {
        // エンチャントレベル取得
        int enchantLevel = EnchantmentHelper.getEnchantmentLevel(RegisterEnchant.clickManaitaEnchant, event.getPlayer());
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
            for (int i = 0; i < dropSize; i++) {
                // チェストの中身も増やす
                if (blockEntity instanceof Container) {
                    for (int l = 0; l < ((Container) blockEntity).getContainerSize(); l++) {
                        Block.popResource(level, blockPos, ((Container) blockEntity).getItem(l).copy());
                    }
                }
                // ブロック複製
                Block.dropResources(blockState, level, blockPos, null, player, player.getMainHandItem());
            }
        }
    }

}
