package io.github.takusan23.clickmanaita

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier

/** クリックまな板クリエイティブタブ */
object ClickManaitaItemGroup {

    /** クリエイティブタブ */
    val CREATIVE_TAB: ItemGroup = FabricItemGroupBuilder.create(Identifier("clickmanaita", "creative_tab"))
        .icon { ItemStack(ClickManaitaItem.CLICKMANAITA_WOOD) }
        .build()

}