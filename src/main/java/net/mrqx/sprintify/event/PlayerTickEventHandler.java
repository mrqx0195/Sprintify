package net.mrqx.sprintify.event;

import java.util.UUID;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.mrqx.sprintify.capability.sprintifycapability.SprintifyCapabilityProvider;

public class PlayerTickEventHandler {
    @SubscribeEvent
    public void onPlayerTickEvent(PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START)
            return;

        Player player = event.player;
        player.getCapability(SprintifyCapabilityProvider.SPRINTIFY).ifPresent(cap -> {
            if (player.isSprinting()) {
                cap.setRunningTicks(cap.getRunningTicks() + 1);
            } else {
                cap.setRunningTicks(0);
            }

            AttributeModifier runSpeed = new AttributeModifier(
                    UUID.fromString("12763c6d-3a74-4551-bd5d-fdb2e27ee6ce"),
                    "Sprintify Speed", cap.getSpeedMultiplier(), AttributeModifier.Operation.MULTIPLY_TOTAL);

            AttributeInstance speedInstance = player.getAttribute(Attributes.MOVEMENT_SPEED);
            if (speedInstance != null) {
                speedInstance.removeModifier(runSpeed);
                if (cap.getSpeedMultiplier() != 0) {
                    speedInstance.addPermanentModifier(runSpeed);
                }
            }

            AttributeModifier stepHeight = new AttributeModifier(
                    UUID.fromString("0aa15353-26e2-4e85-8042-1fe4c65a8c3c"),
                    "Sprintify Step Height", cap.getStepHeightAddition(), AttributeModifier.Operation.ADDITION);

            AttributeInstance stepInstance = player.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get());
            if (stepInstance != null) {
                stepInstance.removeModifier(stepHeight);
                if (cap.getSpeedMultiplier() != 0) {
                    stepInstance.addPermanentModifier(stepHeight);
                }
            }
        });
    }
}
