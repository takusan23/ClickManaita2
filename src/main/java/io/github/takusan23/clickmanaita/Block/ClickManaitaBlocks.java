package io.github.takusan23.clickmanaita.Block;

import io.github.takusan23.clickmanaita.ClickManaita;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
    public static final Block CLICKMANAITA_WOOD_BLOCK = new ClickManaitaBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD), 2);

    /**
     * クリックまな板ブロック 石製
     * 4倍
     */
    public static final Block CLICKMANAITA_STONE_BLOCK = new ClickManaitaBlock(AbstractBlock.Properties.create(Material.ROCK).func_235861_h_().hardnessAndResistance(3.5F), 4);

    /**
     * クリックまな板ブロック 鉄製
     * 8倍
     */
    public static final Block CLICKMANAITA_IRON_BLOCK = new ClickManaitaBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON).func_235861_h_().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL), 8);

    /**
     * クリックまな板ブロック 金製
     * 16倍
     */
    public static final Block CLICKMANAITA_GOLD_BLOCK = new ClickManaitaBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GOLD).func_235861_h_().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL), 16);
    /**
     * クリックまな板ブロック ダイヤ製
     * 32倍
     */
    public static final Block CLICKMANAITA_DIAMOND_BLOCK = new ClickManaitaBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.DIAMOND).func_235861_h_().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL), 32);

    /**
     * クリックまな板ブロック エメラルド製
     * 64倍
     */
    public static final Block CLICKMANAITA_EMERANLD_BLOCK = new ClickManaitaBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.EMERALD).func_235861_h_().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL), 64);


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
