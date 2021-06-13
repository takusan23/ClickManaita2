package io.github.takusan23.clickmanaita

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.StackReference
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.screen.slot.Slot
import net.minecraft.util.ClickType

/** クリックまな板　アイテム */
object ClickManaitaItem {

    /** 木製。2個増える */
    val CLICKMANAITA_WOOD = ClickManaitaBaseItem(settings = FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB), dropSize = 2)

    /** 石製。4個増える */
    val CLICKMANAITA_STONE = ClickManaitaBaseItem(settings = FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB), dropSize = 4)

    /** 鉄製。8個増える */
    val CLICKMANAITA_IRON = ClickManaitaBaseItem(settings = FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB), dropSize = 8)

    /** 金製。16個増える */
    val CLICKMANAITA_GOLD = ClickManaitaBaseItem(settings = FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB), dropSize = 16)

    /** ダイヤ製。32個増える */
    val CLICKMANAITA_DIAMOND = ClickManaitaBaseItem(settings = FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB), dropSize = 32)

    /** エメラルド製。64個増える */
    val CLICKMANAITA_EMERALD = ClickManaitaBaseItem(settings = FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB), dropSize = 64)

}