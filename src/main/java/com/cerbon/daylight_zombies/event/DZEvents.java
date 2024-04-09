package com.cerbon.daylight_zombies.event;

import com.cerbon.daylight_zombies.DaylightZombies;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DaylightZombies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DZEvents {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onSpawnPlacementRegister(SpawnPlacementRegisterEvent event) {
        event.register(EntityType.ZOMBIE, null, null, Monster::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
