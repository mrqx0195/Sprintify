package net.mrqx.sprintify;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.ModLoadingContext;
import net.mrqx.sprintify.event.AttachCapabilitiesEventHandler;
import net.mrqx.sprintify.event.PlayerTickEventHandler;
import org.slf4j.Logger;

@Mod(Sprintify.MODID)
public class Sprintify {
    public static final String MODID = "sprintify";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Sprintify() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SprintifyConfig.COMMON_CONFIG);
    }

    private void setup(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new AttachCapabilitiesEventHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerTickEventHandler());
    }
}
