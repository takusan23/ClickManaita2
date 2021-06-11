package io.github.takusan23.clickmanaita

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.StackReference
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.screen.slot.Slot
import net.minecraft.util.ClickType

object ClickManaitaItem {

    /** 右クリックしたらアイテムが増える */
    val CLICKMANAITA_WOOD = ClickManaitaBaseItem(settings = FabricItemSettings().group(ItemGroup.TOOLS), dropSize = 2)

}