package com.erikaffekann.qualityoflife.client.models;// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.erikaffekann.qualityoflife.entities.BossEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BossEntityModelNeutral extends EntityModel<BossEntity> {
	private final ModelRenderer blob;
	private final ModelRenderer bone;
	private final ModelRenderer head;

	public BossEntityModelNeutral() {
		textureWidth = 16;
		textureHeight = 16;

		blob = new ModelRenderer(this);
		blob.setRotationPoint(0.0F, 24.0F, 0.0F);
		blob.setTextureOffset(0, 0).addBox(-6.0F, -3.0F, 0.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -2.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(-5.0F, -2.0F, -2.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -3.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(0.0F, -3.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, 3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(0.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(1.0F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(0.0F, -2.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(2.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(-4.0F, -3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		blob.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(2.0F, 0.0F, -3.0F);
		blob.addChild(bone);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-2.0F, -11.0F, -2.0F, 5.0F, 3.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-1.0F, -12.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 14).addBox(3.0F, -11.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 14).addBox(3.0F, -11.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(BossEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		blob.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}