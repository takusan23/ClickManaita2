package io.github.takusan23.clickmanaita

import net.minecraft.item.Item
import net.minecraft.item.ItemUsageContext
import net.minecraft.util.ActionResult

/**
 * 右クリックしたらアイテムが増えるアイテムを追加する
 *
 * @param settings クリエタブとか
 * @param dropSize 増える数
 * */
class ClickManaitaBaseItem(settings: Settings?, private val dropSize: Int = 2) : Item(settings) {

    /**
     * ブロックを右クリックしたときに呼ばれる関数
     * */
    override fun useOnBlock(context: ItemUsageContext?): ActionResult {
        val world = context?.world
        val state = world?.getBlockState(context.blockPos)
        val copyBlock = state?.block
        repeat(dropSize) {
            copyBlock?.afterBreak(world, context.player, context.blockPos, state, null, context.stack)
        }
        return ActionResult.SUCCESS
    }

}