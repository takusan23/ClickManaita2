package io.github.takusan23.clickmanaita

import io.github.takusan23.clickmanaita.item.ClickManaitaItem
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.world.item.ItemStack
import net.minecraft.network.chat.Component

/** クリックまな板クリエイティブタブ */
object ClickManaitaItemGroup {

    /** クリックまな板のクリエイティブタブ */
    val CLICKMANAITA_ITEMGROUP = FabricItemGroup.builder()
        .icon { ItemStack(ClickManaitaItem.CLICKMANAITA_WOOD) }
        .title(Component.translatable("itemGroup.clickmanaita.clickmanaita_creative_tab")) // displayName は明示的に呼び出す必要がある
        .displayItems { _, entries ->
            // アイテムを登録する
            entries.accept(ClickManaitaItem.CLICKMANAITA_WOOD)
            entries.accept(ClickManaitaItem.CLICKMANAITA_STONE)
            entries.accept(ClickManaitaItem.CLICKMANAITA_IRON)
            entries.accept(ClickManaitaItem.CLICKMANAITA_GOLD)
            entries.accept(ClickManaitaItem.CLICKMANAITA_DIAMOND)
            entries.accept(ClickManaitaItem.CLICKMANAITA_EMERALD)
            entries.accept(ClickManaitaItem.CLICKMANAITA_CUSTOM)
            entries.accept(ClickManaitaItem.CLICKMANAITA_WOOD_BLOCK_ITEM)
            entries.accept(ClickManaitaItem.CLICKMANAITA_STONE_BLOCK_ITEM)
            entries.accept(ClickManaitaItem.CLICKMANAITA_IRON_BLOCK_ITEM)
            entries.accept(ClickManaitaItem.CLICKMANAITA_GOLD_BLOCK_ITEM)
            entries.accept(ClickManaitaItem.CLICKMANAITA_DIAMOND_BLOCK_ITEM)
            entries.accept(ClickManaitaItem.CLICKMANAITA_EMERALD_BLOCK_ITEM)
        }
        .build()

}