package io.github.takusan23.clickmanaita.enchant

import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.EquipmentSlot

/**
 * クリックまな板エンチャント。
 * */
class ClickManaitaEnchant : Enchantment(Rarity.COMMON, EnchantmentTarget.BREAKABLE, EquipmentSlot.values()) {

    companion object {

        /** クリックまな板エンチャント。エンチャント一個なのでエンチャント列挙用クラス作るのもあれなので */
        val CLICKMANAITA_ENCHANT = ClickManaitaEnchant()

    }

    override fun getMinPower(level: Int): Int = 1 + 10 * (level - 1)

    override fun getMaxPower(level: Int): Int = super.getMinPower(level) + 50

    override fun getMaxLevel(): Int = 5

}