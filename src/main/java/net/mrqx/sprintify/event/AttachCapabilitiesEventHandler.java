package net.mrqx.sprintify.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.mrqx.sprintify.Sprintify;
import net.mrqx.sprintify.capability.sprintifycapability.SprintifyCapabilityProvider;

public class AttachCapabilitiesEventHandler {
    public static final ResourceLocation SPRINTIFY_KEY = new ResourceLocation(Sprintify.MODID, "sprintify");

    @SubscribeEvent
    public void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof Player))
            return;
        event.addCapability(SPRINTIFY_KEY, new SprintifyCapabilityProvider());
    }
}
