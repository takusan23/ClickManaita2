package io.github.takusan23.clickmanaita.block

import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceKey
import net.minecraft.core.registries.Registries
import net.minecraft.world.level.block.SoundType
import net.minecraft.resources.Identifier

/** クリックまな板で追加するブロック */
object ClickManaitaBlock {

    // ブロックID。ブロックアイテム登録で使うため public
    val ID_CLICKMANAITA_WOOD_BLOCK = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_block_wood")
    val ID_CLICKMANAITA_STONE_BLOCK = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_block_stone")
    val ID_CLICKMANAITA_IRON_BLOCK = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_block_iron")
    val ID_CLICKMANAITA_GOLD_BLOCK = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_block_gold")
    val ID_CLICKMANAITA_DIAMOND_BLOCK = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_block_diamond")
    val ID_CLICKMANAITA_EMERALD_BLOCK = Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_block_emerald")

    // レジストリキー
    private val KEY_CLICKMANAITA_WOOD_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_WOOD_BLOCK)
    private val KEY_CLICKMANAITA_STONE_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_STONE_BLOCK)
    private val KEY_CLICKMANAITA_IRON_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_IRON_BLOCK)
    private val KEY_CLICKMANAITA_GOLD_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_GOLD_BLOCK)
    private val KEY_CLICKMANAITA_DIAMOND_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_DIAMOND_BLOCK)
    private val KEY_CLICKMANAITA_EMERALD_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_EMERALD_BLOCK)

    /** 木製。2個増える */
    val CLICKMANAITA_WOOD_BLOCK = ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava().setId(KEY_CLICKMANAITA_WOOD_BLOCK), 2)

    /** 石製。4個増える */
    val CLICKMANAITA_STONE_BLOCK = ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).setId(KEY_CLICKMANAITA_STONE_BLOCK), 4)

    /** 鉄製。8個増える */
    val CLICKMANAITA_IRON_BLOCK = ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).setId(KEY_CLICKMANAITA_IRON_BLOCK), 8)

    /** 金製。16個増える */
    val CLICKMANAITA_GOLD_BLOCK = ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BELL).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).setId(KEY_CLICKMANAITA_GOLD_BLOCK), 16)

    /** ダイヤ製。32個増える */
    val CLICKMANAITA_DIAMOND_BLOCK = ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).setId(KEY_CLICKMANAITA_DIAMOND_BLOCK), 32)

    /** エメラルド製。64個増える */
    val CLICKMANAITA_EMERALD_BLOCK = ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).instrument(NoteBlockInstrument.BIT).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).setId(KEY_CLICKMANAITA_EMERALD_BLOCK), 64)

    /** ブロックを登録する */
    fun register() {
        Registry.register(BuiltInRegistries.BLOCK, KEY_CLICKMANAITA_WOOD_BLOCK, CLICKMANAITA_WOOD_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, KEY_CLICKMANAITA_STONE_BLOCK, CLICKMANAITA_STONE_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, KEY_CLICKMANAITA_IRON_BLOCK, CLICKMANAITA_IRON_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, KEY_CLICKMANAITA_GOLD_BLOCK, CLICKMANAITA_GOLD_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, KEY_CLICKMANAITA_DIAMOND_BLOCK, CLICKMANAITA_DIAMOND_BLOCK)
        Registry.register(BuiltInRegistries.BLOCK, KEY_CLICKMANAITA_EMERALD_BLOCK, CLICKMANAITA_EMERALD_BLOCK)
    }
}