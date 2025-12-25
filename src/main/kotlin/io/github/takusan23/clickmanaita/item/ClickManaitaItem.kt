package io.github.takusan23.clickmanaita.item

import io.github.takusan23.clickmanaita.ClickManaitaItemGroup
import io.github.takusan23.clickmanaita.block.ClickManaitaBlock
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceKey
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier

/**
 * クリックまな板　アイテム
 *
 * クリエタブ登録は [ClickManaitaItemGroup] で
 */
object ClickManaitaItem {

    // アイテムID
    private val ID_CLICKMANAITA_WOOD = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_wood")
    private val ID_CLICKMANAITA_STONE = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_stone")
    private val ID_CLICKMANAITA_IRON = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_iron")
    private val ID_CLICKMANAITA_GOLD = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_gold")
    private val ID_CLICKMANAITA_DIAMOND = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_diamond")
    private val ID_CLICKMANAITA_EMERALD = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_emerald")
    private val ID_CLICKMANAITA_CUSTOM = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_custom")

    // レジストリキー
    private val KEY_CLICKMANAITA_WOOD = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_WOOD)
    private val KEY_CLICKMANAITA_STONE = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_STONE)
    private val KEY_CLICKMANAITA_IRON = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_IRON)
    private val KEY_CLICKMANAITA_GOLD = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_GOLD)
    private val KEY_CLICKMANAITA_DIAMOND = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_DIAMOND)
    private val KEY_CLICKMANAITA_EMERALD = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_EMERALD)
    private val KEY_CLICKMANAITA_CUSTOM = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_CUSTOM)

    // ブロックアイテム レジストリキー
    private val KEY_CLICKMANAITA_WOOD_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_WOOD_BLOCK)
    private val KEY_CLICKMANAITA_STONE_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_STONE_BLOCK)
    private val KEY_CLICKMANAITA_IRON_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_IRON_BLOCK)
    private val KEY_CLICKMANAITA_GOLD_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_GOLD_BLOCK)
    private val KEY_CLICKMANAITA_DIAMOND_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_DIAMOND_BLOCK)
    private val KEY_CLICKMANAITA_EMERALD_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_EMERALD_BLOCK)

    /** 木製。2個増える */
    val CLICKMANAITA_WOOD = ClickManaitaBaseItem(settings = Item.Properties().setId(KEY_CLICKMANAITA_WOOD), dropSize = 2)

    /** 石製。4個増える */
    val CLICKMANAITA_STONE = ClickManaitaBaseItem(settings = Item.Properties().setId(KEY_CLICKMANAITA_STONE), dropSize = 4)

    /** 鉄製。8個増える */
    val CLICKMANAITA_IRON = ClickManaitaBaseItem(settings = Item.Properties().setId(KEY_CLICKMANAITA_IRON), dropSize = 8)

    /** 金製。16個増える */
    val CLICKMANAITA_GOLD = ClickManaitaBaseItem(settings = Item.Properties().setId(KEY_CLICKMANAITA_GOLD), dropSize = 16)

    /** ダイヤ製。32個増える */
    val CLICKMANAITA_DIAMOND = ClickManaitaBaseItem(settings = Item.Properties().setId(KEY_CLICKMANAITA_DIAMOND), dropSize = 32)

    /** エメラルド製。64個増える */
    val CLICKMANAITA_EMERALD = ClickManaitaBaseItem(settings = Item.Properties().setId(KEY_CLICKMANAITA_EMERALD), dropSize = 64)

    /** クリックまな板カスタム */
    val CLICKMANAITA_CUSTOM = ClickManaitaCustomItem(settings = Item.Properties().setId(KEY_CLICKMANAITA_CUSTOM))

    /** クリックまな板ブロック木製のアイテム */
    val CLICKMANAITA_WOOD_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_WOOD_BLOCK, Item.Properties().useBlockDescriptionPrefix().setId(KEY_CLICKMANAITA_WOOD_BLOCK))

    /** クリックまな板ブロック石製のアイテム */
    val CLICKMANAITA_STONE_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_STONE_BLOCK, Item.Properties().useBlockDescriptionPrefix().setId(KEY_CLICKMANAITA_STONE_BLOCK))

    /** クリックまな板ブロック鉄製のアイテム */
    val CLICKMANAITA_IRON_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_IRON_BLOCK, Item.Properties().useBlockDescriptionPrefix().setId(KEY_CLICKMANAITA_IRON_BLOCK))

    /** クリックまな板ブロック金製のアイテム */
    val CLICKMANAITA_GOLD_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_GOLD_BLOCK, Item.Properties().useBlockDescriptionPrefix().setId(KEY_CLICKMANAITA_GOLD_BLOCK))

    /** クリックまな板ブロックダイヤモンド製のアイテム */
    val CLICKMANAITA_DIAMOND_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_DIAMOND_BLOCK, Item.Properties().useBlockDescriptionPrefix().setId(KEY_CLICKMANAITA_DIAMOND_BLOCK))

    /** クリックまな板ブロックエメラルド製のアイテム */
    val CLICKMANAITA_EMERALD_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_EMERALD_BLOCK, Item.Properties().useBlockDescriptionPrefix().setId(KEY_CLICKMANAITA_EMERALD_BLOCK))

    /** アイテムを登録する */
    fun register() {
        // アイテム追加
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_WOOD, CLICKMANAITA_WOOD)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_STONE, CLICKMANAITA_STONE)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_IRON, CLICKMANAITA_IRON)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_GOLD, CLICKMANAITA_GOLD)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_DIAMOND, CLICKMANAITA_DIAMOND)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_EMERALD, CLICKMANAITA_EMERALD)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_CUSTOM, CLICKMANAITA_CUSTOM)

        // ブロックアイテム追加
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_WOOD_BLOCK, CLICKMANAITA_WOOD_BLOCK_ITEM)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_STONE_BLOCK, CLICKMANAITA_STONE_BLOCK_ITEM)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_IRON_BLOCK, CLICKMANAITA_IRON_BLOCK_ITEM)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_GOLD_BLOCK, CLICKMANAITA_GOLD_BLOCK_ITEM)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_DIAMOND_BLOCK, CLICKMANAITA_DIAMOND_BLOCK_ITEM)
        Registry.register(BuiltInRegistries.ITEM, KEY_CLICKMANAITA_EMERALD_BLOCK, CLICKMANAITA_EMERALD_BLOCK_ITEM)
    }

}