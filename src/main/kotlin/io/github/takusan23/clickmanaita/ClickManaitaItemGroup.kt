package io.github.takusan23.clickmanaita

import io.github.takusan23.clickmanaita.item.ClickManaitaItem
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

/** クリックまな板クリエイティブタブ */
object ClickManaitaItemGroup {

    /** クリエイティブタブを登録する */
    fun registerCreativeTab() {
        FabricItemGroup.builder(Identifier("clickmanaita", "clickmanaita_creative_tab"))
            .icon { ItemStack(ClickManaitaItem.CLICKMANAITA_WOOD) }
            .entries { _, entries ->
                // アイテムを登録する
                entries.add(ClickManaitaItem.CLICKMANAITA_WOOD)
                entries.add(ClickManaitaItem.CLICKMANAITA_STONE)
                entries.add(ClickManaitaItem.CLICKMANAITA_IRON)
                entries.add(ClickManaitaItem.CLICKMANAITA_GOLD)
                entries.add(ClickManaitaItem.CLICKMANAITA_DIAMOND)
                entries.add(ClickManaitaItem.CLICKMANAITA_EMERALD)
                entries.add(ClickManaitaItem.CLICKMANAITA_CUSTOM)
                entries.add(ClickManaitaItem.CLICKMANAITA_WOOD_BLOCK_ITEM)
                entries.add(ClickManaitaItem.CLICKMANAITA_STONE_BLOCK_ITEM)
                entries.add(ClickManaitaItem.CLICKMANAITA_IRON_BLOCK_ITEM)
                entries.add(ClickManaitaItem.CLICKMANAITA_GOLD_BLOCK_ITEM)
                entries.add(ClickManaitaItem.CLICKMANAITA_DIAMOND_BLOCK_ITEM)
                entries.add(ClickManaitaItem.CLICKMANAITA_EMERALD_BLOCK_ITEM)
            }
            .build()
    }

}