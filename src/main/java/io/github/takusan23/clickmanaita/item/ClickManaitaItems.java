package io.github.takusan23.clickmanaita.item;

import io.github.takusan23.clickmanaita.ClickManaita;
import io.github.takusan23.clickmanaita.block.ClickManaitaBlockItem;
import io.github.takusan23.clickmanaita.block.ClickManaitaBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 追加するアイテムを記述していくクラス
 * <p>
 * BlockItemもここに記述してある（ここに書くべきか？）
 * <p>
 * アイテムの追加はここで行う
 */
public class ClickManaitaItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ClickManaita.MOD_ID);

    /**
     * 木製のクリックまな板
     * ２倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_WOOD = ITEMS.register("clickmanaita_wood", () -> createItem(2, MaterialColor.MATERIAL_WOOD_COLOR));

    /**
     * 石製のクリックまな板
     * ４倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_STONE = ITEMS.register("clickmanaita_stone", () -> createItem(4, MaterialColor.MATERIAL_STONE_COLOR));

    /**
     * 鉄のクリックまな板
     * ８倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_IRON = ITEMS.register("clickmanaita_iron", () -> createItem(8, MaterialColor.MATERIAL_IRON_COLOR));

    /**
     * 金製のクリックまな板
     * １６倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_GOLD = ITEMS.register("clickmanaita_gold", () -> createItem(16, MaterialColor.MATERIAL_GOLD_COLOR));

    /**
     * ダイヤ製のクリックまな板
     * ３２倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_DIAMOND = ITEMS.register("clickmanaita_diamond", () -> createItem(32, MaterialColor.MATERIAL_DIAMOND_COLOR));

    /**
     * エメラルド製のクリックまな板
     * ６４倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_EMERALD = ITEMS.register("clickmanaita_emerald", () -> createItem(64, MaterialColor.MATERIAL_EMERALD_COLOR));

    /**
     * クリックまな板ブロックのBlockItem
     * 木製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_WOOD_BLOCK_ITEM = ITEMS.register("clickmanaita_block_wood", () -> createBlockItem(ClickManaitaBlocks.CLICKMANAITA_WOOD_BLOCK.get(), MaterialColor.MATERIAL_WOOD_COLOR, "x2"));

    /**
     * クリックまな板ブロックのBlockItem
     * 石製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_STONE_BLOCK_ITEM = ITEMS.register("clickmanaita_block_stone", () -> createBlockItem(ClickManaitaBlocks.CLICKMANAITA_STONE_BLOCK.get(), MaterialColor.MATERIAL_STONE_COLOR, "x4"));

    /**
     * クリックまな板ブロックのBlockItem
     * 鉄製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_IRON_BLOCK_ITEM = ITEMS.register("clickmanaita_block_iron", () -> createBlockItem(ClickManaitaBlocks.CLICKMANAITA_IRON_BLOCK.get(), MaterialColor.MATERIAL_IRON_COLOR, "x8"));

    /**
     * クリックまな板ブロックのBlockItem
     * 金製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_GOLD_BLOCK_ITEM = ITEMS.register("clickmanaita_block_gold", () -> createBlockItem(ClickManaitaBlocks.CLICKMANAITA_GOLD_BLOCK.get(), MaterialColor.MATERIAL_GOLD_COLOR, "x16"));

    /**
     * クリックまな板ブロックのBlockItem
     * ダイヤ製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_DIAMOND_BLOCK_ITEM = ITEMS.register("clickmanaita_block_diamond", () -> createBlockItem(ClickManaitaBlocks.CLICKMANAITA_DIAMOND_BLOCK.get(), MaterialColor.MATERIAL_DIAMOND_COLOR, "x32"));

    /**
     * クリックまな板ブロックのBlockItem
     * エメラルド製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_EMERALD_BLOCK_ITEM = ITEMS.register("clickmanaita_block_emerald", () -> createBlockItem(ClickManaitaBlocks.CLICKMANAITA_EMERANLD_BLOCK.get(), MaterialColor.MATERIAL_EMERALD_COLOR, "x64"));

    /**
     * 金床で自由にドロップ数を決められるクリックまな板
     */
    public static final DeferredItem<ClickManaitaCustomItem> CLICKMANAITA_CUSTOM_ITEM = ITEMS.register("clickmanaita_custom", () -> new ClickManaitaCustomItem((new Item.Properties()), 0));

    /**
     * アイテムを登録する。
     * <p>
     * {@link ClickManaita}のコンストラクタ内でで呼んで使う
     */
    public static void register(IEventBus eventBus) {
        // 登録
        ITEMS.register(eventBus);
    }

    /**
     * ClickManaitaBaseItem を作成する
     *
     * @param dropSize     ドロップ数
     * @param tooltipColor ツールチップの色
     * @return ClickManaitaBaseItem
     */
    private static ClickManaitaBaseItem createItem(int dropSize, String tooltipColor) {
        ClickManaitaBaseItem item = new ClickManaitaBaseItem((new Item.Properties()), dropSize);
        item.setToolTipColor(tooltipColor);
        return item;
    }

    /**
     * ClickManaitaBlockItem を作成する
     *
     * @param block        対応するブロック
     * @param tooltipColor ツールチップの色
     * @param tooltipText  ツールチップに表示するテキスト
     * @return ClickManaitaBlockItem
     */
    private static ClickManaitaBlockItem createBlockItem(Block block, String tooltipColor, String tooltipText) {
        ClickManaitaBlockItem blockItem = new ClickManaitaBlockItem(block, (new Item.Properties()));
        blockItem.setToolTipColor(tooltipColor);
        blockItem.setToolTipText(tooltipText);
        return blockItem;
    }
}
