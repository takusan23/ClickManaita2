package io.github.takusan23.clickmanaita.enchant;

import net.minecraftforge.eventbus.api.IEventBus;

/**
 * 登録するエンチャントを定義してForgeに登録してもらう
 * <p>
 * {@link io.github.takusan23.clickmanaita.ClickManaita} 参照
 */
public class RegisterEnchant {
    // TODO エンチャント再実装

/*
    private static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ClickManaita.MOD_ID);

    */
/**
     * エンチャントを登録する
     *//*

    public static final RegistryObject<Enchantment> CLICKMANAITA_ENCHANT = ENCHANTMENT.register("clickmanaita_enchant", () -> ClickManaitaEnchant.CLICKMANAITA_ENCHANT);
*/

    /**
     * Forgeにエンチャントを登録する際に呼ぶメソッド
     */
    public static void register(IEventBus iEventBus) {
//        ENCHANTMENT.register(iEventBus);
    }

}
