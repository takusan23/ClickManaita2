package io.github.takusan23.clickmanaita.enchant;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.takusan23.clickmanaita.ClickManaitaItemTool;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

/**
 * エンチャントのカスタムエフェクト。クリックまな板の動作をするエフェクトです。
 * エンチャントは JSON で記述できるようになったけど、実際の動き、動作は Java で書かないといけない。
 *
 * @param lookupDropSize JSON 側でドロップ数を
 */
public record ClickManaitaEnchantEntityEffect(
        LevelBasedValue lookupDropSize
) implements EnchantmentEntityEffect {

    /**
     * JSON で書かれたエンチャントの effect: { } 項目のシリアライズ、デシリアライズをする
     */
    public static MapCodec<ClickManaitaEnchantEntityEffect> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
            .group(LevelBasedValue.CODEC.fieldOf("drop_size").forGetter(levelBasedValue -> levelBasedValue.lookupDropSize))
            .apply(instance, ClickManaitaEnchantEntityEffect::new)
    );

    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        int dropSize = (int) lookupDropSize.calculate(i);
        BlockPos blockPos = BlockPos.containing(vec3);

        if (entity instanceof Player) {
            ClickManaitaItemTool.manaita(dropSize, serverLevel, blockPos, (Player) entity);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
