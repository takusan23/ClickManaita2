package io.github.takusan23.clickmanaita.item

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot

/** 砧板装备的服务端能力。 */
object ManaitaEquipmentEffects {

    private const val FLIGHT_TAG = "clickmanaita.manaita_armor_flight"
    private val breakingPlayers = mutableSetOf<java.util.UUID>()

    fun register() {
        ServerTickEvents.END_SERVER_TICK.register { server ->
            server.playerList.players.forEach(::tickArmor)
        }
        ServerLivingEntityEvents.ALLOW_DAMAGE.register { entity, _, _ ->
            entity !is ServerPlayer || !wearingFullSet(entity)
        }
        PlayerBlockBreakEvents.AFTER.register { world, player, pos, _, _ ->
            val serverPlayer = player as? ServerPlayer ?: return@register
            val serverLevel = world as? ServerLevel ?: return@register
            breakNearbyBlocks(serverLevel, serverPlayer, pos)
        }
    }

    private fun tickArmor(player: ServerPlayer) {
        val hasHelmet = player.getItemBySlot(EquipmentSlot.HEAD).`is`(ManaitaEquipment.HELMET)
        val hasChestplate = player.getItemBySlot(EquipmentSlot.CHEST).`is`(ManaitaEquipment.CHESTPLATE)
        val hasLeggings = player.getItemBySlot(EquipmentSlot.LEGS).`is`(ManaitaEquipment.LEGGINGS)
        val hasBoots = player.getItemBySlot(EquipmentSlot.FEET).`is`(ManaitaEquipment.BOOTS)

        if (hasHelmet) {
            player.airSupply = player.maxAirSupply
            player.foodData.foodLevel = 20
            player.foodData.setSaturation(20.0f)
        }
        if (hasChestplate) {
            player.activeEffects
                .asSequence()
                .map { it.effect }
                .filter { it.value().category == MobEffectCategory.HARMFUL }
                .toList()
                .forEach(player::removeEffect)
        }
        if (hasLeggings) {
            player.extinguishFire()
        }
        val hasFullSet = hasHelmet && hasChestplate && hasLeggings && hasBoots
        if (player.tickCount % 20 == 0) {
            if (hasHelmet) player.addEffect(hiddenEffect(MobEffects.NIGHT_VISION, 240))
            if (hasLeggings && player.isShiftKeyDown) player.addEffect(hiddenEffect(MobEffects.INVISIBILITY, 40))
            if (hasBoots) player.addEffect(hiddenEffect(MobEffects.SPEED, 40, amplifier = 2))
            if (hasFullSet) {
                player.addEffect(hiddenEffect(MobEffects.RESISTANCE, 40, amplifier = 3))
                player.addEffect(hiddenEffect(MobEffects.REGENERATION, 40, amplifier = 9))
                player.addEffect(hiddenEffect(MobEffects.STRENGTH, 40, amplifier = 9))
                player.addEffect(hiddenEffect(MobEffects.HASTE, 40, amplifier = 9))
                player.addEffect(hiddenEffect(MobEffects.JUMP_BOOST, 40, amplifier = 4))
                player.addEffect(hiddenEffect(MobEffects.HEALTH_BOOST, 40, amplifier = 9))
                player.addEffect(hiddenEffect(MobEffects.ABSORPTION, 40, amplifier = 9))
                player.addEffect(hiddenEffect(MobEffects.FIRE_RESISTANCE, 40))
                player.addEffect(hiddenEffect(MobEffects.WATER_BREATHING, 40))
                player.addEffect(hiddenEffect(MobEffects.SLOW_FALLING, 40))
                player.addEffect(hiddenEffect(MobEffects.DOLPHINS_GRACE, 40))
                player.addEffect(hiddenEffect(MobEffects.LUCK, 40, amplifier = 9))
            }
        }

        updateFlight(player, hasFullSet)
    }

    private fun wearingFullSet(player: ServerPlayer): Boolean =
        player.getItemBySlot(EquipmentSlot.HEAD).`is`(ManaitaEquipment.HELMET) &&
            player.getItemBySlot(EquipmentSlot.CHEST).`is`(ManaitaEquipment.CHESTPLATE) &&
            player.getItemBySlot(EquipmentSlot.LEGS).`is`(ManaitaEquipment.LEGGINGS) &&
            player.getItemBySlot(EquipmentSlot.FEET).`is`(ManaitaEquipment.BOOTS)

    private fun updateFlight(player: ServerPlayer, hasFullSet: Boolean) {
        val abilities = player.abilities
        if (hasFullSet && !abilities.mayfly) {
            abilities.mayfly = true
            player.addTag(FLIGHT_TAG)
            player.onUpdateAbilities()
        } else if (!hasFullSet && player.entityTags().contains(FLIGHT_TAG)) {
            player.removeTag(FLIGHT_TAG)
            if (!player.isCreative && !player.isSpectator) {
                abilities.mayfly = false
                abilities.flying = false
                player.onUpdateAbilities()
            }
        }
    }

    private fun hiddenEffect(effect: net.minecraft.core.Holder<net.minecraft.world.effect.MobEffect>, duration: Int, amplifier: Int = 0) =
        MobEffectInstance(effect, duration, amplifier, true, false, false)

    private fun breakNearbyBlocks(level: ServerLevel, player: ServerPlayer, origin: BlockPos) {
        val tool = player.mainHandItem
        if (!player.isShiftKeyDown || tool.item !in ManaitaEquipment.MINING_TOOLS || !breakingPlayers.add(player.uuid)) return

        try {
            for (x in -1..1) {
                for (y in -1..1) {
                    for (z in -1..1) {
                        val target = origin.offset(x, y, z)
                        if (target == origin) continue
                        val state = level.getBlockState(target)
                        if (!state.isAir && state.getDestroySpeed(level, target) >= 0.0f && tool.getDestroySpeed(state) > 1.0f) {
                            player.gameMode.destroyBlock(target)
                        }
                    }
                }
            }
        } finally {
            breakingPlayers.remove(player.uuid)
        }
    }
}
