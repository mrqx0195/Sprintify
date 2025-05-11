package net.mrqx.sprintify.capability.sprintifycapability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CapabilityBetterRun {

    public static final Capability<ISprintifyCapability> SPRINTIFY = CapabilityManager.get(new CapabilityToken<>() {
    });

    @SubscribeEvent
    public static void onRegisterCapabilitiesEvent(RegisterCapabilitiesEvent event) {
        event.register(ISprintifyCapability.class);
    }
}
