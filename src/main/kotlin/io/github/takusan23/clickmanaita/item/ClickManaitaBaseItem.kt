package io.github.takusan23.clickmanaita.item

import net.minecraft.block.Block
import net.minecraft.client.item.TooltipContext
import net.minecraft.inventory.Inventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.loot.LootTables
import net.minecraft.text.MutableText
import net.minecraft.text.PlainTextContent
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Formatting
import net.minecraft.world.World

/**
 * 右クリックしたらアイテムが増えるアイテムを追加する
 *
 * @param settings クリエタブとか
 * @param dropSize 増える数
 * */
open class ClickManaitaBaseItem(settings: Settings?, private val dropSize: Int = 2) : Item(settings) {

    /**
     * ブロックを右クリックしたときに呼ばれる関数
     * */
    override fun useOnBlock(context: ItemUsageContext?): ActionResult {
        val world = context?.world
        val blockPos = context?.blockPos
        val state = world?.getBlockState(blockPos)
        val copyBlock = state?.block
        val blockEntity = world?.getBlockEntity(blockPos)
        // アイテム化するかどうか
        val isNotItemDrop = copyBlock?.getPickStack(world, blockPos, state) == ItemStack.EMPTY || copyBlock?.lootTableId == LootTables.EMPTY

        repeat(dropSize) {
            if (isNotItemDrop) {
                // アイテムを落とさない場合（スポナーなど
                val copyItem = ItemStack(copyBlock?.asItem())
                // NBTタグを移す
                val nbtCompound = blockEntity?.createNbt()
                if (nbtCompound?.isEmpty == false) {
                    copyItem.setSubNbt("BlockEntityTag", nbtCompound.copy())
                }
                Block.dropStack(world, blockPos, copyItem)
            }
            // チェストの中身も増やす
            if (blockEntity is Inventory) {
                repeat(blockEntity.size()) { invIndex ->
                    Block.dropStack(world, blockPos, blockEntity.getStack(invIndex).copy())
                }
            }
            // ブロックを増やす
            copyBlock?.afterBreak(world, context.player, blockPos, state, blockEntity, context.player?.mainHandStack)
        }
        return ActionResult.SUCCESS
    }

    /**
     * ツールチップ追加
     * */
    override fun appendTooltip(stack: ItemStack?, world: World?, tooltip: MutableList<Text>?, context: TooltipContext?) {
        super.appendTooltip(stack, world, tooltip, context)
        tooltip?.add(MutableText.of(PlainTextContent.of("x$dropSize")).setStyle(Style.EMPTY.withColor(Formatting.AQUA)))
    }

}