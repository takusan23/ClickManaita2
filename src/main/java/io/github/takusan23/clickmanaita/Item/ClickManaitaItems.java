package io.github.takusan23.clickmanaita.Item;

import io.github.takusan23.clickmanaita.Block.ClickManaitaBlocks;
import io.github.takusan23.clickmanaita.ClickManaita;
import io.github.takusan23.clickmanaita.CreativeTab.ClickManaitaCreativeTab;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
    public static final ClickManaitaBaseItem CLICKMANAITA_WOOD = new ClickManaitaBaseItem(new Item.Properties().group(CLICKMANAITA_CREATIVE_TAB).group(CLICKMANAITA_CREATIVE_TAB), 2);

    /**
     * 石製のクリックまな板
     * ４倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_STONE = new ClickManaitaBaseItem(new Item.Properties().group(CLICKMANAITA_CREATIVE_TAB), 4);

    /**
     * 鉄のクリックまな板
     * ８倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_IRON = new ClickManaitaBaseItem(new Item.Properties().group(CLICKMANAITA_CREATIVE_TAB), 8);

    /**
     * 金製のクリックまな板
     * １６倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_GOLD = new ClickManaitaBaseItem(new Item.Properties().group(CLICKMANAITA_CREATIVE_TAB), 16);

    /**
     * ダイヤ製のクリックまな板
     * ３２倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_DIAMOND = new ClickManaitaBaseItem(new Item.Properties().group(CLICKMANAITA_CREATIVE_TAB), 32);

    /**
     * エメラルド製のクリックまな板
     * ６４倍化
     */
    public static final ClickManaitaBaseItem CLICKMANAITA_EMERALD = new ClickManaitaBaseItem(new Item.Properties().group(CLICKMANAITA_CREATIVE_TAB), 64);

    /**
     * クリックまな板ブロックのBlockItem
     * 木製
     */
    public static final BlockItem CLICKMANAITA_WOOD_BLOCK_ITEM = new BlockItem(ClickManaitaBlocks.CLICKMANAITA_WOOD_BLOCK.getBlock(), new Item.Properties().group(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * 石製
     */
    public static final BlockItem CLICKMANAITA_STONE_BLOCK_ITEM = new BlockItem(ClickManaitaBlocks.CLICKMANAITA_STONE_BLOCK.getBlock(), new Item.Properties().group(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * 鉄製
     */
    public static final BlockItem CLICKMANAITA_IRON_BLOCK_ITEM = new BlockItem(ClickManaitaBlocks.CLICKMANAITA_IRON_BLOCK.getBlock(), new Item.Properties().group(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * 金製
     */
    public static final BlockItem CLICKMANAITA_GOLD_BLOCK_ITEM = new BlockItem(ClickManaitaBlocks.CLICKMANAITA_GOLD_BLOCK.getBlock(), new Item.Properties().group(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * ダイヤ製
     */
    public static final BlockItem CLICKMANAITA_DIAMOND_BLOCK_ITEM = new BlockItem(ClickManaitaBlocks.CLICKMANAITA_DIAMOND_BLOCK.getBlock(), new Item.Properties().group(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));

    /**
     * クリックまな板ブロックのBlockItem
     * エメラルド製
     */
    public static final BlockItem CLICKMANAITA_EMERALD_BLOCK_ITEM = new BlockItem(ClickManaitaBlocks.CLICKMANAITA_EMERANLD_BLOCK.getBlock(), new Item.Properties().group(ClickManaitaItems.CLICKMANAITA_CREATIVE_TAB));


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

        // アイテムIDを付けて登録
        ITEMS.register("clickmanaita_wood", () -> CLICKMANAITA_WOOD);
        ITEMS.register("clickmanaita_stone", () -> CLICKMANAITA_STONE);
        ITEMS.register("clickmanaita_iron", () -> CLICKMANAITA_IRON);
        ITEMS.register("clickmanaita_gold", () -> CLICKMANAITA_GOLD);
        ITEMS.register("clickmanaita_diamond", () -> CLICKMANAITA_DIAMOND);
        ITEMS.register("clickmanaita_emerald", () -> CLICKMANAITA_EMERALD);

        // ブロックのアイテムも登録
        ITEMS.register("clickmanaita_wood_blockitem", () -> CLICKMANAITA_WOOD_BLOCK_ITEM);
        ITEMS.register("clickmanaita_stone_blockitem", () -> CLICKMANAITA_STONE_BLOCK_ITEM);
        ITEMS.register("clickmanaita_iron_blockitem", () -> CLICKMANAITA_IRON_BLOCK_ITEM);
        ITEMS.register("clickmanaita_gold_blockitem", () -> CLICKMANAITA_GOLD_BLOCK_ITEM);
        ITEMS.register("clickmanaita_diamond_blockitem", () -> CLICKMANAITA_DIAMOND_BLOCK_ITEM);
        ITEMS.register("clickmanaita_emerald_blockitem", () -> CLICKMANAITA_EMERALD_BLOCK_ITEM);

        // 登録
        ITEMS.register(eventBus);
    }

}
