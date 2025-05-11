package net.mrqx.sprintify;

import net.minecraftforge.common.ForgeConfigSpec;

public class SprintifyConfig {
        public static ForgeConfigSpec COMMON_CONFIG;

        public static ForgeConfigSpec.LongValue TICKS_TO_MAX_SPEED;
        public static ForgeConfigSpec.DoubleValue MAX_SPEED_MULTIPLIER;
        public static ForgeConfigSpec.DoubleValue MAX_STEP_HEIGHT_ADDITION;

        static {
                ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
                COMMON_BUILDER.comment("Sprintify settings").push("common");

                TICKS_TO_MAX_SPEED = COMMON_BUILDER
                                .comment("Set the time required to reach maximum speed (in ticks). (default: 100)")
                                .defineInRange("ticks_to_max_speed", 100, 1, Long.MAX_VALUE);

                MAX_SPEED_MULTIPLIER = COMMON_BUILDER
                                .comment("Set the maximum speed multiplier. (default: 1.0, i.e.+100%)")
                                .defineInRange("max_speed_multiplier", 1.0, 0, Double.MAX_VALUE);

                MAX_STEP_HEIGHT_ADDITION = COMMON_BUILDER
                                .comment("Set the maximum step height bonus. (default: 0.6)")
                                .defineInRange("max_step_height_addition", 0.6, 0, Double.MAX_VALUE);

                COMMON_BUILDER.pop();
                COMMON_CONFIG = COMMON_BUILDER.build();
        }
}
