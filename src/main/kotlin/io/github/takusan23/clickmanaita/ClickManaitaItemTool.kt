package io.github.takusan23.clickmanaita

import net.minecraft.world.level.block.Block
import net.minecraft.world.entity.player.Player
import net.minecraft.world.Container
import net.minecraft.server.level.ServerLevel
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level

/** ユーティリティクラス */
object ClickManaitaItemTool {

    /**
     * アイテムを増やす処理。
     * 以下のクリックまな板アイテムから呼び出される。
     * クリック時に呼び出すことでアイテムが増えます。
     *
     * - [io.github.takusan23.clickmanaita.item.ClickManaitaBaseItem]
     * - [io.github.takusan23.clickmanaita.item.ClickManaitaCustomItem]
     * - [io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchantEntityEffect]
     *
     * @param dropSize 増やす数
     */
    fun manaita(
        dropSize: Int,
        world: Level,
        blockPos: BlockPos,
        playerEntity: Player
    ) {
        if (world !is ServerLevel) return

        val blockState = world.getBlockState(blockPos)
        val copyBlock = blockState?.block ?: return
        val blockEntity = world.getBlockEntity(blockPos)

        repeat(dropSize) {

            // チェストの中身も増やす
            if (blockEntity is Container) {
                repeat(blockEntity.containerSize) { invIndex ->
                    Block.popResource(world, blockPos, blockEntity.getItem(invIndex).copy())
                }
            }

            // ブロックを増やす
            copyBlock.playerDestroy(world, playerEntity, blockPos, blockState, blockEntity, playerEntity.mainHandItem)
        }
    }

}