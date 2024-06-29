package io.github.takusan23.clickmanaita.enchant

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import io.github.takusan23.clickmanaita.ClickManaitaItemTool
import net.minecraft.enchantment.EnchantmentEffectContext
import net.minecraft.enchantment.EnchantmentLevelBasedValue
import net.minecraft.enchantment.effect.EnchantmentEntityEffect
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d

/**
 * エンチャントのカスタムエフェクト
 * エンチャントは JSON で記述できるようになったけど、実際の動き、動作は Java で書かないといけない。
 * その JSON から受け取った値が [lookupDropSize]になる。
 *
 * ```json
 * "effects": {
 *   "minecraft:hit_block": [
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
 * 上記の例だと、エフェクト発動条件が minecraft:hit_block 、ブロックを叩いたときで、
 * 発動するエフェクトとして、このクラスが指定されている。clickmanaita:clickmanaita_enchant_effect ですね。
 */
data class ClickManaitaEnchantEntityEffect(
    private val lookupDropSize: EnchantmentLevelBasedValue
) : EnchantmentEntityEffect {

    override fun apply(world: ServerWorld?, level: Int, context: EnchantmentEffectContext?, user: Entity?, pos: Vec3d?) {
        val dropSize = lookupDropSize.getValue(level).toInt()
        val blockPos = BlockPos.ofFloored(pos)
        val player = user as? PlayerEntity ?: return

        ClickManaitaItemTool.manaita(dropSize, world, blockPos, player)
    }

    override fun getCodec(): MapCodec<out EnchantmentEntityEffect> = CODEC

    companion object {

        /** JSON で書かれたエンチャントの effect: { } 項目のシリアライズ、デシリアライズをする */
        val CODEC: MapCodec<ClickManaitaEnchantEntityEffect> = RecordCodecBuilder.mapCodec { instance ->
            instance.group(
                EnchantmentLevelBasedValue.CODEC.fieldOf("drop_size").forGetter { it.lookupDropSize }
            ).apply(instance) { p1 -> ClickManaitaEnchantEntityEffect(p1) }
        }
    }
}