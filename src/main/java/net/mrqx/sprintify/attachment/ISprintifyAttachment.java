package net.mrqx.sprintify.attachment;

public interface ISprintifyAttachment {
    long getRunningTicks();

    long setRunningTicks(long tick);

    Double getSpeedMultiplier();

    Double getStepHeightAddition();
}
