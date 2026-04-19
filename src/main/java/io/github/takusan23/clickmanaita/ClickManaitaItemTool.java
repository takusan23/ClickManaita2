package io.github.takusan23.clickmanaita;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * ユーティリティクラス
 */
public class ClickManaitaItemTool {

    /**
     * アイテムを増やす処理。
     * 以下のクリックまな板アイテムから呼び出される。
     * クリック時に呼び出すことでアイテムが増えます。
     * <p>
     * {@link io.github.takusan23.clickmanaita.item.ClickManaitaBaseItem}
     * {@link io.github.takusan23.clickmanaita.item.ClickManaitaCustomItem}
     * {@link ClickManaitaPlayerEvent}
     */
    public static void manaita(
            int dropSize,
            Level world,
            BlockPos blockPos,
            Player player
    ) {

        if (!(world instanceof ServerLevel)) {
            return;
        }

        BlockState blockState = world.getBlockState(blockPos);
        Block copyBlock = blockState.getBlock();
        BlockEntity blockEntity = world.getBlockEntity(blockPos);

        for (int i = 0; i < dropSize; i++) {

            // チェストの中身も増やす
            if (blockEntity instanceof Container) {
                for (int l = 0; l < ((Container) blockEntity).getContainerSize(); l++) {
                    Block.popResource(world, blockPos, ((Container) blockEntity).getItem(l).copy());
                }
            }

            // ブロック複製
            copyBlock.playerDestroy(world, player, blockPos, blockState, blockEntity, player.getMainHandItem());

            // なんか経験値を吐き出す実装がなくなった？ので自前で用意
            int exp = blockState.getExpDrop(world, world.getRandom(), blockPos, 0, 0);
            copyBlock.popExperience((ServerLevel) world, blockPos, exp);
        }
    }

}
