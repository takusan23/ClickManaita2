package io.github.takusan23.clickmanaita.block;

import io.github.takusan23.clickmanaita.ClickManaita;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * クリックまな板MODで追加するブロックが定義、登録するためのクラス
 */
public class ClickManaitaBlocks {

    // 各 ブロック ID。アイテム追加で使うので public
    public static final Identifier ID_CLICKMANAITA_WOOD_BLOCK = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_block_wood");
    public static final Identifier ID_CLICKMANAITA_STONE_BLOCK = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_block_stone");
    public static final Identifier ID_CLICKMANAITA_IRON_BLOCK = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_block_iron");
    public static final Identifier ID_CLICKMANAITA_GOLD_BLOCK = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_block_gold");
    public static final Identifier ID_CLICKMANAITA_DIAMOND_BLOCK = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_block_diamond");
    public static final Identifier ID_CLICKMANAITA_EMERALD_BLOCK = Identifier.fromNamespaceAndPath(ClickManaita.MOD_ID, "clickmanaita_block_emerald");

    // 各 アイテム リソースキー
    private static final ResourceKey<Block> KEY_CLICKMANAITA_WOOD_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_WOOD_BLOCK);
    private static final ResourceKey<Block> KEY_CLICKMANAITA_STONE_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_STONE_BLOCK);
    private static final ResourceKey<Block> KEY_CLICKMANAITA_IRON_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_IRON_BLOCK);
    private static final ResourceKey<Block> KEY_CLICKMANAITA_GOLD_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_GOLD_BLOCK);
    private static final ResourceKey<Block> KEY_CLICKMANAITA_DIAMOND_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_DIAMOND_BLOCK);
    private static final ResourceKey<Block> KEY_CLICKMANAITA_EMERALD_BLOCK = ResourceKey.create(Registries.BLOCK, ID_CLICKMANAITA_EMERALD_BLOCK);

    /**
     * ブロック追加で使う
     */
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ClickManaita.MOD_ID);

    /**
     * クリックまな板ブロック 木製
     * 2倍
     */
    public static final DeferredBlock<ClickManaitaBaseBlock> CLICKMANAITA_WOOD_BLOCK = BLOCKS.register(KEY_CLICKMANAITA_WOOD_BLOCK.identifier().getPath(), () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava().setId(KEY_CLICKMANAITA_WOOD_BLOCK), 2));

    /**
     * クリックまな板ブロック 石製
     * 4倍
     */
    public static final DeferredBlock<ClickManaitaBaseBlock> CLICKMANAITA_STONE_BLOCK = BLOCKS.register(KEY_CLICKMANAITA_STONE_BLOCK.identifier().getPath(), () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).setId(KEY_CLICKMANAITA_STONE_BLOCK), 4));

    /**
     * クリックまな板ブロック 鉄製
     * 8倍
     */
    public static final DeferredBlock<ClickManaitaBaseBlock> CLICKMANAITA_IRON_BLOCK = BLOCKS.register(KEY_CLICKMANAITA_IRON_BLOCK.identifier().getPath(), () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).setId(KEY_CLICKMANAITA_IRON_BLOCK), 8));

    /**
     * クリックまな板ブロック 金製
     * 16倍
     */
    public static final DeferredBlock<ClickManaitaBaseBlock> CLICKMANAITA_GOLD_BLOCK = BLOCKS.register(KEY_CLICKMANAITA_GOLD_BLOCK.identifier().getPath(), () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BELL).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).setId(KEY_CLICKMANAITA_GOLD_BLOCK), 16));

    /**
     * クリックまな板ブロック ダイヤ製
     * 32倍
     */
    public static final DeferredBlock<ClickManaitaBaseBlock> CLICKMANAITA_DIAMOND_BLOCK = BLOCKS.register(KEY_CLICKMANAITA_DIAMOND_BLOCK.identifier().getPath(), () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).setId(KEY_CLICKMANAITA_DIAMOND_BLOCK), 32));

    /**
     * クリックまな板ブロック エメラルド製
     * 64倍
     */
    public static final DeferredBlock<ClickManaitaBaseBlock> CLICKMANAITA_EMERANLD_BLOCK = BLOCKS.register(KEY_CLICKMANAITA_EMERALD_BLOCK.identifier().getPath(), () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).instrument(NoteBlockInstrument.BIT).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).setId(KEY_CLICKMANAITA_EMERALD_BLOCK), 64));

    /**
     * ブロック追加用メソッド
     * <p>
     * {@link ClickManaita}のコンストラクタ内でで呼んで使う
     */
    public static void register(IEventBus eventBus) {
        // ブロック追加
        BLOCKS.register(eventBus);
    }

}
