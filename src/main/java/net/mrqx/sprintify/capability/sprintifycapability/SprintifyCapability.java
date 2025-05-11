package net.mrqx.sprintify.capability.sprintifycapability;

import net.mrqx.sprintify.SprintifyConfig;

public class SprintifyCapability implements ISprintifyCapability {
    private long runningTicks;

    @Override
    public long getRunningTicks() {
        return this.runningTicks;
    }

    @Override
    public long setRunningTicks(long tick) {
        this.runningTicks = tick;
        return this.runningTicks;
    }

    @Override
    public Double getSpeedMultiplier() {
        return Math.min(this.runningTicks / SprintifyConfig.TICKS_TO_MAX_SPEED.get().doubleValue(), 1)
                * SprintifyConfig.MAX_SPEED_MULTIPLIER.get();
    }

    @Override
    public Double getStepHeightAddition() {
        return Math.min(this.runningTicks / SprintifyConfig.TICKS_TO_MAX_SPEED.get().doubleValue(), 1)
                * SprintifyConfig.MAX_STEP_HEIGHT_ADDITION.get();
    }
}
