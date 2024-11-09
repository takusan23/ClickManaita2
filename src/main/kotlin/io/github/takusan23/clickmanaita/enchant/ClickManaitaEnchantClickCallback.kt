package io.github.takusan23.clickmanaita.enchant

import net.fabricmc.fabric.api.event.player.UseBlockCallback
import net.minecraft.block.BlockState
import net.minecraft.component.DataComponentTypes
import net.minecraft.component.type.ItemEnchantmentsComponent
import net.minecraft.enchantment.EnchantmentEffectContext
import net.minecraft.enchantment.effect.EnchantmentEffectEntry
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.loot.context.LootContext
import net.minecraft.loot.context.LootContextParameters
import net.minecraft.loot.context.LootContextTypes
import net.minecraft.loot.context.LootWorldContext
import net.minecraft.server.world.ServerWorld
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.math.Vec3d
import java.util.*

/** ブロックをクリックしたイベントを拾う */
object ClickManaitaEnchantClickCallback {

    /** クリックイベントを登録する関数 */
    fun registerClickManaitaEnchantCallback() {
        UseBlockCallback.EVENT.register { playerEntity, world, hand, blockHitResult ->
            val blockPos = blockHitResult.blockPos
            val blockState = world.getBlockState(blockPos)
            val blockPosVec3d = blockPos.toCenterPos()
            // 持ち手によって分岐
            val currentItem = when (hand) {
                Hand.MAIN_HAND -> playerEntity.mainHandStack
                Hand.OFF_HAND -> playerEntity.offHandStack
                else -> return@register ActionResult.PASS
            }

            // サーバー側
            if (world !is ServerWorld) return@register ActionResult.PASS

            // スニークしてないでチェストクリック時 は即 return（クリックイベントを消費せずに）
            if (!playerEntity.isSneaking && blockState.hasBlockEntity()) return@register ActionResult.PASS

            // ドア（とその亜種）をクリックした場合、開けるのを優先。でもスニーク状態ならやらない
            if (!playerEntity.isSneaking && blockState.contains(Properties.OPEN)) return@register ActionResult.PASS

            // SUCCESS にすると腕を振るう
            var clickResult:ActionResult = ActionResult.PASS

            // clickmanaita:block_right_click エフェクトコンポーネントを呼び出す
            // 動作は minecraft:hit_block のそれと同じ、それの右クリック板。
            val itemEnchantmentsComponent = currentItem.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT)
            val enchantmentEffectContext = EnchantmentEffectContext(currentItem, EquipmentSlot.MAINHAND, playerEntity) { playerEntity.sendEquipmentBreakStatus(it, EquipmentSlot.MAINHAND) }
            itemEnchantmentsComponent.enchantmentEntries.forEach { (enchant, level) ->
                val effectEntries = enchant.value().getEffect(EnchantRightClickEffectComponent.BLOCK_RIGHT_CLICK_EFFECT_COMPONENT)
                applyEffects(
                    entries = effectEntries,
                    lootContext = createHitBlockLootContext(world, level, playerEntity, blockPosVec3d, blockState),
                    onEffect = { effect ->
                        clickResult = ActionResult.SUCCESS
                        effect.apply(world, level, enchantmentEffectContext, playerEntity, blockPosVec3d)
                    }
                )
            }

            clickResult
        }
    }

    private fun createHitBlockLootContext(world: ServerWorld, level: Int, entity: Entity, pos: Vec3d, state: BlockState): LootContext {
        val lootContextParameterSet = LootWorldContext.Builder(world)
            .add(LootContextParameters.THIS_ENTITY, entity)
            .add(LootContextParameters.ENCHANTMENT_LEVEL, level)
            .add(LootContextParameters.ORIGIN, pos)
            .add(LootContextParameters.BLOCK_STATE, state)
            .build(LootContextTypes.HIT_BLOCK)
        return LootContext.Builder(lootContextParameterSet).build(Optional.empty())
    }

    private fun <T> applyEffects(
        entries: List<EnchantmentEffectEntry<T>>,
        lootContext: LootContext,
        onEffect: (T) -> Unit
    ) {
        entries
            .filter { it.test(lootContext) }
            .forEach { onEffect(it.effect()) }
    }
}