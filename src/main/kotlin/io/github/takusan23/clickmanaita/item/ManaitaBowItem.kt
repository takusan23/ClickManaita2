package io.github.takusan23.clickmanaita.item

import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.projectile.Projectile
import net.minecraft.world.entity.projectile.arrow.AbstractArrow
import net.minecraft.world.item.BowItem

/** 不可损坏且会显著提高箭矢伤害的砧板弓。 */
class ManaitaBowItem(properties: Properties) : BowItem(properties) {

    override fun shootProjectile(
        shooter: LivingEntity,
        projectileEntity: Projectile,
        index: Int,
        power: Float,
        uncertainty: Float,
        angle: Float,
        targetOverride: LivingEntity?
    ) {
        super.shootProjectile(shooter, projectileEntity, index, power, uncertainty, angle, targetOverride)
        (projectileEntity as? AbstractArrow)?.setBaseDamage(100.0)
    }
}
