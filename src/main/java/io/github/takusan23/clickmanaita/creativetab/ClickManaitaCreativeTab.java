package io.github.takusan23.clickmanaita.creativetab;

import io.github.takusan23.clickmanaita.ClickManaita;
import io.github.takusan23.clickmanaita.item.ClickManaitaItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * クリエイティブタブを作成する
 */
public class ClickManaitaCreativeTab {

    public static final DeferredRegister<CreativeModeTab> ITEM_GROUP = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ClickManaita.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = ITEM_GROUP.register(
            "clickmanaita_creative_tab",
            () -> CreativeModeTab
                    .builder()
                    .icon(() -> new ItemStack(ClickManaitaItems.CLICKMANAITA_WOOD.get()))
                    .title(Component.translatable("itemGroup.clickmanaita_creative_tab"))
                    .displayItems((displayParameters, output) -> {
                        // アイテムを登録する
                        output.accept(ClickManaitaItems.CLICKMANAITA_WOOD.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_STONE.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_IRON.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_GOLD.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_DIAMOND.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_EMERALD.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_CUSTOM_ITEM.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_WOOD_BLOCK_ITEM.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_STONE_BLOCK_ITEM.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_IRON_BLOCK_ITEM.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_GOLD_BLOCK_ITEM.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_DIAMOND_BLOCK_ITEM.get());
                        output.accept(ClickManaitaItems.CLICKMANAITA_EMERALD_BLOCK_ITEM.get());
                    })
                    .build()
    );

    /**
     * クリエイティブタブを登録する
     * <p>
     * {@link ClickManaita}のコンストラクタ内でで呼んで使う
     */
    public static void register(IEventBus modEventBus) {
        ITEM_GROUP.register(modEventBus);
    }
}
