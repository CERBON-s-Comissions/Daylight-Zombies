package com.cerbon.daylight_zombies.event;

import com.cerbon.daylight_zombies.DaylightZombies;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DaylightZombies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    @SubscribeEvent
    public static void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
        if (event.getEntity().getType() == EntityType.ZOMBIE)
            event.setResult(Event.Result.ALLOW);
    }
}
