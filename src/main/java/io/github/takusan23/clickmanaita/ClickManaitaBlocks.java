package io.github.takusan23.clickmanaita;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ClickManaitaBlocks {

    public static Block ClickManaitaBlock_Wood;
    public static Block ClickManaitaBlock_Stone;
    public static Block ClickManaitaBlock_Iron;
    public static Block ClickManaitaBlock_Gold;
    public static Block ClickManaitaBlock_Diamond;
    public static Block ClickManaitaBlock_Emerald;

    public static void init(){
        ClickManaitaBlock_Wood = new ClickManaitaBlock_Wood(Material.WOOD);
        ClickManaitaBlock_Stone = new ClickManaitaBlock_Stone(Material.ROCK);
        ClickManaitaBlock_Iron = new ClickManaitaBlock_Iron(Material.ROCK);
        ClickManaitaBlock_Gold = new ClickManaitaBlock_Gold(Material.IRON);
        ClickManaitaBlock_Diamond = new ClickManaitaBlock_Diamond(Material.IRON);
        ClickManaitaBlock_Emerald = new ClickManaitaBlock_Emerald(Material.IRON);
    }

    public static void register(){
        registerItemBlock(ClickManaitaBlock_Wood);
        registerItemBlock(ClickManaitaBlock_Stone);
        registerItemBlock(ClickManaitaBlock_Iron);
        registerItemBlock(ClickManaitaBlock_Gold);
        registerItemBlock(ClickManaitaBlock_Diamond);
        registerItemBlock(ClickManaitaBlock_Emerald);

    }

    public static void registerItemBlock(Block block){
        ForgeRegistries.BLOCKS.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        ForgeRegistries.ITEMS.register(item);
    }

    public static void registerRenders(){
        registerRender(ClickManaitaBlock_Wood);
        registerRender(ClickManaitaBlock_Stone);
        registerRender(ClickManaitaBlock_Iron);
        registerRender(ClickManaitaBlock_Gold);
        registerRender(ClickManaitaBlock_Diamond);
        registerRender(ClickManaitaBlock_Emerald);

    }

    public static void registerRender(Block block){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(block),0, new ModelResourceLocation(block.getRegistryName(),"inventory"));
    }
}
