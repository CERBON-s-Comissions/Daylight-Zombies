package com.cerbon.daylight_zombies.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class DZConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> ENTITIES;
    public static final ForgeConfigSpec.DoubleValue NO_SPAWN_PROBABILITY;

    static {
        ENTITIES = BUILDER
                .defineList("Entities", List.of(), entry -> entry instanceof String);

        NO_SPAWN_PROBABILITY = BUILDER
                .defineInRange("No Spawn Probability", 0.6, 0.0, 1.0);

        SPEC = BUILDER.build();
    }
}
