package io.github.takusan23.clickmanaita;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ClickManaitaTab extends CreativeTabs {



	public ClickManaitaTab(String label) {
		super(label);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO 自動生成されたメソッド・スタブ
		return new ItemStack(ClickManaitaItems.ClickManaitaWood);
	}


}
