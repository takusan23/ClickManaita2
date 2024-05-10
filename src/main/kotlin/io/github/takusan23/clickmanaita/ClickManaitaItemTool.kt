package io.github.takusan23.clickmanaita

import net.minecraft.block.Block
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

/** ユーティリティクラス */
object ClickManaitaItemTool {

    /**
     * アイテムを増やす処理。
     * 以下のクリックまな板アイテムから呼び出される。
     * クリック時に呼び出すことでアイテムが増えます。
     *
     * - [io.github.takusan23.clickmanaita.item.ClickManaitaBaseItem]
     * - [io.github.takusan23.clickmanaita.item.ClickManaitaCustomItem]
     * - [io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchant]
     *
     * @param dropSize 増やす数
     */
    fun manaita(
        dropSize: Int,
        world: World?,
        blockPos: BlockPos?,
        playerEntity: PlayerEntity?
    ) {
        if (world !is ServerWorld) return

        val blockState = world.getBlockState(blockPos)
        val copyBlock = blockState?.block ?: return
        val blockEntity = world.getBlockEntity(blockPos)

        repeat(dropSize) {

            // チェストの中身も増やす
            if (blockEntity is Inventory) {
                repeat(blockEntity.size()) { invIndex ->
                    Block.dropStack(world, blockPos, blockEntity.getStack(invIndex).copy())
                }
            }

            // ブロックを増やす
            copyBlock.afterBreak(world, playerEntity, blockPos, blockState, blockEntity, playerEntity?.mainHandStack)
        }
    }

}