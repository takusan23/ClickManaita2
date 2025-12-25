package io.github.takusan23.clickmanaita.enchant

import net.minecraft.core.component.DataComponentType
import net.minecraft.world.item.enchantment.ConditionalEffect
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets

/**
 * minecraft:hit_block が右クリックじゃ動作しないので、右クリックで発動する hit_block 。
 * クリック板は右クリックなので。
 *
 * ```json
 * "effects": {
 *   "clickmanaita:block_right_click": [
 *     {
 *       "effect": { ... }
 *     }
 *   ]
 * },
 * ```
 *
 * エンチャントのエフェクトのトリガーとして clickmanaita:block_right_click が使えます。
 * エフェクトは[ClickManaitaEnchantEntityEffect]参照。
 *
 * クリック時に呼び出している処理は[ClickManaitaEnchantClickCallback]です。エフェクトをトリガーしてます。
 */
object EnchantRightClickEffectComponent {

    /** [net.minecraft.enchantment.Enchantment.getEffect]の引数としてこれを使う */
    val BLOCK_RIGHT_CLICK_EFFECT_COMPONENT: DataComponentType<List<ConditionalEffect<EnchantmentEntityEffect>>> = DataComponentType.builder<List<ConditionalEffect<EnchantmentEntityEffect>>>().apply {
        persistent(ConditionalEffect.codec(EnchantmentEntityEffect.CODEC, LootContextParamSets.HIT_BLOCK).listOf())
    }.build()

}