package com.erikaffekann.qualityoflife.client.render;

import com.erikaffekann.qualityoflife.QualityOfLife;
import com.erikaffekann.qualityoflife.client.models.BossEntityModelNeutral;
import com.erikaffekann.qualityoflife.client.models.BossEntityModelPhase3;
import com.erikaffekann.qualityoflife.client.models.PoliceEntityModel;
import com.erikaffekann.qualityoflife.entities.BossEntity;
import com.erikaffekann.qualityoflife.entities.PoliceEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

@OnlyIn(Dist.CLIENT)
public class BossEntityRender extends LivingRenderer<BossEntity, BossEntityModelPhase3> {

    public BossEntityRender(EntityRendererManager rendererManager) {
        super(rendererManager, new BossEntityModelPhase3(), 1f);
    }

    @Override
    public ResourceLocation getEntityTexture(BossEntity entity) {
        return new ResourceLocation(QualityOfLife.MOD_ID, "textures/entities/boss_entity.png");
    }

    public static class RenderFactory implements IRenderFactory<BossEntity> {
        @Override
        public EntityRenderer<? super BossEntity> createRenderFor(EntityRendererManager manager) {
            return new BossEntityRender(manager);
        }
    }

    @Override
    public void render(BossEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0D, 1.5D, 0D);
        matrixStackIn.scale(9f, 9f, 9f);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
}
