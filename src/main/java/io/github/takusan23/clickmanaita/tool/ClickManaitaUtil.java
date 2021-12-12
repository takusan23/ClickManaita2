package io.github.takusan23.clickmanaita.tool;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.world.TrackedEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;

/**
 * クリックまな板
 */
public class ClickManaitaUtil {

    /**
     * アイテムを増やす。onItemUseで利用してね
     *
     * @param dropSize ドロップ数
     */
    public static ActionResultType manaita(BlockPos pos, World world, PlayerEntity playerEntity, ItemStack itemStack, int dropSize) {
        BlockState state = world.getBlockState(pos);
        Block targetBlock = state.getBlock();
        TileEntity tileEntity = world.getTileEntity(pos);
        // 回数分繰り返す
        for (int i = 0; i < dropSize; i++) {
            // TileEntity（チェストなどがある場合は中身も複製する）
            if (targetBlock.hasTileEntity(state) && tileEntity instanceof IInventory) {
                IInventory inventory = (IInventory) tileEntity;
                for (int dropIndex = 0; dropIndex < inventory.getSizeInventory(); ++dropIndex) {
                    // copyを呼んで複製する
                    InventoryHelper.spawnItemStack(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), inventory.getStackInSlot(dropIndex).copy());
                }
            }
            // 増やす
            if (playerEntity != null) {
                targetBlock.harvestBlock(world, playerEntity, pos, state, tileEntity, itemStack);
                // なんか経験値を吐き出す実装がなくなった？ので自前で用意
                if (world instanceof ServerWorld) {
                    int exp = targetBlock.getExpDrop(state,world,pos, 0, 0);
                    targetBlock.dropXpOnBlockBreak((ServerWorld) world,pos,exp);
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    /**
     * アイテムにツールチップを表示させる。addInformationの引数をそのまま入れてね
     *
     * @param flagIn       addInformation の引数をそのまま
     * @param stack        addInformation の引数をそのまま
     * @param worldIn      addInformation の引数をそのまま
     * @param tooltip      addInformation の引数をそのまま
     * @param toolTipColor ツールチップの文字の色。カラーコード。{@link io.github.takusan23.clickmanaita.item.MaterialColor}参照
     * @param toolTipText  ツールチップの文字列。
     */
    public static void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn, String toolTipText, String toolTipColor) {
        // この方法で色付きツールチップが作成できる
        StringTextComponent comment = new StringTextComponent(toolTipText);
        comment.setStyle(Style.EMPTY.setColor(Color.fromHex(toolTipColor)));
        tooltip.add(comment);
    }


}
