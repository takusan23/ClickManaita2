package io.github.takusan23.clickmanaita.enchant

import net.fabricmc.fabric.api.event.player.UseBlockCallback
import net.minecraft.core.component.DataComponents
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.enchantment.ConditionalEffect
import net.minecraft.world.item.enchantment.EnchantedItemInUse
import net.minecraft.world.item.enchantment.ItemEnchantments
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.storage.loot.LootContext
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.minecraft.world.level.storage.loot.parameters.LootContextParams
import net.minecraft.world.phys.Vec3
import java.util.*

/** ブロックをクリックしたイベントを拾う */
object ClickManaitaEnchantClickCallback {

    /** クリックイベントを登録する関数 */
    fun registerClickManaitaEnchantCallback() {
        UseBlockCallback.EVENT.register { playerEntity, world, hand, blockHitResult ->
            val blockPos = blockHitResult.blockPos
            val blockState = world.getBlockState(blockPos)
            val blockPosVec3d = Vec3.atCenterOf(blockPos)
            // 持ち手によって分岐
            val currentItem = when (hand) {
                InteractionHand.MAIN_HAND -> playerEntity.mainHandItem
                InteractionHand.OFF_HAND -> playerEntity.offhandItem
                else -> return@register InteractionResult.PASS
            }

            // サーバー側
            if (world !is ServerLevel) return@register InteractionResult.PASS

            // スニークしてないでチェストクリック時 は即 return（クリックイベントを消費せずに）
            if (!playerEntity.isShiftKeyDown && blockState.hasBlockEntity()) return@register InteractionResult.PASS

            // ドア（とその亜種）をクリックした場合、開けるのを優先。でもスニーク状態ならやらない
            if (!playerEntity.isShiftKeyDown && blockState.hasProperty(BlockStateProperties.OPEN)) return@register InteractionResult.PASS

            // SUCCESS にすると腕を振るう
            var clickResult: InteractionResult = InteractionResult.PASS

            // clickmanaita:block_right_click エフェクトコンポーネントを呼び出す
            // 動作は minecraft:hit_block のそれと同じ、それの右クリック板。
            val itemEnchantmentsComponent = currentItem.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY)
            val enchantmentEffectContext = EnchantedItemInUse(currentItem, EquipmentSlot.MAINHAND, playerEntity) { playerEntity.onEquippedItemBroken(it, EquipmentSlot.MAINHAND) }
            itemEnchantmentsComponent.entrySet().forEach { (enchant, level) ->
                val effectEntries = enchant.value().getEffects(EnchantRightClickEffectComponent.BLOCK_RIGHT_CLICK_EFFECT_COMPONENT)
                applyEffects(
                    entries = effectEntries,
                    lootContext = createHitBlockLootContext(world, level, playerEntity, blockPosVec3d, blockState),
                    onEffect = { effect ->
                        clickResult = InteractionResult.SUCCESS
                        effect.apply(world, level, enchantmentEffectContext, playerEntity, blockPosVec3d)
                    }
                )
            }

            clickResult
        }
    }

    private fun createHitBlockLootContext(world: ServerLevel, level: Int, entity: Entity, pos: Vec3, state: BlockState): LootContext {
        val lootContextParameterSet = LootParams.Builder(world)
            .withParameter(LootContextParams.THIS_ENTITY, entity)
            .withParameter(LootContextParams.ENCHANTMENT_LEVEL, level)
            .withParameter(LootContextParams.ORIGIN, pos)
            .withParameter(LootContextParams.BLOCK_STATE, state)
            .create(LootContextParamSets.HIT_BLOCK)
        return LootContext.Builder(lootContextParameterSet).create(Optional.empty())
    }

    private fun <T : Any> applyEffects(
        entries: List<ConditionalEffect<T>>,
        lootContext: LootContext,
        onEffect: (T) -> Unit
    ) {
        entries
            .filter { it.matches(lootContext) }
            .forEach { onEffect(it.effect()) }
    }
}