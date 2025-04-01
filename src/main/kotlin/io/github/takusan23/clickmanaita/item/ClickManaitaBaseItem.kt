package io.github.takusan23.clickmanaita.item

import io.github.takusan23.clickmanaita.ClickManaitaItemTool
import net.minecraft.item.Item
import net.minecraft.item.ItemUsageContext
import net.minecraft.text.MutableText
import net.minecraft.text.PlainTextContent
import net.minecraft.text.Style
import net.minecraft.util.ActionResult
import net.minecraft.util.Formatting

/**
 * 右クリックしたらアイテムが増えるアイテムを追加する
 *
 * @param settings クリエタブとか
 * @param dropSize 増える数
 * */
class ClickManaitaBaseItem(settings: Settings?, private val dropSize: Int = 2) : Item(settings) {

    /** ツールチップの文言を返す */
    fun getTooltipText(): MutableText {
        return MutableText.of(PlainTextContent.of("x$dropSize")).setStyle(Style.EMPTY.withColor(Formatting.AQUA))
    }

    /**
     * ブロックを右クリックしたときに呼ばれる関数
     */
    override fun useOnBlock(context: ItemUsageContext?): ActionResult {

        context ?: return ActionResult.PASS

        // 共通処理を呼び出す
        ClickManaitaItemTool.manaita(
            dropSize = dropSize,
            world = context.world,
            blockPos = context.blockPos,
            playerEntity = context.player
        )

        return ActionResult.SUCCESS
    }
}