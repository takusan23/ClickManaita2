package io.github.takusan23.clickmanaita

import io.github.takusan23.clickmanaita.item.ClickManaitaTooltipEventCallback

/**
 * エントリーポイント。起動時に initClient 関数が呼ばれる
 * クライアント専用処理を書く
 */
@Suppress("unused")
fun initClient() {
    // イベント登録
    ClickManaitaTooltipEventCallback.registerTooltipEventCallback()
}