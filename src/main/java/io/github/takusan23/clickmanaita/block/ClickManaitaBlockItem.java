package io.github.takusan23.clickmanaita.block;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

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
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        TextComponent text = new TextComponent(toolTipText);
        text.setStyle(Style.EMPTY.withColor(TextColor.parseColor(toolTipColor)));
        p_41423_.add(text);
    }

}
