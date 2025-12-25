package io.github.takusan23.clickmanaita

import io.github.takusan23.clickmanaita.block.ClickManaitaBlock
import io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchantClickCallback
import io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchantEntityEffect
import io.github.takusan23.clickmanaita.enchant.EnchantRightClickEffectComponent
import io.github.takusan23.clickmanaita.item.ClickManaitaItem
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.Registry
import net.minecraft.resources.Identifier

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
    Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_creative_tab"), ClickManaitaItemGroup.CLICKMANAITA_ITEMGROUP)
    // エンチャントのカスタムエフェクト、カスタムエフェクトのトリガー条件を追加
    Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.fromNamespaceAndPath("clickmanaita", "clickmanaita_enchant_effect"), ClickManaitaEnchantEntityEffect.CODEC)
    Registry.register(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, Identifier.fromNamespaceAndPath("clickmanaita", "block_right_click"), EnchantRightClickEffectComponent.BLOCK_RIGHT_CLICK_EFFECT_COMPONENT)
    // イベント登録
    ClickManaitaEnchantClickCallback.registerClickManaitaEnchantCallback()
}

