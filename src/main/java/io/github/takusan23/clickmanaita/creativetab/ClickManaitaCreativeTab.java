package io.github.takusan23.clickmanaita.creativetab;

import io.github.takusan23.clickmanaita.item.ClickManaitaItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * クリエイティブタブを作成する
 */
public class ClickManaitaCreativeTab extends CreativeModeTab {

    /**
     * super()の引数は内部的に使う模様。ローカライズはクラス名がスネークケースになったものが
     */
    public ClickManaitaCreativeTab() {
        super("clickmanaita_creative_tab");
    }

    /**
     * 表示するアイコンを返す
     */
    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ClickManaitaItems.CLICKMANAITA_WOOD.get());
    }
}
