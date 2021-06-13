package io.github.takusan23.clickmanaita

import io.github.takusan23.clickmanaita.block.ClickManaitaBlock
import io.github.takusan23.clickmanaita.item.ClickManaitaItem
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// For support join https://discord.gg/v6v4pMv

@Suppress("unused")
fun init() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.

    // アイテム追加
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_wood"), ClickManaitaItem.CLICKMANAITA_WOOD)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_stone"), ClickManaitaItem.CLICKMANAITA_STONE)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_iron"), ClickManaitaItem.CLICKMANAITA_IRON)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_gold"), ClickManaitaItem.CLICKMANAITA_GOLD)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_diamond"), ClickManaitaItem.CLICKMANAITA_DIAMOND)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_emerald"), ClickManaitaItem.CLICKMANAITA_EMERALD)
    // ブロック追加
    Registry.register(Registry.BLOCK, Identifier("clickmanaita", "clickmanaita_block_wood"), ClickManaitaBlock.CLICKMANAITA_WOOD_BLOCK)
    Registry.register(Registry.BLOCK, Identifier("clickmanaita", "clickmanaita_block_stone"), ClickManaitaBlock.CLICKMANAITA_STONE_BLOCK)
    Registry.register(Registry.BLOCK, Identifier("clickmanaita", "clickmanaita_block_iron"), ClickManaitaBlock.CLICKMANAITA_IRON_BLOCK)
    Registry.register(Registry.BLOCK, Identifier("clickmanaita", "clickmanaita_block_gold"), ClickManaitaBlock.CLICKMANAITA_GOLD_BLOCK)
    Registry.register(Registry.BLOCK, Identifier("clickmanaita", "clickmanaita_block_diamond"), ClickManaitaBlock.CLICKMANAITA_DIAMOND_BLOCK)
    Registry.register(Registry.BLOCK, Identifier("clickmanaita", "clickmanaita_block_emerald"), ClickManaitaBlock.CLICKMANAITA_EMERALD_BLOCK)
    // ブロックアイテム追加
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_block_wood"), ClickManaitaItem.CLICKMANAITA_WOOD_BLOCK_ITEM)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_block_stone"), ClickManaitaItem.CLICKMANAITA_STONE_BLOCK_ITEM)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_block_iron"), ClickManaitaItem.CLICKMANAITA_IRON_BLOCK_ITEM)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_block_gold"), ClickManaitaItem.CLICKMANAITA_GOLD_BLOCK_ITEM)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_block_diamond"), ClickManaitaItem.CLICKMANAITA_DIAMOND_BLOCK_ITEM)
    Registry.register(Registry.ITEM, Identifier("clickmanaita", "clickmanaita_block_emerald"), ClickManaitaItem.CLICKMANAITA_EMERALD_BLOCK_ITEM)
}

