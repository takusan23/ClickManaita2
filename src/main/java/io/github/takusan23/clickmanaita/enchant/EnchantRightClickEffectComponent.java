package io.github.takusan23.clickmanaita.enchant;

import io.github.takusan23.clickmanaita.ClickManaitaPlayerEvent;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;

import java.util.List;
import java.util.function.UnaryOperator;

/**
 * minecraft:hit_block が右クリックじゃ動作しないので、右クリックで発動する hit_block 。
 * クリック板は右クリックなので。
 * <p>
 * エンチャントのエフェクトのトリガーとして clickmanaita:block_right_click が使えます。
 * エフェクトは {@link ClickManaitaEnchantEntityEffect} 参照、クリックで呼び出している処理は {@link ClickManaitaPlayerEvent} 参照。
 */
class EnchantRightClickEffectComponent {

    public static DataComponentType<List<ConditionalEffect<EnchantmentEntityEffect>>> BLOCK_RIGHT_CLICK_EFFECT_COMPONENT = newDataComponent(builder ->
            builder.persistent(ConditionalEffect.codec(EnchantmentEntityEffect.CODEC).listOf())
    );

    /**
     * DataComponentType の Builder を引数のラムダで渡し、build() したものを返す
     */
    private static <T> DataComponentType<T> newDataComponent(UnaryOperator<DataComponentType.Builder<T>> onBuilder) {
        DataComponentType.Builder<T> builder = DataComponentType.builder();
        onBuilder.apply(builder);
        return builder.build();
    }

}