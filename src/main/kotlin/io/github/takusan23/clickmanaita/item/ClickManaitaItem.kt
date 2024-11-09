package io.github.takusan23.clickmanaita.item

import io.github.takusan23.clickmanaita.ClickManaitaItemGroup
import io.github.takusan23.clickmanaita.block.ClickManaitaBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

/**
 * クリックまな板　アイテム
 *
 * クリエタブ登録は [ClickManaitaItemGroup] で
 */
object ClickManaitaItem {

    // アイテムID
    private val ID_CLICKMANAITA_WOOD = Identifier.of("clickmanaita", "clickmanaita_wood")
    private val ID_CLICKMANAITA_STONE = Identifier.of("clickmanaita", "clickmanaita_stone")
    private val ID_CLICKMANAITA_IRON = Identifier.of("clickmanaita", "clickmanaita_iron")
    private val ID_CLICKMANAITA_GOLD = Identifier.of("clickmanaita", "clickmanaita_gold")
    private val ID_CLICKMANAITA_DIAMOND = Identifier.of("clickmanaita", "clickmanaita_diamond")
    private val ID_CLICKMANAITA_EMERALD = Identifier.of("clickmanaita", "clickmanaita_emerald")
    private val ID_CLICKMANAITA_CUSTOM = Identifier.of("clickmanaita", "clickmanaita_custom")

    // レジストリキー
    private val KEY_CLICKMANAITA_WOOD = RegistryKey.of(RegistryKeys.ITEM, ID_CLICKMANAITA_WOOD)
    private val KEY_CLICKMANAITA_STONE = RegistryKey.of(RegistryKeys.ITEM, ID_CLICKMANAITA_STONE)
    private val KEY_CLICKMANAITA_IRON = RegistryKey.of(RegistryKeys.ITEM, ID_CLICKMANAITA_IRON)
    private val KEY_CLICKMANAITA_GOLD = RegistryKey.of(RegistryKeys.ITEM, ID_CLICKMANAITA_GOLD)
    private val KEY_CLICKMANAITA_DIAMOND = RegistryKey.of(RegistryKeys.ITEM, ID_CLICKMANAITA_DIAMOND)
    private val KEY_CLICKMANAITA_EMERALD = RegistryKey.of(RegistryKeys.ITEM, ID_CLICKMANAITA_EMERALD)
    private val KEY_CLICKMANAITA_CUSTOM = RegistryKey.of(RegistryKeys.ITEM, ID_CLICKMANAITA_CUSTOM)

    // ブロックアイテム レジストリキー
    private val KEY_CLICKMANAITA_WOOD_BLOCK = RegistryKey.of(RegistryKeys.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_WOOD_BLOCK)
    private val KEY_CLICKMANAITA_STONE_BLOCK = RegistryKey.of(RegistryKeys.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_STONE_BLOCK)
    private val KEY_CLICKMANAITA_IRON_BLOCK = RegistryKey.of(RegistryKeys.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_IRON_BLOCK)
    private val KEY_CLICKMANAITA_GOLD_BLOCK = RegistryKey.of(RegistryKeys.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_GOLD_BLOCK)
    private val KEY_CLICKMANAITA_DIAMOND_BLOCK = RegistryKey.of(RegistryKeys.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_DIAMOND_BLOCK)
    private val KEY_CLICKMANAITA_EMERALD_BLOCK = RegistryKey.of(RegistryKeys.ITEM, ClickManaitaBlock.ID_CLICKMANAITA_EMERALD_BLOCK)

    /** 木製。2個増える */
    val CLICKMANAITA_WOOD = ClickManaitaBaseItem(settings = Item.Settings().registryKey(KEY_CLICKMANAITA_WOOD), dropSize = 2)

    /** 石製。4個増える */
    val CLICKMANAITA_STONE = ClickManaitaBaseItem(settings = Item.Settings().registryKey(KEY_CLICKMANAITA_STONE), dropSize = 4)

