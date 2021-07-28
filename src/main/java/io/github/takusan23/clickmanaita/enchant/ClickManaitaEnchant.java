package io.github.takusan23.clickmanaita.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/**
 * エンチャントの実装（右クリックした時に増やす）は
 * <p>
 * {@link io.github.takusan23.clickmanaita.ClickManaitaPlayerEvent}を見てください
 */
public class ClickManaitaEnchant extends Enchantment {

    protected ClickManaitaEnchant(Rarity p_44676_, EquipmentSlot... p_45099_) {
        super(p_44676_, EnchantmentCategory.BREAKABLE, p_45099_);
    }

    @Override
    public int getMinCost(int p_44679_) {
        return 1 + 10 * (p_44679_ - 1);
    }

    @Override
    public int getMaxCost(int p_44691_) {
        return super.getMinCost(p_44691_) + 50;
    }

    @Override
    public int getMinLevel() {
        return super.getMinLevel();
    }

    public int getMaxLevel() {
        return 5;
    }

}
