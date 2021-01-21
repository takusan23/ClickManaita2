package io.github.takusan23.clickmanaita.Item;

import io.github.takusan23.clickmanaita.ClickManaita;
import io.github.takusan23.clickmanaita.CreativeTab.ClickManaitaCreativeTab;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 追加するアイテムを記述していくクラス
 */
public class RegisterItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ClickManaita.MOD_ID);

    /**
     * 木製のクリックまな板
     */
    public static final Item clickManaitaWood = new ClickManaitaBaseItem(
            new Item.Properties().group(new ClickManaitaCreativeTab()),
            2
    );

    /**
     * アイテムを登録する。{@link ClickManaita}で使ってる
     */
    public static void register(IEventBus eventBus) {
        // アイテムIDを付けて登録
        ITEMS.register("clickmanaita_wood", () -> clickManaitaWood);

        // 登録
        ITEMS.register(eventBus);
    }

}
