package io.github.takusan23.clickmanaita.block;

import io.github.takusan23.clickmanaita.ClickManaita;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
    public static final Block CLICKMANAITA_WOOD_BLOCK = new ClickManaitaBaseBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), 2);

    /**
     * クリックまな板ブロック 石製
     * 4倍
     */
    public static final Block CLICKMANAITA_STONE_BLOCK = new ClickManaitaBaseBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F), 4);

    /**
     * クリックまな板ブロック 鉄製
     * 8倍
     */
    public static final Block CLICKMANAITA_IRON_BLOCK = new ClickManaitaBaseBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL), 8);

    /**
     * クリックまな板ブロック 金製
     * 16倍
     */
    public static final Block CLICKMANAITA_GOLD_BLOCK = new ClickManaitaBaseBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL), 16);
    /**
     * クリックまな板ブロック ダイヤ製
     * 32倍
     */
    public static final Block CLICKMANAITA_DIAMOND_BLOCK = new ClickManaitaBaseBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL), 32);

    /**
     * クリックまな板ブロック エメラルド製
     * 64倍
     */
    public static final Block CLICKMANAITA_EMERANLD_BLOCK = new ClickManaitaBaseBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.EMERALD).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL), 64);


    /**
     * ブロック追加用メソッド
     * <p>
     * {@link ClickManaita}のコンストラクタ内でで呼んで使う
     */
    public static void register(IEventBus eventBus) {
        // ブロック追加
        BLOCKS.register("clickmanaita_block_wood", () -> CLICKMANAITA_WOOD_BLOCK);
        BLOCKS.register("clickmanaita_block_stone", () -> CLICKMANAITA_STONE_BLOCK);
        BLOCKS.register("clickmanaita_block_iron", () -> CLICKMANAITA_IRON_BLOCK);
        BLOCKS.register("clickmanaita_block_gold", () -> CLICKMANAITA_GOLD_BLOCK);
        BLOCKS.register("clickmanaita_block_diamond", () -> CLICKMANAITA_DIAMOND_BLOCK);
        BLOCKS.register("clickmanaita_block_emerald", () -> CLICKMANAITA_EMERANLD_BLOCK);

        BLOCKS.register(eventBus);
    }

}
