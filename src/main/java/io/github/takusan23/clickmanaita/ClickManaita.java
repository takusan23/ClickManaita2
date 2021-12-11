package io.github.takusan23.clickmanaita;

import io.github.takusan23.clickmanaita.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ClickManaita.MOD_ID,
        name = ClickManaita.MOD_NAME,
        version = ClickManaita.MOD_VERSION,
        dependencies = ClickManaita.MOD_DEPENDENCIES,
        acceptedMinecraftVersions = ClickManaita.MOD_ACCEPTED_MC_VERSIONS,
        // updateJSON ="https://raw.githubusercontent.com/takusan23/ClickManaita/master/update_json/ClickManaitaVersionUpdate.json",
        useMetadata = true)

@EventBusSubscriber
public class ClickManaita {
    public static final String MOD_ID = "clickmanaita";
    public static final String MOD_NAME = "ClickManaita";
    public static final String MOD_VERSION = "3.0.0";
    public static final String MOD_DEPENDENCIES = "required-after:forge@[14.23.5.2859,);";
    public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "io.github.takusan23.clickmanaita.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "io.github.takusan23.clickmanaita.proxy.CommonProxy";
    public static final String SERVER_PROXY_CLASS = "io.github.takusan23.clickmanaita.proxy.ServerProxy";

    public static CreativeTabs ClickManaitaTab = new ClickManaitaTab("ClickManaitaTab");

    @SidedProxy(clientSide = ClickManaita.CLIENT_PROXY_CLASS, serverSide = ClickManaita.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Instance(MOD_ID)
    public static ClickManaita Instance;

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    private void preInit(FMLPreInitializationEvent event) {
        ClickManaitaItems.init();
        ClickManaitaItems.register();
        ClickManaitaBlocks.init();
        ClickManaitaBlocks.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

    }


}
//takusan_23 twitter(@takusan__23)