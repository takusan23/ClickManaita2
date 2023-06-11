package io.github.takusan23.clickmanaita

import io.github.takusan23.clickmanaita.item.ClickManaitaItem
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.text.Text

/** クリックまな板クリエイティブタブ */
object ClickManaitaItemGroup {

    /** クリックまな板のクリエイティブタブ */
    val CLICKMANAITA_ITEMGROUP = FabricItemGroup.builder()
        .icon { ItemStack(ClickManaitaItem.CLICKMANAITA_WOOD) }
        .displayName(Text.translatable("itemGroup.clickmanaita.clickmanaita_creative_tab")) // displayName は明示的に呼び出す必要がある
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