package io.github.takusan23.clickmanaita;

import io.github.takusan23.clickmanaita.Block.ClickManaitaBlocks;
import io.github.takusan23.clickmanaita.Enchant.RegisterEnchant;
import io.github.takusan23.clickmanaita.Item.ClickManaitaItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
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
        // ブロック登録
        ClickManaitaBlocks.register(modEventBus);
        // アイテム（ブロックのアイテム）登録
        ClickManaitaItems.register(modEventBus);
        // エンチャントを登録
        RegisterEnchant.register(modEventBus);
        // プレイヤーイベント
        MinecraftForge.EVENT_BUS.register(new ClickManaitaPlayerEvent());
    }
}
