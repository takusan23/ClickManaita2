package io.github.takusan23.clickmanaita.enchant

import net.fabricmc.fabric.api.event.player.UseBlockCallback
import net.minecraft.block.Block
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.loot.LootTables
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.world.World

/**
 * イベントを拾う
 *
 * クリックまな板エンチャントの実装はここ
 * */
object ClickManaitaEnchantCallback {

    /** クリックイベントを登録する関数 */
    fun registerClickManaitaEnchantCallback() {
        UseBlockCallback.EVENT.register { playerEntity: PlayerEntity, world: World, hand: Hand, blockHitResult: BlockHitResult ->
            // エンチャレベルとドロップ数
            val enchantLevel = EnchantmentHelper.getLevel(ClickManaitaEnchant.CLICKMANAITA_ENCHANT, playerEntity.mainHandStack)
            val dropSize = when (enchantLevel) {
                1 -> 2
                2 -> 4
                3 -> 8
                4 -> 16
                5 -> 32
                else -> 0
            }

            val blockPos = blockHitResult.blockPos
            val state = world.getBlockState(blockPos)
            val copyBlock = state?.block
            val blockEntity = world.getBlockEntity(blockPos)
            // アイテム化するかどうか
            val isNotItemDrop = copyBlock?.getPickStack(world, blockPos, state) == ItemStack.EMPTY || copyBlock?.lootTableId == LootTables.EMPTY

            if (dropSize == 0 || (state.hasBlockEntity() && !playerEntity.isSneaking)) {
                return@register ActionResult.PASS // エンチャントついてないとき または スニークしてないでチェストクリック時 は即return（クリックイベントを消費せずに）
            }

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
                copyBlock?.afterBreak(world, playerEntity, blockPos, state, blockEntity, playerEntity.mainHandStack)
            }
            ActionResult.SUCCESS // クリックイベントを消費した
        }

    }

}