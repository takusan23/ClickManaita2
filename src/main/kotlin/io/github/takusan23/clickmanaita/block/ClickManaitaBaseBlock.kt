package io.github.takusan23.clickmanaita.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

/**
 * ブロックをクリックしたら持ってるアイテムが増える
 *
 * @param settings マテリアルの指定とか
 * @param dropSize 増やす数など
 * */
class ClickManaitaBaseBlock(settings: Settings?, private val dropSize: Int = 2) : Block(settings) {

    /** ブロックを右クリックしたら呼ばれる */
    override fun onUse(state: BlockState?, world: World?, pos: BlockPos?, player: PlayerEntity?, hand: Hand?, hit: BlockHitResult?): ActionResult {
        if (world!!.isClient) {
            return ActionResult.CONSUME
        } else {
            repeat(dropSize) {
                // 今持ってるアイテム
                val currentItem = player?.inventory?.mainHandStack?.copy()
                currentItem?.count = 1
                // アイテムを落とす
                dropStack(world, pos, currentItem)
            }
            return ActionResult.SUCCESS
        }
    }
}