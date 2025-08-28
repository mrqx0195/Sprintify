package net.mrqx.sprintify;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.mrqx.sprintify.attachment.SprintifyAttachment;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

@Mod(Sprintify.MODID)
@EventBusSubscriber
public class Sprintify {
    public static final String MODID = "sprintify";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Sprintify(ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, SprintifyConfig.COMMON_CONFIG);
    }

    @SubscribeEvent
    public static void onRegister(RegisterEvent event) {
        event.register(NeoForgeRegistries.ATTACHMENT_TYPES.key(), helper ->
                helper.register(Sprintify.prefix("sprintify"), SprintifyAttachment.SPRINTIFY));
    }

    public static ResourceLocation prefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "sprintify");
    }
}
