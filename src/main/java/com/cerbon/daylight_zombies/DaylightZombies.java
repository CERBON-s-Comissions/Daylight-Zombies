package com.cerbon.daylight_zombies;

import com.cerbon.daylight_zombies.config.DZConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(DaylightZombies.MOD_ID)
public class DaylightZombies {
    public static final String MOD_ID = "daylight_zombies";

    public DaylightZombies() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DZConfig.SPEC, MOD_ID + ".toml");
    }
}
