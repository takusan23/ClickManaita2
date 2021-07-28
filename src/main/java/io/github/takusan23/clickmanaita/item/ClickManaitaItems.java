package io.github.takusan23.clickmanaita.item;

import io.github.takusan23.clickmanaita.ClickManaita;
import io.github.takusan23.clickmanaita.block.ClickManaitaBlockItem;
import io.github.takusan23.clickmanaita.block.ClickManaitaBlocks;
import io.github.takusan23.clickmanaita.creativetab.ClickManaitaCreativeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 追加するアイテムを記述していくクラス
 * <p>
 * BlockItemもここに記述してある（ここに書くべきか？）
 * <p>
 * アイテムの追加はここで行う
 */
public class ClickManaitaItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ClickManaita.MOD_ID);

    /**
     * クリエイティブタブ
     * ここでインスタンス化したものを使いまわしてください。
     */
    public static final ClickManaitaCreativeTab CLICKMANAITA_CREATIVE_TAB = new ClickManaitaCreativeTab();

    /**
     * 木製のクリックまな板
     * ２倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_WOOD = new ClickManaitaBaseItem((new Item.Properties()).tab(CLICKMANAITA_CREATIVE_TAB), 2);

    /**
     * 石製のクリックまな板
     * ４倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_STONE = new ClickManaitaBaseItem((new Item.Properties()).tab(CLICKMANAITA_CREATIVE_TAB), 4);

    /**
     * 鉄のクリックまな板
     * ８倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_IRON = new ClickManaitaBaseItem((new Item.Properties()).tab(CLICKMANAITA_CREATIVE_TAB), 8);

    /**
     * 金製のクリックまな板
     * １６倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_GOLD = new ClickManaitaBaseItem((new Item.Properties()).tab(CLICKMANAITA_CREATIVE_TAB), 16);

    /**
     * ダイヤ製のクリックまな板
     * ３２倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_DIAMOND = new ClickManaitaBaseItem((new Item.Properties()).tab(CLICKMANAITA_CREATIVE_TAB), 32);

    /**
     * エメラルド製のクリックまな板
     * ６４倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_EMERALD = new ClickManaitaBaseItem((new Item.Properties()).tab(CLICKMANAITA_CREATIVE_TAB), 64);

    /**
     * クリックまな板ブロックのBlockItem
     * 木製
     */
    public static final ClickManaitaBlockItem CLICKMANAITA_WOOD_BLOCK_ITEM = new ClickManaitaBlockItem(ClickManaitaBlocks.CLICKMANAITA_WOOD_BLOCK, (new Item.Properties()).tab(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * 石製
     */
    public static final ClickManaitaBlockItem CLICKMANAITA_STONE_BLOCK_ITEM = new ClickManaitaBlockItem(ClickManaitaBlocks.CLICKMANAITA_STONE_BLOCK, (new Item.Properties()).tab(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * 鉄製
     */
    public static final ClickManaitaBlockItem CLICKMANAITA_IRON_BLOCK_ITEM = new ClickManaitaBlockItem(ClickManaitaBlocks.CLICKMANAITA_IRON_BLOCK, (new Item.Properties()).tab(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * 金製
     */
    public static final ClickManaitaBlockItem CLICKMANAITA_GOLD_BLOCK_ITEM = new ClickManaitaBlockItem(ClickManaitaBlocks.CLICKMANAITA_GOLD_BLOCK, (new Item.Properties()).tab(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * ダイヤ製
     */
    public static final ClickManaitaBlockItem CLICKMANAITA_DIAMOND_BLOCK_ITEM = new ClickManaitaBlockItem(ClickManaitaBlocks.CLICKMANAITA_DIAMOND_BLOCK, (new Item.Properties()).tab(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * エメラルド製
     */
    public static final ClickManaitaBlockItem CLICKMANAITA_EMERALD_BLOCK_ITEM = new ClickManaitaBlockItem(ClickManaitaBlocks.CLICKMANAITA_EMERANLD_BLOCK, (new Item.Properties()).tab(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * 金床で自由にドロップ数を決められるクリックまな板
     */
    public static final ClickManaitaCustomItem CLICKMANAITA_CUSTOM_ITEM = new ClickManaitaCustomItem((new Item.Properties()).tab(CLICKMANAITA_CREATIVE_TAB), 0);


    /**
     * アイテムを登録する。
     * <p>
     * {@link ClickManaita}のコンストラクタ内でで呼んで使う
     */
    public static void register(IEventBus eventBus) {

        // ツールチップに色を付ける
        CLICKMANAITA_WOOD.setToolTipColor(MaterialColor.MATERIAL_WOOD_COLOR);
        CLICKMANAITA_STONE.setToolTipColor(MaterialColor.MATERIAL_STONE_COLOR);
        CLICKMANAITA_IRON.setToolTipColor(MaterialColor.MATERIAL_IRON_COLOR);
        CLICKMANAITA_GOLD.setToolTipColor(MaterialColor.MATERIAL_GOLD_COLOR);
        CLICKMANAITA_DIAMOND.setToolTipColor(MaterialColor.MATERIAL_DIAMOND_COLOR);
        CLICKMANAITA_EMERALD.setToolTipColor(MaterialColor.MATERIAL_EMERALD_COLOR);

        // ブロックアイテムにもツールチップ
        CLICKMANAITA_WOOD_BLOCK_ITEM.setToolTipText("x2");
        CLICKMANAITA_STONE_BLOCK_ITEM.setToolTipText("x4");
        CLICKMANAITA_IRON_BLOCK_ITEM.setToolTipText("x8");
        CLICKMANAITA_GOLD_BLOCK_ITEM.setToolTipText("x16");
        CLICKMANAITA_DIAMOND_BLOCK_ITEM.setToolTipText("x32");
        CLICKMANAITA_EMERALD_BLOCK_ITEM.setToolTipText("x64");

        CLICKMANAITA_WOOD_BLOCK_ITEM.setToolTipColor(MaterialColor.MATERIAL_WOOD_COLOR);
        CLICKMANAITA_STONE_BLOCK_ITEM.setToolTipColor(MaterialColor.MATERIAL_STONE_COLOR);
        CLICKMANAITA_IRON_BLOCK_ITEM.setToolTipColor(MaterialColor.MATERIAL_IRON_COLOR);
        CLICKMANAITA_GOLD_BLOCK_ITEM.setToolTipColor(MaterialColor.MATERIAL_GOLD_COLOR);
        CLICKMANAITA_DIAMOND_BLOCK_ITEM.setToolTipColor(MaterialColor.MATERIAL_DIAMOND_COLOR);
        CLICKMANAITA_EMERALD_BLOCK_ITEM.setToolTipColor(MaterialColor.MATERIAL_EMERALD_COLOR);

        // アイテムIDを付けて登録
        ITEMS.register("clickmanaita_wood", () -> CLICKMANAITA_WOOD);
        ITEMS.register("clickmanaita_stone", () -> CLICKMANAITA_STONE);
        ITEMS.register("clickmanaita_iron", () -> CLICKMANAITA_IRON);
        ITEMS.register("clickmanaita_gold", () -> CLICKMANAITA_GOLD);
        ITEMS.register("clickmanaita_diamond", () -> CLICKMANAITA_DIAMOND);
        ITEMS.register("clickmanaita_emerald", () -> CLICKMANAITA_EMERALD);
        ITEMS.register("clickmanaita_custom", () -> CLICKMANAITA_CUSTOM_ITEM);

        // ブロックのアイテムも登録
        ITEMS.register("clickmanaita_blockitem_wood", () -> CLICKMANAITA_WOOD_BLOCK_ITEM);
        ITEMS.register("clickmanaita_blockitem_stone", () -> CLICKMANAITA_STONE_BLOCK_ITEM);
        ITEMS.register("clickmanaita_blockitem_iron", () -> CLICKMANAITA_IRON_BLOCK_ITEM);
        ITEMS.register("clickmanaita_blockitem_gold", () -> CLICKMANAITA_GOLD_BLOCK_ITEM);
        ITEMS.register("clickmanaita_blockitem_diamond", () -> CLICKMANAITA_DIAMOND_BLOCK_ITEM);
        ITEMS.register("clickmanaita_blockitem_emerald", () -> CLICKMANAITA_EMERALD_BLOCK_ITEM);

        // 登録
        ITEMS.register(eventBus);
    }

}
