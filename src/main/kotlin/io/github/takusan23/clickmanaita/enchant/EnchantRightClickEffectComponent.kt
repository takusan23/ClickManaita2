package io.github.takusan23.clickmanaita.enchant

import net.minecraft.component.ComponentType
import net.minecraft.enchantment.effect.EnchantmentEffectEntry
import net.minecraft.enchantment.effect.EnchantmentEntityEffect
import net.minecraft.loot.context.LootContextTypes

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
    val BLOCK_RIGHT_CLICK_EFFECT_COMPONENT: ComponentType<List<EnchantmentEffectEntry<EnchantmentEntityEffect>>> = ComponentType.builder<List<EnchantmentEffectEntry<EnchantmentEntityEffect>>>().apply {
        codec(EnchantmentEffectEntry.createCodec(EnchantmentEntityEffect.CODEC, LootContextTypes.HIT_BLOCK).listOf())
    }.build()

}