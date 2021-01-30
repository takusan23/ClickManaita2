package io.github.takusan23.clickmanaita.CreativeTab;

import io.github.takusan23.clickmanaita.Item.ClickManaitaItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * クリエイティブタブを作成する
 * */
public class ClickManaitaCreativeTab extends ItemGroup {

    /** super()の引数は内部的に使う模様。ローカライズはクラス名がスネークケースになったものが */
    public ClickManaitaCreativeTab() {
        super("clickmanaita_creative_tab");
    }

    /**
     * 表示するアイコンを返す
     * */
    @Override
    public ItemStack createIcon() {
        return new ItemStack(ClickManaitaItems.CLICKMANAITA_WOOD);
    }
}
