package io.github.takusan23.clickmanaita.block

import net.minecraft.block.AbstractBlock
import net.minecraft.block.MapColor
import net.minecraft.block.enums.NoteBlockInstrument
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

/** クリックまな板で追加するブロック */
object ClickManaitaBlock {

    // ブロックID。ブロックアイテム登録で使うため public
    val ID_CLICKMANAITA_WOOD_BLOCK = Identifier.of("clickmanaita", "clickmanaita_block_wood")
    val ID_CLICKMANAITA_STONE_BLOCK = Identifier.of("clickmanaita", "clickmanaita_block_stone")
    val ID_CLICKMANAITA_IRON_BLOCK = Identifier.of("clickmanaita", "clickmanaita_block_iron")
    val ID_CLICKMANAITA_GOLD_BLOCK = Identifier.of("clickmanaita", "clickmanaita_block_gold")
    val ID_CLICKMANAITA_DIAMOND_BLOCK = Identifier.of("clickmanaita", "clickmanaita_block_diamond")
    val ID_CLICKMANAITA_EMERALD_BLOCK = Identifier.of("clickmanaita", "clickmanaita_block_emerald")

    // レジストリキー
    private val KEY_CLICKMANAITA_WOOD_BLOCK = RegistryKey.of(RegistryKeys.BLOCK, ID_CLICKMANAITA_WOOD_BLOCK)
    private val KEY_CLICKMANAITA_STONE_BLOCK = RegistryKey.of(RegistryKeys.BLOCK, ID_CLICKMANAITA_STONE_BLOCK)
    private val KEY_CLICKMANAITA_IRON_BLOCK = RegistryKey.of(RegistryKeys.BLOCK, ID_CLICKMANAITA_IRON_BLOCK)
    private val KEY_CLICKMANAITA_GOLD_BLOCK = RegistryKey.of(RegistryKeys.BLOCK, ID_CLICKMANAITA_GOLD_BLOCK)
    private val KEY_CLICKMANAITA_DIAMOND_BLOCK = RegistryKey.of(RegistryKeys.BLOCK, ID_CLICKMANAITA_DIAMOND_BLOCK)
    private val KEY_CLICKMANAITA_EMERALD_BLOCK = RegistryKey.of(RegistryKeys.BLOCK, ID_CLICKMANAITA_EMERALD_BLOCK)

    /** 木製。2個増える */
    val CLICKMANAITA_WOOD_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.5F).sounds(BlockSoundGroup.WOOD).burnable().registryKey(KEY_CLICKMANAITA_WOOD_BLOCK), 2)

    /** 石製。4個増える */
    val CLICKMANAITA_STONE_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F).registryKey(KEY_CLICKMANAITA_STONE_BLOCK), 4)

    /** 鉄製。8個増える */
    val CLICKMANAITA_IRON_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).registryKey(KEY_CLICKMANAITA_IRON_BLOCK), 8)

    /** 金製。16個増える */
    val CLICKMANAITA_GOLD_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BELL).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.METAL).registryKey(KEY_CLICKMANAITA_GOLD_BLOCK), 16)

    /** ダイヤ製。32個増える */
    val CLICKMANAITA_DIAMOND_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).registryKey(KEY_CLICKMANAITA_DIAMOND_BLOCK), 32)

    /** エメラルド製。64個増える */
    val CLICKMANAITA_EMERALD_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).instrument(NoteBlockInstrument.BIT).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).registryKey(KEY_CLICKMANAITA_EMERALD_BLOCK), 64)

    /** ブロックを登録する */
    fun register() {
        Registry.register(Registries.BLOCK, KEY_CLICKMANAITA_WOOD_BLOCK, CLICKMANAITA_WOOD_BLOCK)
        Registry.register(Registries.BLOCK, KEY_CLICKMANAITA_STONE_BLOCK, CLICKMANAITA_STONE_BLOCK)
        Registry.register(Registries.BLOCK, KEY_CLICKMANAITA_IRON_BLOCK, CLICKMANAITA_IRON_BLOCK)
        Registry.register(Registries.BLOCK, KEY_CLICKMANAITA_GOLD_BLOCK, CLICKMANAITA_GOLD_BLOCK)
        Registry.register(Registries.BLOCK, KEY_CLICKMANAITA_DIAMOND_BLOCK, CLICKMANAITA_DIAMOND_BLOCK)
        Registry.register(Registries.BLOCK, KEY_CLICKMANAITA_EMERALD_BLOCK, CLICKMANAITA_EMERALD_BLOCK)
    }
}