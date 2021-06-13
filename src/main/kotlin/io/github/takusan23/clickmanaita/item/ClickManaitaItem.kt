package io.github.takusan23.clickmanaita.item

import io.github.takusan23.clickmanaita.ClickManaitaItemGroup
import io.github.takusan23.clickmanaita.block.ClickManaitaBlock
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.BlockItem

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

    /** クリックまな板ブロック木製のアイテム */
    val CLICKMANAITA_WOOD_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_WOOD_BLOCK, FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB))

    /** クリックまな板ブロック石製のアイテム */
    val CLICKMANAITA_STONE_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_STONE_BLOCK, FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB))

    /** クリックまな板ブロック鉄製のアイテム */
    val CLICKMANAITA_IRON_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_IRON_BLOCK, FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB))

    /** クリックまな板ブロック金製のアイテム */
    val CLICKMANAITA_GOLD_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_GOLD_BLOCK, FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB))

    /** クリックまな板ブロックダイヤモンド製のアイテム */
    val CLICKMANAITA_DIAMOND_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_DIAMOND_BLOCK, FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB))

    /** クリックまな板ブロックエメラルド製のアイテム */
    val CLICKMANAITA_EMERALD_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_EMERALD_BLOCK, FabricItemSettings().group(ClickManaitaItemGroup.CREATIVE_TAB))

}