package com.erikaffekann.qualityoflife.client.render;

import com.erikaffekann.qualityoflife.entities.PoliceEntity;
import com.erikaffekann.qualityoflife.util.RegistryHandler;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.model.CreeperModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class CustomRenderRegistry {

    public static void registryEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.POLICE_ENTITY.get(), new PoliceEntityRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.BOSS_ENTITY.get(), new BossEntityRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.SINK_ENTITY.get(), new SinkEntityRender.RenderFactory());
    }
}
