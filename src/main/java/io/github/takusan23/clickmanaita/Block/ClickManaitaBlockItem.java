package io.github.takusan23.clickmanaita.Block;

import io.github.takusan23.clickmanaita.Item.ClickManaitaBaseItem;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * クリックまな板ブロックのBlockItem。
 *
 * ツールチップに文字を追加したいだけのためにクラスを作った
 * */
public class ClickManaitaBlockItem extends BlockItem {

    /**
     * ツールチップの色
     * */
    private String toolTipColor;

    /**
     * ツールチップに表示する文字列
     * */
    private String toolTipText;

    public ClickManaitaBlockItem(Block blockIn, Properties builder) {
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
     * ツールチップを表示させる。ドキュメントどこ？ここ？
     */
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        // この方法で色付きツールチップが作成できる
        StringTextComponent comment = new StringTextComponent(toolTipText);
        comment.func_230530_a_(Style.field_240709_b_.func_240718_a_(Color.func_240745_a_(toolTipColor)));
        tooltip.add(comment);
    }

}
