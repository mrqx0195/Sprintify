package net.mrqx.sprintify.attachment;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.mrqx.sprintify.SprintifyConfig;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

public class SprintifyAttachment implements ISprintifyAttachment, INBTSerializable<CompoundTag> {
    public static final AttachmentType<SprintifyAttachment> SPRINTIFY = AttachmentType.serializable(SprintifyAttachment::new).build();
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

    @Override
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.@NotNull Provider provider) {
        CompoundTag tag = new CompoundTag();
        tag.putLong("runningTicks", this.getRunningTicks());
        return tag;
    }

    @Override
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void deserializeNBT(HolderLookup.@NotNull Provider provider, @NotNull CompoundTag nbt) {
        this.setRunningTicks(nbt.getLong("runningTicks"));
    }
}
