package net.mrqx.sprintify.event;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.mrqx.sprintify.Sprintify;
import net.mrqx.sprintify.attachment.SprintifyAttachment;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class PlayerTickEventHandler {
    @SubscribeEvent
    public static void onPlayerTickEvent(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        SprintifyAttachment data = player.getData(SprintifyAttachment.SPRINTIFY);

        if (player.isSprinting()) {
            data.setRunningTicks(data.getRunningTicks() + 1);
        } else {
            data.setRunningTicks(0);
        }

        AttributeModifier runSpeed = new AttributeModifier(Sprintify.prefix("speed_attribute"), data.getSpeedMultiplier(), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

        AttributeInstance speedInstance = player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speedInstance != null) {
            speedInstance.removeModifier(runSpeed);
            if (data.getSpeedMultiplier() != 0) {
                speedInstance.addPermanentModifier(runSpeed);
            }
        }

        AttributeModifier stepHeight = new AttributeModifier(Sprintify.prefix("step_height_attribute"), data.getStepHeightAddition(), AttributeModifier.Operation.ADD_VALUE);

        AttributeInstance stepInstance = player.getAttribute(Attributes.STEP_HEIGHT);
        if (stepInstance != null) {
            stepInstance.removeModifier(stepHeight);
            if (data.getSpeedMultiplier() != 0) {
                stepInstance.addPermanentModifier(stepHeight);
            }
        }
    }
}
