package io.github.takusan23.clickmanaita.proxy;

import io.github.takusan23.clickmanaita.ClickManaitaBlocks;
import io.github.takusan23.clickmanaita.ClickManaitaItems;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        ClickManaitaItems.init();
        ClickManaitaItems.register();
        ClickManaitaBlocks.init();
        ClickManaitaBlocks.register();
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);
        ClickManaitaItems.registerRenders();
        ClickManaitaBlocks.registerRenders();
    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        ClickManaitaItems.init();
        ClickManaitaItems.register();
    }

    public static void registerModels(ModelRegistryEvent event) {
        ClickManaitaItems.registerRenders();
    }


}
