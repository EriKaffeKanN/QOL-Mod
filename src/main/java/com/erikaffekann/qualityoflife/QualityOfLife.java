package com.erikaffekann.qualityoflife;

import com.erikaffekann.qualityoflife.client.render.CustomRenderRegistry;
import com.erikaffekann.qualityoflife.entities.CustomEntities;
import com.erikaffekann.qualityoflife.util.RegistryHandler;
import com.erikaffekann.qualityoflife.world.gen.OreGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.ParallelDispatchEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("qolmod")
public class QualityOfLife
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "qolmod";

    public QualityOfLife() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register Items, Blocks, etc.
        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        OreGeneration.registerCustomOres();
        CustomPlayerEvents.init();
        event.enqueueWork(CustomEntities::registerEntityAttributes);
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        CustomRenderRegistry.registryEntityRenders();
    }
}
