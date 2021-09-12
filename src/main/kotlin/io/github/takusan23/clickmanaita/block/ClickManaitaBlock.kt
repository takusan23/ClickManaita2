package io.github.takusan23.clickmanaita.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Material

/** クリックまな板で追加するブロック */
object ClickManaitaBlock {

    /** 木製。2個増える */
    val CLICKMANAITA_WOOD_BLOCK = ClickManaitaBaseBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5F), 2)

    /** 石製。4個増える */
    val CLICKMANAITA_STONE_BLOCK = ClickManaitaBaseBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.5F), 4)

    /** 鉄製。8個増える */
    val CLICKMANAITA_IRON_BLOCK = ClickManaitaBaseBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(5.0F, 6.0F), 8)

    /** 金製。16個増える */
    val CLICKMANAITA_GOLD_BLOCK = ClickManaitaBaseBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(3.0F, 6.0F), 16)

    /** ダイヤ製。32個増える */
    val CLICKMANAITA_DIAMOND_BLOCK = ClickManaitaBaseBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(5.0F, 6.0F), 32)

    /** エメラルド製。64個増える */
    val CLICKMANAITA_EMERALD_BLOCK = ClickManaitaBaseBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(5.0F, 6.0F), 64)

}