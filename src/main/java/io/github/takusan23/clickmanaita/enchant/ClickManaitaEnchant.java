package io.github.takusan23.clickmanaita.enchant;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

/**
 * エンチャントの実装（右クリックした時に増やす）は
 * <p>
 * {@link io.github.takusan23.clickmanaita.ClickManaitaPlayerEvent}を見てください
 */
public class ClickManaitaEnchant {

    public static Enchantment CLICKMANAITA_ENCHANT = new Enchantment(
            Enchantment.definition(
                    ItemTags.DURABILITY_ENCHANTABLE,
                    10,
                    5,
                    new Enchantment.Cost(1, 10),
                    new Enchantment.Cost(51, 10),
                    1,
                    EquipmentSlot.MAINHAND
            )
    );

}
