package io.github.takusan23.clickmanaita.enchant;

import com.mojang.serialization.MapCodec;
import io.github.takusan23.clickmanaita.ClickManaita;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

/**
 * エンチャントの実装（右クリックした時に増やす）は
 * <p>
 * {@link io.github.takusan23.clickmanaita.ClickManaitaPlayerEvent}、{@link ClickManaitaEnchantEntityEffect}を見てください
 */
public class ClickManaitaEnchant {
    /**
     * エンチャントのカスタムエフェクトの追加
     */
    private static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENCHANT_EFFECT_TYPE = DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, ClickManaita.MOD_ID);

    /**
     * エンチャントのエフェクトコンポーネントの追加
     */
    private static final DeferredRegister<DataComponentType<?>> ENCHANT_EFFECT_COMPONENT = DeferredRegister.create(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, ClickManaita.MOD_ID);

    /**
     * クリックまな板 カスタムエフェクト
     */
    public static final DeferredHolder<MapCodec<? extends EnchantmentEntityEffect>, MapCodec<ClickManaitaEnchantEntityEffect>> CLICKMANAITA_ENCHANT_EFFECT = ENCHANT_EFFECT_TYPE.register("clickmanaita_enchant_effect", () -> ClickManaitaEnchantEntityEffect.CODEC);

    /**
     * 右クリックでトリガーされるエフェクトコンポーネント
     */
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<ConditionalEffect<EnchantmentEntityEffect>>>> BLOCK_RIGHT_CLICK_EFFECT_COMPONENT = ENCHANT_EFFECT_COMPONENT.register("block_right_click", () -> EnchantRightClickEffectComponent.BLOCK_RIGHT_CLICK_EFFECT_COMPONENT);

    /**
     * Forgeにエンチャントのカスタムエフェクト、エフェクトコンポーネントを登録する際に呼ぶメソッド
     */
    public static void register(IEventBus iEventBus) {
        // カスタムエフェクト。クリックまな板の動作をするエフェクトです
        ENCHANT_EFFECT_TYPE.register(iEventBus);
        ENCHANT_EFFECT_COMPONENT.register(iEventBus);
    }

}
