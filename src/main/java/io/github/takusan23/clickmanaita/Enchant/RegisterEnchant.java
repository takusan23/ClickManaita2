package io.github.takusan23.clickmanaita.Enchant;

import io.github.takusan23.clickmanaita.ClickManaita;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 登録するエンチャントを定義してForgeに登録してもらう
 *
 * {@link io.github.takusan23.clickmanaita.ClickManaita} 参照
 * */
public class RegisterEnchant {

    private static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ClickManaita.MOD_ID);

    /**
     * エンチャントを登録する
     */
    public static final ClickManaitaEnchant clickManaitaEnchant = new ClickManaitaEnchant(Enchantment.Rarity.COMMON, EquipmentSlotType.MAINHAND);

    /**
     * Forgeにエンチャントを登録する際に呼ぶメソッド
     * */
    public static void register(IEventBus iEventBus){
        ENCHANTMENT.register("clickmanaita_enchant", () -> clickManaitaEnchant);

        ENCHANTMENT.register(iEventBus);
    }

}
