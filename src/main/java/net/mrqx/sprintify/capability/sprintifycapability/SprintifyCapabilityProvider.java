package net.mrqx.sprintify.capability.sprintifycapability;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class SprintifyCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static final Capability<ISprintifyCapability> SPRINTIFY = CapabilityManager.get(new CapabilityToken<>() {
    });

    protected LazyOptional<ISprintifyCapability> betterRunState = LazyOptional.of(() -> new SprintifyCapability());

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        betterRunState.ifPresent(instance -> {
            compoundTag.putLong("runningTicks", instance.getRunningTicks());
        });
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        betterRunState.ifPresent(instance -> {
            instance.setRunningTicks(nbt.getLong("runningTicks"));
        });
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return SPRINTIFY.orEmpty(cap, betterRunState);
    }

}
