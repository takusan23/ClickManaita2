package io.github.takusan23.clickmanaita.creativetab;

import io.github.takusan23.clickmanaita.ClickManaita;
import io.github.takusan23.clickmanaita.item.ClickManaitaItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;

/**
 * クリエイティブタブを作成する
 */
public class ClickManaitaCreativeTab {

    /**
     * クリエイティブタブを登録する。アイテムもここで登録する。
     */
    public static void registerCreativeTab(IEventBus modEventBus) {
        modEventBus.addListener((CreativeModeTabEvent.Register event) -> {
            event.registerCreativeModeTab(new ResourceLocation(ClickManaita.MOD_ID, "clickmanaita_creative_tab"), (builder -> {
                builder.title(Component.translatable("itemGroup.clickmanaita_creative_tab"))
                        .icon(() -> new ItemStack(ClickManaitaItems.CLICKMANAITA_WOOD.get()))
                        .displayItems((enabledFeatures, entries, operatorEnabled) -> {
                            // アイテムを登録する
                            entries.accept(ClickManaitaItems.CLICKMANAITA_WOOD.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_STONE.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_IRON.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_GOLD.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_DIAMOND.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_EMERALD.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_CUSTOM_ITEM.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_WOOD_BLOCK_ITEM.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_STONE_BLOCK_ITEM.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_IRON_BLOCK_ITEM.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_GOLD_BLOCK_ITEM.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_DIAMOND_BLOCK_ITEM.get());
                            entries.accept(ClickManaitaItems.CLICKMANAITA_EMERALD_BLOCK_ITEM.get());
                        })
                        .build();
            }));
        });
    }
}
