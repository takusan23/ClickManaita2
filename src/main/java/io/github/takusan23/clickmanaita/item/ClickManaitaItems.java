package io.github.takusan23.clickmanaita.item;

import io.github.takusan23.clickmanaita.ClickManaita;
import io.github.takusan23.clickmanaita.block.ClickManaitaBlockItem;
import io.github.takusan23.clickmanaita.block.ClickManaitaBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
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

    // 各 アイテム ID
    private static final Identifier ID_CLICKMANAITA_WOOD = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_wood");
    private static final Identifier ID_CLICKMANAITA_STONE = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_stone");
    private static final Identifier ID_CLICKMANAITA_IRON = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_iron");
    private static final Identifier ID_CLICKMANAITA_GOLD = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_gold");
    private static final Identifier ID_CLICKMANAITA_DIAMOND = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_diamond");
    private static final Identifier ID_CLICKMANAITA_EMERALD = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_emerald");
    private static final Identifier ID_CLICKMANAITA_CUSTOM = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_custom");

    // 各 アイテム リソースキー
    private static final ResourceKey<Item> KEY_CLICKMANAITA_WOOD = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_WOOD);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_STONE = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_STONE);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_IRON = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_IRON);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_GOLD = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_GOLD);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_DIAMOND = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_DIAMOND);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_EMERALD = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_EMERALD);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_CUSTOM = ResourceKey.create(Registries.ITEM, ID_CLICKMANAITA_CUSTOM);
    // アイテムブロック
    private static final ResourceKey<Item> KEY_CLICKMANAITA_WOOD_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlocks.ID_CLICKMANAITA_WOOD_BLOCK);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_STONE_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlocks.ID_CLICKMANAITA_STONE_BLOCK);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_IRON_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlocks.ID_CLICKMANAITA_IRON_BLOCK);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_GOLD_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlocks.ID_CLICKMANAITA_GOLD_BLOCK);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_DIAMOND_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlocks.ID_CLICKMANAITA_DIAMOND_BLOCK);
    private static final ResourceKey<Item> KEY_CLICKMANAITA_EMERALD_BLOCK = ResourceKey.create(Registries.ITEM, ClickManaitaBlocks.ID_CLICKMANAITA_EMERALD_BLOCK);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ClickManaita.MOD_ID);

    /**
     * 木製のクリックまな板
     * ２倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_WOOD = ITEMS.register(KEY_CLICKMANAITA_WOOD.identifier().getPath(), () -> createItem(KEY_CLICKMANAITA_WOOD, 2, MaterialColor.MATERIAL_WOOD_COLOR));

    /**
     * 石製のクリックまな板
     * ４倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_STONE = ITEMS.register(KEY_CLICKMANAITA_STONE.identifier().getPath(), () -> createItem(KEY_CLICKMANAITA_STONE, 4, MaterialColor.MATERIAL_STONE_COLOR));

    /**
     * 鉄のクリックまな板
     * ８倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_IRON = ITEMS.register(KEY_CLICKMANAITA_IRON.identifier().getPath(), () -> createItem(KEY_CLICKMANAITA_IRON, 8, MaterialColor.MATERIAL_IRON_COLOR));

    /**
     * 金製のクリックまな板
     * １６倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_GOLD = ITEMS.register(KEY_CLICKMANAITA_GOLD.identifier().getPath(), () -> createItem(KEY_CLICKMANAITA_GOLD, 16, MaterialColor.MATERIAL_GOLD_COLOR));

    /**
     * ダイヤ製のクリックまな板
     * ３２倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_DIAMOND = ITEMS.register(KEY_CLICKMANAITA_DIAMOND.identifier().getPath(), () -> createItem(KEY_CLICKMANAITA_DIAMOND, 32, MaterialColor.MATERIAL_DIAMOND_COLOR));

    /**
     * エメラルド製のクリックまな板
     * ６４倍化
     */
    public static final DeferredItem<ClickManaitaBaseItem> CLICKMANAITA_EMERALD = ITEMS.register(KEY_CLICKMANAITA_EMERALD.identifier().getPath(), () -> createItem(KEY_CLICKMANAITA_EMERALD, 64, MaterialColor.MATERIAL_EMERALD_COLOR));

    /**
     * クリックまな板ブロックのBlockItem
     * 木製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_WOOD_BLOCK_ITEM = ITEMS.register(KEY_CLICKMANAITA_WOOD_BLOCK.identifier().getPath(), () -> createBlockItem(KEY_CLICKMANAITA_WOOD_BLOCK, ClickManaitaBlocks.CLICKMANAITA_WOOD_BLOCK.get(), MaterialColor.MATERIAL_WOOD_COLOR, "x2"));

    /**
     * クリックまな板ブロックのBlockItem
     * 石製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_STONE_BLOCK_ITEM = ITEMS.register(KEY_CLICKMANAITA_STONE_BLOCK.identifier().getPath(), () -> createBlockItem(KEY_CLICKMANAITA_STONE_BLOCK, ClickManaitaBlocks.CLICKMANAITA_STONE_BLOCK.get(), MaterialColor.MATERIAL_STONE_COLOR, "x4"));

    /**
     * クリックまな板ブロックのBlockItem
     * 鉄製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_IRON_BLOCK_ITEM = ITEMS.register(KEY_CLICKMANAITA_IRON_BLOCK.identifier().getPath(), () -> createBlockItem(KEY_CLICKMANAITA_IRON_BLOCK, ClickManaitaBlocks.CLICKMANAITA_IRON_BLOCK.get(), MaterialColor.MATERIAL_IRON_COLOR, "x8"));

    /**
     * クリックまな板ブロックのBlockItem
     * 金製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_GOLD_BLOCK_ITEM = ITEMS.register(KEY_CLICKMANAITA_GOLD_BLOCK.identifier().getPath(), () -> createBlockItem(KEY_CLICKMANAITA_GOLD_BLOCK, ClickManaitaBlocks.CLICKMANAITA_GOLD_BLOCK.get(), MaterialColor.MATERIAL_GOLD_COLOR, "x16"));

    /**
     * クリックまな板ブロックのBlockItem
     * ダイヤ製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_DIAMOND_BLOCK_ITEM = ITEMS.register(KEY_CLICKMANAITA_DIAMOND_BLOCK.identifier().getPath(), () -> createBlockItem(KEY_CLICKMANAITA_DIAMOND_BLOCK, ClickManaitaBlocks.CLICKMANAITA_DIAMOND_BLOCK.get(), MaterialColor.MATERIAL_DIAMOND_COLOR, "x32"));

    /**
     * クリックまな板ブロックのBlockItem
     * エメラルド製
     */
    public static final DeferredItem<ClickManaitaBlockItem> CLICKMANAITA_EMERALD_BLOCK_ITEM = ITEMS.register(KEY_CLICKMANAITA_EMERALD_BLOCK.identifier().getPath(), () -> createBlockItem(KEY_CLICKMANAITA_EMERALD_BLOCK, ClickManaitaBlocks.CLICKMANAITA_EMERANLD_BLOCK.get(), MaterialColor.MATERIAL_EMERALD_COLOR, "x64"));

    /**
     * 金床で自由にドロップ数を決められるクリックまな板
     */
    public static final DeferredItem<ClickManaitaCustomItem> CLICKMANAITA_CUSTOM_ITEM = ITEMS.register(KEY_CLICKMANAITA_CUSTOM.identifier().getPath(), () -> new ClickManaitaCustomItem((new Item.Properties().setId(KEY_CLICKMANAITA_CUSTOM)), 0));

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
    private static ClickManaitaBaseItem createItem(ResourceKey<Item> itemId, int dropSize, String tooltipColor) {
        ClickManaitaBaseItem item = new ClickManaitaBaseItem((new Item.Properties().setId(itemId)), dropSize);
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
    private static ClickManaitaBlockItem createBlockItem(ResourceKey<Item> itemBlockId, Block block, String tooltipColor, String tooltipText) {
        ClickManaitaBlockItem blockItem = new ClickManaitaBlockItem(block, (new Item.Properties().setId(itemBlockId).useBlockDescriptionPrefix()));
        blockItem.setToolTipColor(tooltipColor);
        blockItem.setToolTipText(tooltipText);
        return blockItem;
    }
}
