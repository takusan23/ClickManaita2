package io.github.takusan23.clickmanaita.enchant

import net.fabricmc.fabric.api.event.player.UseBlockCallback
import net.minecraft.util.ActionResult

/**
 * イベントを拾う
 *
 * クリックまな板エンチャントの実装はここ
 */
object ClickManaitaEnchantCallback {

    /** クリックイベントを登録する関数 */
    fun registerClickManaitaEnchantCallback() {
        UseBlockCallback.EVENT.register { playerEntity, world, hand, blockHitResult ->
//            // エンチャレベルとドロップ数
//            val enchantLevel = EnchantmentHelper.getLevel(ClickManaitaEnchant.CLICKMANAITA_ENCHANT, playerEntity.mainHandStack)
//            val dropSize = when (enchantLevel) {
//                1 -> 2
//                2 -> 4
//                3 -> 8
//                4 -> 16
//                5 -> 32
//                else -> 0
//            }
//
//            val blockPos = blockHitResult.blockPos
//            val state = world.getBlockState(blockPos)
//
//            // エンチャントついてないとき または スニークしてないでチェストクリック時 は即 return（クリックイベントを消費せずに）
//            if (dropSize == 0 || (state.hasBlockEntity() && !playerEntity.isSneaking)) {
//                return@register ActionResult.PASS
//            }
//
//            // 共通処理を呼び出す
//            ClickManaitaItemTool.manaita(
//                dropSize = dropSize,
//                world = world,
//                blockPos = blockPos,
//                playerEntity = playerEntity
//            )
//
//            // クリックイベントを消費した
            ActionResult.PASS
        }

    }

}