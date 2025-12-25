package io.github.takusan23.clickmanaita.block

import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

/**
 * ブロックをクリックしたら持ってるアイテムが増える
 *
 * @param settings マテリアルの指定とか
 * @param dropSize 増やす数など
 * */
class ClickManaitaBaseBlock(settings: Properties, private val dropSize: Int = 2) : Block(settings) {

    /** ブロックを右クリックしたら呼ばれる */
    override fun useWithoutItem(blockState: BlockState, level: Level, blockPos: BlockPos, player: Player, blockHitResult: BlockHitResult): InteractionResult {
        return if (level.isClientSide) {
            InteractionResult.CONSUME
        } else {
            repeat(dropSize) {
                // 今持ってるアイテム
                val currentItem = player.mainHandItem.copy()
                currentItem?.count = 1
                // アイテムを落とす
                popResource(level, blockPos, currentItem)
            }
            InteractionResult.SUCCESS
        }
    }

}