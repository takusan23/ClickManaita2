package io.github.takusan23.clickmanaita.item

import io.github.takusan23.clickmanaita.ClickManaitaItemTool
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.network.chat.MutableComponent
import net.minecraft.network.chat.contents.PlainTextContents
import net.minecraft.network.chat.Style
import net.minecraft.world.InteractionResult
import net.minecraft.ChatFormatting

/**
 * 金床で変えた値だけ増えるまな板
 * */
class ClickManaitaCustomItem(settings: Properties) : Item(settings) {

    /** ツールチップの文言を返す */
    fun getTooltipText(itemStack: ItemStack): MutableComponent {
        return MutableComponent.create(PlainTextContents.create("x${getDropSize(itemStack)}")).setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA))
    }

    /**
     * ブロックを右クリックしたときに呼ばれる関数
     */
    override fun useOn(context: UseOnContext): InteractionResult {

        // 共通処理を呼び出す
        ClickManaitaItemTool.manaita(
            dropSize = getDropSize(context.itemInHand),
            world = context.level,
            blockPos = context.clickedPos,
            playerEntity = context.player ?: return InteractionResult.PASS
        )

        return InteractionResult.SUCCESS
    }

    /**
     * ドロップ数を返す。失敗したら1
     *
     * @param itemStack アイテム
     */
    private fun getDropSize(itemStack: ItemStack): Int {
        return itemStack.hoverName.string.toIntOrNull() ?: 1
    }
}