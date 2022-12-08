package io.github.takusan23.clickmanaita;

import io.github.takusan23.clickmanaita.block.ClickManaitaBlocks;
import io.github.takusan23.clickmanaita.creativetab.ClickManaitaCreativeTab;
import io.github.takusan23.clickmanaita.enchant.RegisterEnchant;
import io.github.takusan23.clickmanaita.item.ClickManaitaItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("clickmanaita")
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
        // クリエイティブタブ登録
        ClickManaitaCreativeTab.registerCreativeTab(modEventBus);
        // エンチャントを登録
        RegisterEnchant.register(modEventBus);
        // プレイヤーイベント
        MinecraftForge.EVENT_BUS.register(new ClickManaitaPlayerEvent());
    }
}
