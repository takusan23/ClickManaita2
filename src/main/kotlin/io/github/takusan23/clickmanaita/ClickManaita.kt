package io.github.takusan23.clickmanaita

import io.github.takusan23.clickmanaita.block.ClickManaitaBlock
import io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchant
import io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchantCallback
import io.github.takusan23.clickmanaita.item.ClickManaitaItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

/**
 * エントリーポイント。起動時にinit関数が呼ばれる
 */
@Suppress("unused")
fun init() {
    // アイテム追加
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_wood"), ClickManaitaItem.CLICKMANAITA_WOOD)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_stone"), ClickManaitaItem.CLICKMANAITA_STONE)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_iron"), ClickManaitaItem.CLICKMANAITA_IRON)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_gold"), ClickManaitaItem.CLICKMANAITA_GOLD)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_diamond"), ClickManaitaItem.CLICKMANAITA_DIAMOND)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_emerald"), ClickManaitaItem.CLICKMANAITA_EMERALD)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_custom"), ClickManaitaItem.CLICKMANAITA_CUSTOM)
    // ブロック追加
    Registry.register(Registries.BLOCK, Identifier("clickmanaita", "clickmanaita_block_wood"), ClickManaitaBlock.CLICKMANAITA_WOOD_BLOCK)
    Registry.register(Registries.BLOCK, Identifier("clickmanaita", "clickmanaita_block_stone"), ClickManaitaBlock.CLICKMANAITA_STONE_BLOCK)
    Registry.register(Registries.BLOCK, Identifier("clickmanaita", "clickmanaita_block_iron"), ClickManaitaBlock.CLICKMANAITA_IRON_BLOCK)
    Registry.register(Registries.BLOCK, Identifier("clickmanaita", "clickmanaita_block_gold"), ClickManaitaBlock.CLICKMANAITA_GOLD_BLOCK)
    Registry.register(Registries.BLOCK, Identifier("clickmanaita", "clickmanaita_block_diamond"), ClickManaitaBlock.CLICKMANAITA_DIAMOND_BLOCK)
    Registry.register(Registries.BLOCK, Identifier("clickmanaita", "clickmanaita_block_emerald"), ClickManaitaBlock.CLICKMANAITA_EMERALD_BLOCK)

    // ブロックアイテム追加
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_block_wood"), ClickManaitaItem.CLICKMANAITA_WOOD_BLOCK_ITEM)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_block_stone"), ClickManaitaItem.CLICKMANAITA_STONE_BLOCK_ITEM)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_block_iron"), ClickManaitaItem.CLICKMANAITA_IRON_BLOCK_ITEM)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_block_gold"), ClickManaitaItem.CLICKMANAITA_GOLD_BLOCK_ITEM)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_block_diamond"), ClickManaitaItem.CLICKMANAITA_DIAMOND_BLOCK_ITEM)
    Registry.register(Registries.ITEM, Identifier("clickmanaita", "clickmanaita_block_emerald"), ClickManaitaItem.CLICKMANAITA_EMERALD_BLOCK_ITEM)

    // クリエタブ
    Registry.register(Registries.ITEM_GROUP, Identifier("clickmanaita", "clickmanaita_creative_tab"), ClickManaitaItemGroup.CLICKMANAITA_ITEMGROUP)

    // エンチャント追加とコールバック登録
    Registry.register(Registries.ENCHANTMENT, Identifier("clickmanaita", "clickmanaita_enchant"), ClickManaitaEnchant.CLICKMANAITA_ENCHANT)
    ClickManaitaEnchantCallback.registerClickManaitaEnchantCallback()
}

