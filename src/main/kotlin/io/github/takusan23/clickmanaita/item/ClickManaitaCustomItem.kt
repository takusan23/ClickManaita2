package io.github.takusan23.clickmanaita.item

import io.github.takusan23.clickmanaita.ClickManaitaItemTool
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.text.MutableText
import net.minecraft.text.PlainTextContent
import net.minecraft.text.Style
import net.minecraft.util.ActionResult
import net.minecraft.util.Formatting

/**
 * 金床で変えた値だけ増えるまな板
 * */
class ClickManaitaCustomItem(settings: Settings?) : Item(settings) {

    /** ツールチップの文言を返す */
    fun getTooltipText(itemStack: ItemStack): MutableText {
        return MutableText.of(PlainTextContent.of("x${getDropSize(itemStack)}")).setStyle(Style.EMPTY.withColor(Formatting.AQUA))
    }

    /**
     * ブロックを右クリックしたときに呼ばれる関数
     */
    override fun useOnBlock(context: ItemUsageContext?): ActionResult {

        context ?: return ActionResult.PASS

        // 共通処理を呼び出す
        ClickManaitaItemTool.manaita(
            dropSize = getDropSize(context.stack),
            world = context.world,
            blockPos = context.blockPos,
            playerEntity = context.player
        )

        return ActionResult.SUCCESS
    }

    /**
     * ドロップ数を返す。失敗したら1
     *
     * @param itemStack アイテム
     */
    private fun getDropSize(itemStack: ItemStack): Int {
        return itemStack.name.string.toIntOrNull() ?: 1
    }
}