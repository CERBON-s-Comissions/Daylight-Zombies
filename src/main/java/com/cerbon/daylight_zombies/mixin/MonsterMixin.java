package com.cerbon.daylight_zombies.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.LevelReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Monster.class)
public class MonsterMixin {

    @Inject(method = "getWalkTargetValue", at = @At("HEAD"), cancellable = true)
    private void dz_a(BlockPos pPos, LevelReader pLevel, CallbackInfoReturnable<Float> cir) {
        Monster thisMonster = (Monster) (Object) this;

        if (thisMonster instanceof Zombie)
            cir.setReturnValue(0.0f);
    }
}
