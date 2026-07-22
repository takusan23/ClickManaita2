package io.github.takusan23.clickmanaita.item

import net.minecraft.core.Registry
import net.minecraft.core.component.DataComponents
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.util.Unit as MinecraftUnit
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.BowItem
import net.minecraft.world.item.HoeItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Rarity
import net.minecraft.world.item.ShearsItem
import net.minecraft.world.item.ShovelItem
import net.minecraft.world.item.ToolMaterial
import net.minecraft.world.item.component.Tool
import net.minecraft.world.item.equipment.ArmorMaterial
import net.minecraft.world.item.equipment.ArmorMaterials
import net.minecraft.world.item.equipment.ArmorType
import net.minecraft.world.item.equipment.EquipmentAssets
import net.minecraft.sounds.SoundEvents

/** 砧板系列的高阶装备。 */
object ManaitaEquipment {

    private const val MOD_ID = "clickmanaita"

    private val PAXEL_MINEABLE = TagKey.create(
        Registries.BLOCK,
        Identifier.fromNamespaceAndPath(MOD_ID, "mineable/paxel")
    )

    private val TOOL_MATERIAL = ToolMaterial(
        BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
        2031,
        1024.0f,
        96.0f,
        100,
        ItemTags.NETHERITE_TOOL_MATERIALS
    )

    private val ARMOR_MATERIAL = ArmorMaterial(
        37,
        ArmorMaterials.makeDefense(8, 16, 20, 8, 20),
        100,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        20.0f,
        1.0f,
        ItemTags.REPAIRS_NETHERITE_ARMOR,
        EquipmentAssets.NETHERITE
    )

    private val SWORD_KEY = itemKey("manaita_sword")
    private val GOD_SWORD_KEY = itemKey("manaita_god_sword")
    private val BOW_KEY = itemKey("manaita_bow")
    private val PICKAXE_KEY = itemKey("manaita_pickaxe")
    private val AXE_KEY = itemKey("manaita_axe")
    private val SHOVEL_KEY = itemKey("manaita_shovel")
    private val HOE_KEY = itemKey("manaita_hoe")
    private val PAXEL_KEY = itemKey("manaita_paxel")
    private val SHEARS_KEY = itemKey("manaita_shears")
    private val HELMET_KEY = itemKey("manaita_helmet")
    private val CHESTPLATE_KEY = itemKey("manaita_chestplate")
    private val LEGGINGS_KEY = itemKey("manaita_leggings")
    private val BOOTS_KEY = itemKey("manaita_boots")

    val SWORD = Item(properties(SWORD_KEY).sword(TOOL_MATERIAL, 3.0f, -2.0f))
    val GOD_SWORD = Item(properties(GOD_SWORD_KEY, glowing = true).sword(TOOL_MATERIAL, 9903.0f, -2.0f))
    val BOW: BowItem = ManaitaBowItem(properties(BOW_KEY).durability(384).enchantable(100))
    val PICKAXE = Item(properties(PICKAXE_KEY).pickaxe(TOOL_MATERIAL, 4.0f, -2.4f))
    val AXE = AxeItem(TOOL_MATERIAL, 8.0f, -2.4f, properties(AXE_KEY))
    val SHOVEL = ShovelItem(TOOL_MATERIAL, 4.0f, -2.4f, properties(SHOVEL_KEY))
    val HOE = HoeItem(TOOL_MATERIAL, 0.0f, 0.0f, properties(HOE_KEY))
    val PAXEL = Item(properties(PAXEL_KEY).tool(TOOL_MATERIAL, PAXEL_MINEABLE, 8.0f, -2.4f, 0.0f))
    val SHEARS = ShearsItem(
        properties(SHEARS_KEY)
            .durability(238)
            .enchantable(100)
            .component(DataComponents.TOOL, manaitaShearsTool())
    )
    val HELMET = Item(properties(HELMET_KEY).humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET))
    val CHESTPLATE = Item(properties(CHESTPLATE_KEY).humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE))
    val LEGGINGS = Item(properties(LEGGINGS_KEY).humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS))
    val BOOTS = Item(properties(BOOTS_KEY).humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS))

    val ALL_ITEMS: List<Item> = listOf(
        SWORD,
        GOD_SWORD,
        BOW,
        PICKAXE,
        AXE,
        SHOVEL,
        HOE,
        PAXEL,
        SHEARS,
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS
    )

    val MINING_TOOLS: Set<Item> = setOf(PICKAXE, AXE, SHOVEL, HOE, PAXEL, SHEARS)

    fun register() {
        listOf(
            SWORD_KEY to SWORD,
            GOD_SWORD_KEY to GOD_SWORD,
            BOW_KEY to BOW,
            PICKAXE_KEY to PICKAXE,
            AXE_KEY to AXE,
            SHOVEL_KEY to SHOVEL,
            HOE_KEY to HOE,
            PAXEL_KEY to PAXEL,
            SHEARS_KEY to SHEARS,
            HELMET_KEY to HELMET,
            CHESTPLATE_KEY to CHESTPLATE,
            LEGGINGS_KEY to LEGGINGS,
            BOOTS_KEY to BOOTS
        ).forEach { (key, item) -> Registry.register(BuiltInRegistries.ITEM, key, item) }
    }

    private fun itemKey(path: String): ResourceKey<Item> = ResourceKey.create(
        Registries.ITEM,
        Identifier.fromNamespaceAndPath(MOD_ID, path)
    )

    private fun properties(key: ResourceKey<Item>, glowing: Boolean = false): Item.Properties {
        val properties = Item.Properties()
            .setId(key)
            .stacksTo(1)
            .fireResistant()
            .rarity(Rarity.EPIC)
            .component(DataComponents.UNBREAKABLE, MinecraftUnit.INSTANCE)
        return if (glowing) properties.component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true) else properties
    }

    private fun manaitaShearsTool(): Tool {
        val vanillaTool = ShearsItem.createToolProperties()
        return Tool(
            vanillaTool.rules().map { rule ->
                if (rule.speed().isPresent) {
                    Tool.Rule(rule.blocks(), java.util.Optional.of(1024.0f), rule.correctForDrops())
                } else {
                    rule
                }
            },
            1024.0f,
            vanillaTool.damagePerBlock(),
            vanillaTool.canDestroyBlocksInCreative()
        )
    }
}
