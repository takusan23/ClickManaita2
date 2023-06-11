package io.github.takusan23.clickmanaita.block

import net.minecraft.block.AbstractBlock
import net.minecraft.block.MapColor
import net.minecraft.block.enums.Instrument
import net.minecraft.sound.BlockSoundGroup

/** クリックまな板で追加するブロック */
object ClickManaitaBlock {

    /** 木製。2個増える */
    val CLICKMANAITA_WOOD_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).strength(2.5F).sounds(BlockSoundGroup.WOOD).burnable(), 2)

    /** 石製。4個増える */
    val CLICKMANAITA_STONE_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F), 4)

    /** 鉄製。8個増える */
    val CLICKMANAITA_IRON_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL), 8)

    /** 金製。16個増える */
    val CLICKMANAITA_GOLD_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.GOLD).instrument(Instrument.BELL).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.METAL), 16)

    /** ダイヤ製。32個増える */
    val CLICKMANAITA_DIAMOND_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL), 32)

    /** エメラルド製。64個増える */
    val CLICKMANAITA_EMERALD_BLOCK = ClickManaitaBaseBlock(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).instrument(Instrument.BIT).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL), 64)

}