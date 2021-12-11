package io.github.takusan23.clickmanaita;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ClickManaitaItems {

    public static Item ClickManaitaWood;
    public static Item ClickManaitaStone;
    public static Item ClickManaitaIron;
    public static Item ClickManaitaGold;
    public static Item ClickManaitaDiamond;
    public static Item ClickManaitaEmerald;

    public static Item ClickManaitaWoodPickaxe;
    public static Item ClickManaitaStonePickaxe;
    public static Item ClickManaitaIronPickaxe;
    public static Item ClickManaitaGoldPickaxe;
    public static Item ClickManaitaDiamondPickaxe;

    public static Item ClickManaitaCustom;


    public static void init() {

        ClickManaitaWood = new ClickManaita_Wood().setUnlocalizedName("ClickManaita Wood").setCreativeTab(ClickManaita.ClickManaitaTab);
        ClickManaitaStone = new ClickManaita_Stone().setUnlocalizedName("ClickManaita Stone").setCreativeTab(ClickManaita.ClickManaitaTab);
        ClickManaitaIron = new ClickManaita_Iron().setUnlocalizedName("ClickManaita Iron").setCreativeTab(ClickManaita.ClickManaitaTab);
        ClickManaitaGold = new ClickManaita_Gold().setUnlocalizedName("ClickManaita Gold").setCreativeTab(ClickManaita.ClickManaitaTab);
        ClickManaitaDiamond = new ClickManaita_Diamond().setUnlocalizedName("ClickManaita Diamond").setCreativeTab(ClickManaita.ClickManaitaTab);
        ClickManaitaEmerald = new ClickManaita_Emerald().setUnlocalizedName("ClickManaita Emerald").setCreativeTab(ClickManaita.ClickManaitaTab);

        ClickManaitaWoodPickaxe = new ClickManaita_WoodPickaxe(ToolMaterial.WOOD).setCreativeTab(ClickManaita.ClickManaitaTab).setUnlocalizedName("ClickManaita Wood Pickaxe");
        ClickManaitaStonePickaxe = new ClickManaita_StonePickaxe(ToolMaterial.STONE).setCreativeTab(ClickManaita.ClickManaitaTab).setUnlocalizedName("ClickManaita Stone Pickaxe");
        ClickManaitaIronPickaxe = new ClickManaita_IronPickaxe(ToolMaterial.IRON).setCreativeTab(ClickManaita.ClickManaitaTab).setUnlocalizedName("ClickManaita Iron Pickaxe");
        ClickManaitaGoldPickaxe = new ClickManaita_GoldPickaxe(ToolMaterial.GOLD).setCreativeTab(ClickManaita.ClickManaitaTab).setUnlocalizedName("ClickManaita Gold Pickaxe");
        ClickManaitaDiamondPickaxe = new ClickManaita_DiamondPickaxe(ToolMaterial.DIAMOND).setCreativeTab(ClickManaita.ClickManaitaTab).setUnlocalizedName("ClickManaita Diamond Pickaxe");

        ClickManaitaCustom = new ClickManaitaCustom().setCreativeTab(ClickManaita.ClickManaitaTab).setUnlocalizedName("ClickManaita Custom");

    }

    public static void register() {

        registerItem(ClickManaitaWood, "clickmanaita_wood");
        registerItem(ClickManaitaStone, "clickmanaita_stone");
        registerItem(ClickManaitaIron, "clickmanaita_iron");
        registerItem(ClickManaitaGold, "clickmanaita_gold");
        registerItem(ClickManaitaDiamond, "clickmanaita_diamond");
        registerItem(ClickManaitaEmerald, "clickmanaita_emerald");

        registerItem(ClickManaitaWoodPickaxe, "clickmanaita_woodpickaxe");
        registerItem(ClickManaitaStonePickaxe, "clickmanaita_stonepickaxe");
        registerItem(ClickManaitaIronPickaxe, "clickmanaita_ironpickaxe");
        registerItem(ClickManaitaGoldPickaxe, "clickmanaita_goldpickaxe");
        registerItem(ClickManaitaDiamondPickaxe, "clickmanaita_diamondpickaxe");

        registerItem(ClickManaitaCustom, "clickmanaita_custom");
    }

    public static void registerItem(Item item, String string) {
        item.setRegistryName(new ResourceLocation(ClickManaita.MOD_ID, string));
        ForgeRegistries.ITEMS.register(item);
    }

    public static void registerRenders() {

        registerRender(ClickManaitaWood);
        registerRender(ClickManaitaStone);
        registerRender(ClickManaitaIron);
        registerRender(ClickManaitaGold);
        registerRender(ClickManaitaDiamond);
        registerRender(ClickManaitaEmerald);

        registerRender(ClickManaitaWoodPickaxe);
        registerRender(ClickManaitaStonePickaxe);
        registerRender(ClickManaitaIronPickaxe);
        registerRender(ClickManaitaGoldPickaxe);
        registerRender(ClickManaitaDiamondPickaxe);

        registerRender(ClickManaitaCustom);

    }

    public static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }


}
