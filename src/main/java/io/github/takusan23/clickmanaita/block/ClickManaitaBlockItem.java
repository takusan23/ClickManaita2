package io.github.takusan23.clickmanaita.block;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

/**
 * クリックまな板ブロックのBlockItem。
 * <p>
 * ツールチップに文字を追加したいだけのためにクラスを作った
 */
public class ClickManaitaBlockItem extends BlockItem {

    /**
     * ツールチップの色
     */
    private String toolTipColor;

    /**
     * ツールチップに表示する文字列
     */
    private String toolTipText;

    public ClickManaitaBlockItem(Block blockIn, Item.Properties builder) {
        super(blockIn, builder);
    }

    /**
     * ツールチップの色を設定する
     *
     * @param toolTipColor 色。カラーコードで #252525 など
     */
    public void setToolTipColor(String toolTipColor) {
        this.toolTipColor = toolTipColor;
    }

    /**
     * ツールチップのテキストを設定する
     *
     * @param toolTipText 表示させたい文字列
     */
    public void setToolTipText(String toolTipText) {
        this.toolTipText = toolTipText;
    }

    /**
     * ツールチップを表示させる
     */
    @Override
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, TooltipDisplay p_399753_, Consumer<Component> p_399884_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_339594_, p_399753_, p_399884_, p_41424_);
        MutableComponent text = Component.literal(toolTipText);
        text.setStyle(Style.EMPTY.withColor(TextColor.parseColor(toolTipColor).getOrThrow()));
        p_399884_.accept(text);
    }
}
