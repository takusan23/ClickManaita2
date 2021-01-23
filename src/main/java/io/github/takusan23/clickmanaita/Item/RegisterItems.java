package io.github.takusan23.clickmanaita.Item;

import io.github.takusan23.clickmanaita.ClickManaita;
import io.github.takusan23.clickmanaita.CreativeTab.ClickManaitaCreativeTab;
import io.github.takusan23.clickmanaita.Enchant.ClickManaitaEnchant;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 追加するアイテムを記述していくクラス
 * <p>
 * アイテムの追加はここで行う
 */
public class RegisterItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ClickManaita.MOD_ID);

    /**
     * クリエイティブタブ
     * ここでインスタンス化したものを使いまわしてください。
     */
    public static final ClickManaitaCreativeTab creativeTab = new ClickManaitaCreativeTab();

    /**
     * 木製のクリックまな板
     * ２倍化
     */
    public static final ClickManaitaBaseItem clickManaitaWood = new ClickManaitaBaseItem(new Item.Properties().group(creativeTab).group(creativeTab), 2);

    /**
     * 石製のクリックまな板
     * ４倍化
     */
    public static final ClickManaitaBaseItem clickManaitaStone = new ClickManaitaBaseItem(new Item.Properties().group(creativeTab), 4);

    /**
     * 鉄のクリックまな板
     * ８倍化
     */
    public static final ClickManaitaBaseItem clickManaitaIron = new ClickManaitaBaseItem(new Item.Properties().group(creativeTab), 8);

    /**
     * 金製のクリックまな板
     * １６倍化
     */
    public static final ClickManaitaBaseItem clickManaitaGold = new ClickManaitaBaseItem(new Item.Properties().group(creativeTab), 16);

    /**
     * ダイヤ製のクリックまな板
     * ３２倍化
     */
    public static final ClickManaitaBaseItem clickManaitaDiamond = new ClickManaitaBaseItem(new Item.Properties().group(creativeTab), 32);

    /**
     * エメラルド製のクリックまな板
     * ６４倍化
     */
    public static final ClickManaitaBaseItem clickManaitaEmerald = new ClickManaitaBaseItem(new Item.Properties().group(creativeTab), 64);


    /**
     * アイテムを登録する。{@link ClickManaita}で使ってる
     */
    public static void register(IEventBus eventBus) {

        // ツールチップに色を付ける
        clickManaitaWood.setToolTipColor(MaterialColor.MATERIAL_WOOD_COLOR);
        clickManaitaStone.setToolTipColor(MaterialColor.MATERIAL_STONE_COLOR);
        clickManaitaIron.setToolTipColor(MaterialColor.MATERIAL_IRON_COLOR);
        clickManaitaGold.setToolTipColor(MaterialColor.MATERIAL_GOLD_COLOR);
        clickManaitaDiamond.setToolTipColor(MaterialColor.MATERIAL_DIAMOND_COLOR);
        clickManaitaEmerald.setToolTipColor(MaterialColor.MATERIAL_EMERALD_COLOR);

        // アイテムIDを付けて登録
        ITEMS.register("clickmanaita_wood", () -> clickManaitaWood);
        ITEMS.register("clickmanaita_stone", () -> clickManaitaStone);
        ITEMS.register("clickmanaita_iron", () -> clickManaitaIron);
        ITEMS.register("clickmanaita_gold", () -> clickManaitaGold);
        ITEMS.register("clickmanaita_diamond", () -> clickManaitaDiamond);
        ITEMS.register("clickmanaita_emerald", () -> clickManaitaEmerald);

        // 登録
        ITEMS.register(eventBus);
    }

}