    /** 鉄製。8個増える */
    val CLICKMANAITA_IRON = ClickManaitaBaseItem(settings = Item.Settings().registryKey(KEY_CLICKMANAITA_IRON), dropSize = 8)

    /** 金製。16個増える */
    val CLICKMANAITA_GOLD = ClickManaitaBaseItem(settings = Item.Settings().registryKey(KEY_CLICKMANAITA_GOLD), dropSize = 16)

    /** ダイヤ製。32個増える */
    val CLICKMANAITA_DIAMOND = ClickManaitaBaseItem(settings = Item.Settings().registryKey(KEY_CLICKMANAITA_DIAMOND), dropSize = 32)

    /** エメラルド製。64個増える */
    val CLICKMANAITA_EMERALD = ClickManaitaBaseItem(settings = Item.Settings().registryKey(KEY_CLICKMANAITA_EMERALD), dropSize = 64)

    /** クリックまな板カスタム */
    val CLICKMANAITA_CUSTOM = ClickManaitaCustomItem(settings = Item.Settings().registryKey(KEY_CLICKMANAITA_CUSTOM))

    /** クリックまな板ブロック木製のアイテム */
    val CLICKMANAITA_WOOD_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_WOOD_BLOCK, Item.Settings().useBlockPrefixedTranslationKey().registryKey(KEY_CLICKMANAITA_WOOD_BLOCK))

    /** クリックまな板ブロック石製のアイテム */
    val CLICKMANAITA_STONE_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_STONE_BLOCK, Item.Settings().useBlockPrefixedTranslationKey().registryKey(KEY_CLICKMANAITA_STONE_BLOCK))

    /** クリックまな板ブロック鉄製のアイテム */
    val CLICKMANAITA_IRON_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_IRON_BLOCK, Item.Settings().useBlockPrefixedTranslationKey().registryKey(KEY_CLICKMANAITA_IRON_BLOCK))

    /** クリックまな板ブロック金製のアイテム */
    val CLICKMANAITA_GOLD_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_GOLD_BLOCK, Item.Settings().useBlockPrefixedTranslationKey().registryKey(KEY_CLICKMANAITA_GOLD_BLOCK))

    /** クリックまな板ブロックダイヤモンド製のアイテム */
    val CLICKMANAITA_DIAMOND_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_DIAMOND_BLOCK, Item.Settings().useBlockPrefixedTranslationKey().registryKey(KEY_CLICKMANAITA_DIAMOND_BLOCK))

    /** クリックまな板ブロックエメラルド製のアイテム */
    val CLICKMANAITA_EMERALD_BLOCK_ITEM = BlockItem(ClickManaitaBlock.CLICKMANAITA_EMERALD_BLOCK, Item.Settings().useBlockPrefixedTranslationKey().registryKey(KEY_CLICKMANAITA_EMERALD_BLOCK))

    /** アイテムを登録する */
    fun register() {
        // アイテム追加
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_WOOD, CLICKMANAITA_WOOD)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_STONE, CLICKMANAITA_STONE)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_IRON, CLICKMANAITA_IRON)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_GOLD, CLICKMANAITA_GOLD)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_DIAMOND, CLICKMANAITA_DIAMOND)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_EMERALD, CLICKMANAITA_EMERALD)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_CUSTOM, CLICKMANAITA_CUSTOM)

        // ブロックアイテム追加
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_WOOD_BLOCK, CLICKMANAITA_WOOD_BLOCK_ITEM)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_STONE_BLOCK, CLICKMANAITA_STONE_BLOCK_ITEM)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_IRON_BLOCK, CLICKMANAITA_IRON_BLOCK_ITEM)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_GOLD_BLOCK, CLICKMANAITA_GOLD_BLOCK_ITEM)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_DIAMOND_BLOCK, CLICKMANAITA_DIAMOND_BLOCK_ITEM)
        Registry.register(Registries.ITEM, KEY_CLICKMANAITA_EMERALD_BLOCK, CLICKMANAITA_EMERALD_BLOCK_ITEM)
    }

}