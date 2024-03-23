package com.cerbon.daylight_zombies.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Monster.class)
public class MonsterMixin {

    @Inject(method = "checkMonsterSpawnRules", at = @At("HEAD"), cancellable = true)
    private static void dz_check(EntityType<? extends Monster> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random, CallbackInfoReturnable<Boolean> cir) {
        if (type == EntityType.ZOMBIE)
            cir.setReturnValue(Monster.checkAnyLightMonsterSpawnRules(type, level, spawnType, pos, random));
    }
}
