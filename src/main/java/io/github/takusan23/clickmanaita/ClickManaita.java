package io.github.takusan23.clickmanaita;

import io.github.takusan23.clickmanaita.block.ClickManaitaBlocks;
import io.github.takusan23.clickmanaita.creativetab.ClickManaitaCreativeTab;
import io.github.takusan23.clickmanaita.enchant.ClickManaitaEnchant;
import io.github.takusan23.clickmanaita.item.ClickManaitaItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.bus.BusGroup;
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
    public ClickManaita(FMLJavaModLoadingContext context) {
        BusGroup modBusGroup = context.getModBusGroup();
        // ブロック登録
        ClickManaitaBlocks.register(modBusGroup);
        // アイテム（ブロックのアイテム）登録
        ClickManaitaItems.register(modBusGroup);
        // クリエイティブタブ登録
        ClickManaitaCreativeTab.register(modBusGroup);
        // エンチャント（カスタムエフェクト、エフェクトコンポーネント）を登録
        ClickManaitaEnchant.register(modBusGroup);
        // プレイヤーイベント
        MinecraftForge.EVENT_BUS.register(new ClickManaitaPlayerEvent());
    }
}
