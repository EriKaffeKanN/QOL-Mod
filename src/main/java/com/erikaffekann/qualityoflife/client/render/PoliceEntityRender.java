package com.erikaffekann.qualityoflife.client.render;

import com.erikaffekann.qualityoflife.QualityOfLife;
import com.erikaffekann.qualityoflife.client.models.PoliceEntityModel;
import com.erikaffekann.qualityoflife.entities.PoliceEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class PoliceEntityRender extends LivingRenderer<PoliceEntity, PoliceEntityModel> {

    public PoliceEntityRender(EntityRendererManager rendererManager) {
        super(rendererManager, new PoliceEntityModel(), 1f);
    }

    @Override
    public ResourceLocation getEntityTexture(PoliceEntity entity) {
        return new ResourceLocation(QualityOfLife.MOD_ID, "textures/entities/police_entity.png");
    }

    public static class RenderFactory implements IRenderFactory<PoliceEntity> {
        @Override
        public EntityRenderer<? super PoliceEntity> createRenderFor(EntityRendererManager manager) {
            return new PoliceEntityRender(manager);
        }
    }


}
