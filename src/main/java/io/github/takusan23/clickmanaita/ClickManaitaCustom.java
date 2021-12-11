package io.github.takusan23.clickmanaita;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ClickManaitaCustom extends Item {

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        TileEntity tileEntity = null;
        TileEntity tileEntity_break = worldIn.getTileEntity(pos);

        int drop_count = 0;



        String drop_count_start_string = itemstack.getDisplayName();

        // 修正済みだがガチのマジのリモートコード実行の脆弱性がある
        if (drop_count_start_string.contains("${jndi:")) {
            player.sendMessage(new TextComponentString("この名前は利用してはいけません"));
            return EnumActionResult.PASS;
        }

        //try catch文
        //int→Stringに変換していますが
        //Stringに変換できなかったとき（数字を入れてない、値がおかしい）のためにtry catch文で
        //できなかった場合はメッセージを出すようにしてクラッシュを回避しています。
        try {
            int drop_count_start = Integer.parseInt(drop_count_start_string.replaceAll("[^0-9]", ""));

            while (drop_count < drop_count_start) {

                block.harvestBlock(worldIn, player, pos, iblockstate, tileEntity, itemstack);

                drop_count++;
            }
        } catch (NumberFormatException e) {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("数字が正しくありません"));
                player.sendMessage(new TextComponentString("金床で名前を増やしたい量の数字に変更してください。"));
                player.sendMessage(new TextComponentString("上限はintの限界まで？整数のみ利用できます。"));
                player.sendMessage(new TextComponentString(""));
                player.sendMessage(new TextComponentString(""));
                player.sendMessage(new TextComponentString("The number is incorrect."));
                player.sendMessage(new TextComponentString("Please change the number of numbers you want to increase the name on the anvil."));
                player.sendMessage(new TextComponentString("Is the upper limit to the limit of int ? Only integers are available."));
            }
        }

        return EnumActionResult.SUCCESS;

    }

}
