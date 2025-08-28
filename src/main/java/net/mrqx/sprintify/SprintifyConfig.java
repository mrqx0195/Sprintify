package net.mrqx.sprintify;

import net.neoforged.neoforge.common.ModConfigSpec;

public class SprintifyConfig {
    public static ModConfigSpec COMMON_CONFIG;

    public static ModConfigSpec.LongValue TICKS_TO_MAX_SPEED;
    public static ModConfigSpec.DoubleValue MAX_SPEED_MULTIPLIER;
    public static ModConfigSpec.DoubleValue MAX_STEP_HEIGHT_ADDITION;

    static {
        ModConfigSpec.Builder commonBuilder = new ModConfigSpec.Builder();
        commonBuilder.comment("Sprintify settings").push("common");

        TICKS_TO_MAX_SPEED = commonBuilder
                .comment("Set the time required to reach maximum speed (in ticks). (default: 100)")
                .defineInRange("ticks_to_max_speed", 100, 1, Long.MAX_VALUE);

        MAX_SPEED_MULTIPLIER = commonBuilder
                .comment("Set the maximum speed multiplier. (default: 1.0, i.e.+100%)")
                .defineInRange("max_speed_multiplier", 1.0, 0, Double.MAX_VALUE);

        MAX_STEP_HEIGHT_ADDITION = commonBuilder
                .comment("Set the maximum step height bonus. (default: 0.6)")
                .defineInRange("max_step_height_addition", 0.6, 0, Double.MAX_VALUE);

        commonBuilder.pop();
        COMMON_CONFIG = commonBuilder.build();
    }
}
