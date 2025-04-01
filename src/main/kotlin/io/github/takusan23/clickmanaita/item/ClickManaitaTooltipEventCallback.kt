package io.github.takusan23.clickmanaita.item

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback

/** ツールチップイベントを拾う */
object ClickManaitaTooltipEventCallback {

    /** ツールチップ表示イベントを登録する */
    fun registerTooltipEventCallback() {
        // ツールチップの実装が変わってしまったので対応
        // https://wiki.fabricmc.net/tutorial:tooltip#adding_tooltips_in_1215
        ItemTooltipCallback.EVENT.register tooltipCallback@{ itemStack, _, _, list ->
            val tooltipText = when (val item = itemStack.item) {
                is ClickManaitaBaseItem -> item.getTooltipText()
                is ClickManaitaCustomItem -> item.getTooltipText(itemStack)
                else -> return@tooltipCallback
            }
            list.add(tooltipText)
        }
    }
}