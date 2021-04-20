package com.erikaffekann.qualityoflife.client.models;// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.erikaffekann.qualityoflife.entities.PoliceEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PoliceEntityModel extends EntityModel<PoliceEntity> {
	private final ModelRenderer bb_main;

	public PoliceEntityModel() {
		textureWidth = 72;
		textureHeight = 60;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bb_main, 0.0F, 3.1416F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 16).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(16, 16).addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(48, 0).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 32).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
		bb_main.setTextureOffset(32, 0).addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(32, 42).addBox(-7.0F, -26.0F, 9.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(41, 42).addBox(-7.0F, -26.0F, 11.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 48).addBox(-5.0F, -33.0F, -5.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);
		bb_main.setTextureOffset(54, 44).addBox(-3.0F, -31.0F, 4.0F, 6.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(PoliceEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}