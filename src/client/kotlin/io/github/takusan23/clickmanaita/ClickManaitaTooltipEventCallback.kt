package io.github.takusan23.clickmanaita

import io.github.takusan23.clickmanaita.item.ClickManaitaBaseItem
import io.github.takusan23.clickmanaita.item.ClickManaitaCustomItem
import io.github.takusan23.clickmanaita.item.ManaitaEquipment
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component

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
                ManaitaEquipment.SWORD -> Component.translatable("tooltip.clickmanaita.manaita_sword")
                ManaitaEquipment.GOD_SWORD -> Component.translatable("tooltip.clickmanaita.manaita_god_sword")
                ManaitaEquipment.BOW -> Component.translatable("tooltip.clickmanaita.manaita_bow")
                ManaitaEquipment.PICKAXE,
                ManaitaEquipment.AXE,
                ManaitaEquipment.SHOVEL,
                ManaitaEquipment.HOE,
                ManaitaEquipment.PAXEL,
                ManaitaEquipment.SHEARS -> Component.translatable("tooltip.clickmanaita.manaita_tool")
                ManaitaEquipment.HELMET -> Component.translatable("tooltip.clickmanaita.manaita_helmet")
                ManaitaEquipment.CHESTPLATE -> Component.translatable("tooltip.clickmanaita.manaita_chestplate")
                ManaitaEquipment.LEGGINGS -> Component.translatable("tooltip.clickmanaita.manaita_leggings")
                ManaitaEquipment.BOOTS -> Component.translatable("tooltip.clickmanaita.manaita_boots")
                else -> return@tooltipCallback
            }
            list.add(tooltipText.withStyle(ChatFormatting.AQUA))
        }
    }
}
