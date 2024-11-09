package io.github.takusan23.clickmanaita

import io.github.takusan23.clickmanaita.block.ClickManaitaBlock
import io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchantClickCallback
import io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchantEntityEffect
import io.github.takusan23.clickmanaita.enchant.EnchantRightClickEffectComponent
import io.github.takusan23.clickmanaita.item.ClickManaitaItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

/**
 * エントリーポイント。起動時にinit関数が呼ばれる
 */
@Suppress("unused")
fun init() {
    // アイテム追加
    ClickManaitaItem.register()
    // ブロック追加
    ClickManaitaBlock.register()
    // クリエタブ
    Registry.register(Registries.ITEM_GROUP, Identifier.of("clickmanaita", "clickmanaita_creative_tab"), ClickManaitaItemGroup.CLICKMANAITA_ITEMGROUP)
    // エンチャントのカスタムエフェクト、カスタムエフェクトのトリガー条件を追加
    Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of("clickmanaita", "clickmanaita_enchant_effect"), ClickManaitaEnchantEntityEffect.CODEC)
    Registry.register(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, Identifier.of("clickmanaita", "block_right_click"), EnchantRightClickEffectComponent.BLOCK_RIGHT_CLICK_EFFECT_COMPONENT)
    ClickManaitaEnchantClickCallback.registerClickManaitaEnchantCallback()
}

