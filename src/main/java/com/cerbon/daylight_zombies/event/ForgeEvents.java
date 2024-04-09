package com.cerbon.daylight_zombies.event;

import com.cerbon.daylight_zombies.DaylightZombies;
import com.cerbon.daylight_zombies.config.DZConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;

@Mod.EventBusSubscriber(modid = DaylightZombies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    private static HashSet<? extends EntityType<?>> decreaseSpawn;

    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        if (decreaseSpawn == null)
            decreaseSpawn = new HashSet<>(DZConfig.ENTITIES.get().stream().map(entityKey -> ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.tryParse(entityKey))).toList());

        if (decreaseSpawn.contains(event.getEntity().getType()) && DZConfig.NO_SPAWN_PROBABILITY.get() != 0 && event.getLevel().getRandom().nextFloat() <= DZConfig.NO_SPAWN_PROBABILITY.get())
            event.setCanceled(true);
    }
}
