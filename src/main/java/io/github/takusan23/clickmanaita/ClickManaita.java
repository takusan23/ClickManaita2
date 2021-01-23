package io.github.takusan23.clickmanaita;

import io.github.takusan23.clickmanaita.Enchant.RegisterEnchant;
import io.github.takusan23.clickmanaita.Item.RegisterItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ClickManaita.MOD_ID)
public class ClickManaita {

    /**
     * MODのID
     */
    public static final String MOD_ID = "clickmanaita";

    /**
     * コンストラクタ
     */
    public ClickManaita() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // アイテム登録
        RegisterItems.register(modEventBus);
        // エンチャントを登録
        RegisterEnchant.register(modEventBus);
        // プレイヤーイベント
        MinecraftForge.EVENT_BUS.register(new ClickManaitaPlayerEvent());
    }
}
