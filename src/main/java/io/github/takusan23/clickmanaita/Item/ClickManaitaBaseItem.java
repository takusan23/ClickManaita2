package io.github.takusan23.clickmanaita.Item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * クリックまな板はこのクラスを継承して作る
 */
public class ClickManaitaBaseItem extends Item {

    /**
     * ドロップ数
     */
    private int dropSize = 2;

    /**
     * Tooltipに表示する文字列
     */
    private String toolTipText = "";

    /**
     * Tooltipの文字の色
     */
    private String toolTipColor = "";

    /**
     * コンストラクタは引数が二個ある方を使ってください
     *
     * @deprecated 引数が二個ある方を利用してください。
     */
    public ClickManaitaBaseItem(Properties properties) {
        super(properties);
    }

    /**
     * コンストラクタ。
     *
     * @param properties  クリエイティブタブの設定など
     * @param argDropItem ドロップ数
     */
    public ClickManaitaBaseItem(Properties properties, int argDropItem) {
        super(properties);
        // ドロップ数設定
        dropSize = argDropItem;
        // Tooltipテキスト
        toolTipText = "x" + argDropItem;
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
     * ツールチップの色を設定する
     *
     * @param toolTipColor 色。カラーコードで #252525 など
     */
    public void setToolTipColor(String toolTipColor) {
        this.toolTipColor = toolTipColor;
    }

    /**
     * まな板を右クリックした際の処理。増やす
     */
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        BlockPos pos = context.getPos();
        BlockState state = context.getWorld().getBlockState(pos);
        Block targetBlock = state.getBlock();
        TileEntity tileEntity = context.getWorld().getTileEntity(pos);
        IInventory inventory = (IInventory) tileEntity;
        // 回数分繰り返す
        for (int i = 0; i < dropSize; i++) {
            // TileEntity（チェストなどがある場合は中身も複製する）
            if (targetBlock.hasTileEntity(state)) {
                for (int dropIndex = 0; dropIndex < inventory.getSizeInventory(); ++dropIndex) {
                    // copyを呼んで複製する
                    InventoryHelper.spawnItemStack(context.getWorld(), (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), inventory.getStackInSlot(dropIndex).copy());
                }
            }
            // 増やす
            targetBlock.harvestBlock(context.getWorld(), context.getPlayer(), pos, context.getWorld().getBlockState(pos), tileEntity, context.getItem());
        }
        return ActionResultType.SUCCESS;
    }

    /**
     * ツールチップを表示させる。ドキュメントどこ？ここ？
     */
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        // この方法で色付きツールチップが作成できる
        StringTextComponent comment = new StringTextComponent(toolTipText);
        comment.setStyle(Style.EMPTY.setColor(Color.fromHex(toolTipColor)));
        tooltip.add(comment);
    }
}
