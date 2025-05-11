package net.mrqx.sprintify.capability.sprintifycapability;

public interface ISprintifyCapability {
    long getRunningTicks();

    long setRunningTicks(long tick);

    Double getSpeedMultiplier();

    Double getStepHeightAddition();
}
