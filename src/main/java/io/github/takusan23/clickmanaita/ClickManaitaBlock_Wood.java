package io.github.takusan23.clickmanaita;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ClickManaitaBlock_Wood extends Block {

    public ClickManaitaBlock_Wood(Material material) {
        super(Material.WOOD);
        setCreativeTab(ClickManaita.ClickManaitaTab);
        setHardness(2.5F);
        setSoundType(SoundType.WOOD);
        setUnlocalizedName("ClickManaitaBlock Wood");
        setRegistryName("clickmanaitablock_wood");

    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {


        //Ver2.0仕様、エンチャとかのNBTタグも行けるっぽいけど挙動がアレ
        //beta1、実用レベルまでに成長した
        ItemStack item_drop = playerIn.inventory.getCurrentItem().copy().splitStack(1);
        Block block = state.getBlock();


        int drop_count = 0;
        //int xp_drop_test = playerIn.experienceLevel;

        while (drop_count < 2)
        {
           // playerIn.dropItem(item_drop,true);
            spawnAsEntity(worldIn,pos,item_drop);
            //playerIn.addExperience(xp_drop_test);
            drop_count ++;
        }




        /*
        *
        * 旧仕様
        *
         //ItemStackを使えるように
        ItemStack itemStack = playerIn.getHeldItem(hand);
        //メタデータを取得。これで花崗岩や苗木のドロップが正常に動作する。
        int i = itemStack.getItem().getMetadata(itemStack);
        *
        * */

        // playerIn.dropItem(itemStack1,true);
        // playerIn.dropItem(itemStack1,true);

        //playerIn.dropItem(true);

/*
        playerIn.dropItem(new ItemStack(itemStack.getItem()),true);
        playerIn.dropItem(new ItemStack(itemStack.getItem()),true);
*/


        return true;
    }
}