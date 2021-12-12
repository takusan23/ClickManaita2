package io.github.takusan23.clickmanaita.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

/**
 * エンチャントの実装（右クリックした時に増やす）は
 *
 * {@link io.github.takusan23.clickmanaita.ClickManaitaPlayerEvent}を見てください
 * */
public class ClickManaitaEnchant extends Enchantment {

    protected ClickManaitaEnchant(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.BREAKABLE, slots);
    }

    public int getMinEnchantability(int enchantmentLevel) {
        return 1 + 10 * (enchantmentLevel - 1);
    }

    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }


    public int getMaxLevel() {
        return 5;
    }

}
