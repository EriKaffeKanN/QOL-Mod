package com.erikaffekann.qualityoflife.client.render;

import com.erikaffekann.qualityoflife.QualityOfLife;
import com.erikaffekann.qualityoflife.client.models.SinkEntityModel;
import com.erikaffekann.qualityoflife.entities.PoliceEntity;
import com.erikaffekann.qualityoflife.entities.SinkEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class SinkEntityRender extends MobRenderer<SinkEntity, SinkEntityModel> {

    public SinkEntityRender(EntityRendererManager rendererManager) {
        super(rendererManager, new SinkEntityModel(), 1.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(SinkEntity entity) {
        return new ResourceLocation(QualityOfLife.MOD_ID, "textures/entities/sink_entity.png");
    }

    @Override
    protected void preRenderCallback(SinkEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.7F, 0.7F, 0.7F);
    }

    public static class RenderFactory implements IRenderFactory<SinkEntity> {
        @Override
        public EntityRenderer<? super SinkEntity> createRenderFor(EntityRendererManager manager) {
            return new SinkEntityRender(manager);
        }
    }
}
