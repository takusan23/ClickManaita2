package io.github.takusan23.clickmanaita.enchant

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import io.github.takusan23.clickmanaita.ClickManaitaItemTool
import net.fabricmc.fabric.api.networking.v1.PlayerLookup.world
import net.minecraft.world.item.enchantment.EnchantedItemInUse
import net.minecraft.world.item.enchantment.LevelBasedValue
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player
import net.minecraft.server.level.ServerLevel
import net.minecraft.core.BlockPos
import net.minecraft.world.entity.ai.behavior.SetWalkTargetAwayFrom.pos
import net.minecraft.world.phys.Vec3

/**
 * エンチャントのカスタムエフェクト
 * エンチャントは JSON で記述できるようになったけど、実際の動き、動作は Java で書かないといけない。
 * その JSON から受け取った値が [lookupDropSize]になる。
 *
 * ```json
 * "effects": {
 *   "clickmanaita:block_right_click": [
 *     {
 *       "effect": {
 *         "type": "clickmanaita:clickmanaita_enchant_effect",
 *         "drop_size": {
 *           "type": "minecraft:lookup",
 *           "values": [
 *             2,
 *             4,
 *             8,
 *             16,
 *             32,
 *             64
 *           ],
 *           "fallback": 2
 *         }
 *       }
 *     }
 *   ]
 * },
 *```
 *
 * 発動するエフェクトとして、このクラスが指定されている。clickmanaita:clickmanaita_enchant_effect ですね。
 */
data class ClickManaitaEnchantEntityEffect(
    private val lookupDropSize: LevelBasedValue
) : EnchantmentEntityEffect {


    override fun apply(serverLevel: ServerLevel, i: Int, enchantedItemInUse: EnchantedItemInUse, entity: Entity, vec3: Vec3) {
        val dropSize = lookupDropSize.calculate(i).toInt()
        val blockPos = BlockPos.containing(vec3)
        val player = entity as? Player ?: return

        ClickManaitaItemTool.manaita(dropSize, serverLevel, blockPos, player)
    }

    override fun codec(): MapCodec<out EnchantmentEntityEffect> = CODEC

    companion object {

        /** JSON で書かれたエンチャントの effect: { } 項目のシリアライズ、デシリアライズをする */
        val CODEC: MapCodec<ClickManaitaEnchantEntityEffect> = RecordCodecBuilder.mapCodec { instance ->
            instance.group(
                LevelBasedValue.CODEC.fieldOf("drop_size").forGetter { it.lookupDropSize }
            ).apply(instance) { p1 -> ClickManaitaEnchantEntityEffect(p1) }
        }
    }
}