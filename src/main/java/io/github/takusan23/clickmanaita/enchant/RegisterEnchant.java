package io.github.takusan23.clickmanaita.enchant;

import io.github.takusan23.clickmanaita.ClickManaita;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 登録するエンチャントを定義してForgeに登録してもらう
 * <p>
 * {@link io.github.takusan23.clickmanaita.ClickManaita} 参照
 */
public class RegisterEnchant {

    private static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(Registries.ENCHANTMENT, ClickManaita.MOD_ID);

    /**
     * エンチャントを登録する
     */
    public static final DeferredHolder<Enchantment, ClickManaitaEnchant> CLICKMANAITA_ENCHANT = ENCHANTMENT.register("clickmanaita_enchant", () -> new ClickManaitaEnchant(Enchantment.Rarity.COMMON, EquipmentSlot.values()));

    /**
     * Forgeにエンチャントを登録する際に呼ぶメソッド
     */
    public static void register(IEventBus iEventBus) {
        ENCHANTMENT.register(iEventBus);
    }

}
