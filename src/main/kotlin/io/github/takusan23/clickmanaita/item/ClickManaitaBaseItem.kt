package io.github.takusan23.clickmanaita.item

import io.github.takusan23.clickmanaita.ClickManaitaItemTool
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.network.chat.MutableComponent
import net.minecraft.network.chat.contents.PlainTextContents
import net.minecraft.network.chat.Style
import net.minecraft.world.InteractionResult
import net.minecraft.ChatFormatting

/**
 * 右クリックしたらアイテムが増えるアイテムを追加する
 *
 * @param settings クリエタブとか
 * @param dropSize 増える数
 * */
class ClickManaitaBaseItem(settings: Properties, private val dropSize: Int = 2) : Item(settings) {

    /** ツールチップの文言を返す */
    fun getTooltipText(): MutableComponent {
        return MutableComponent.create(PlainTextContents.create("x$dropSize")).setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA))
    }

    /**
     * ブロックを右クリックしたときに呼ばれる関数
     */
    override fun useOn(context: UseOnContext): InteractionResult {

        // 共通処理を呼び出す
        ClickManaitaItemTool.manaita(
            dropSize = dropSize,
            world = context.level,
            blockPos = context.clickedPos,
            playerEntity = context.player ?: return InteractionResult.PASS
        )

        return InteractionResult.SUCCESS
    }
}