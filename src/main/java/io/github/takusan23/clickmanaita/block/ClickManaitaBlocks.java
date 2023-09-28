package io.github.takusan23.clickmanaita.block;

import io.github.takusan23.clickmanaita.ClickManaita;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * クリックまな板MODで追加するブロックが定義、登録するためのクラス
 */
public class ClickManaitaBlocks {

    /**
     * ブロック追加で使う
     */
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ClickManaita.MOD_ID);

    /**
     * クリックまな板ブロック 木製
     * 2倍
     */
    public static final RegistryObject<ClickManaitaBaseBlock> CLICKMANAITA_WOOD_BLOCK = BLOCKS.register("clickmanaita_block_wood", () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava(), 2));

    /**
     * クリックまな板ブロック 石製
     * 4倍
     */
    public static final RegistryObject<ClickManaitaBaseBlock> CLICKMANAITA_STONE_BLOCK = BLOCKS.register("clickmanaita_block_stone", () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F), 4));

    /**
     * クリックまな板ブロック 鉄製
     * 8倍
     */
    public static final RegistryObject<ClickManaitaBaseBlock> CLICKMANAITA_IRON_BLOCK = BLOCKS.register("clickmanaita_block_iron", () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL), 8));

    /**
     * クリックまな板ブロック 金製
     * 16倍
     */
    public static final RegistryObject<ClickManaitaBaseBlock> CLICKMANAITA_GOLD_BLOCK = BLOCKS.register("clickmanaita_block_gold", () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BELL).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL), 16));
    /**
     * クリックまな板ブロック ダイヤ製
     * 32倍
     */
    public static final RegistryObject<ClickManaitaBaseBlock> CLICKMANAITA_DIAMOND_BLOCK = BLOCKS.register("clickmanaita_block_diamond", () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL), 32));

    /**
     * クリックまな板ブロック エメラルド製
     * 64倍
     */
    public static final RegistryObject<ClickManaitaBaseBlock> CLICKMANAITA_EMERANLD_BLOCK = BLOCKS.register("clickmanaita_block_emerald", () -> new ClickManaitaBaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).instrument(NoteBlockInstrument.BIT).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL), 64));

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