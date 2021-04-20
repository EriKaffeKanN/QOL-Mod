package com.erikaffekann.qualityoflife.client.models;// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.erikaffekann.qualityoflife.entities.SinkEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SinkEntityModel extends EntityModel<SinkEntity> {
	private final ModelRenderer Base;
	private final ModelRenderer neck;
	private final ModelRenderer body;
	private final ModelRenderer tap;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;

	public SinkEntityModel() {
		textureWidth = 25;
		textureHeight = 25;

		Base = new ModelRenderer(this);
		Base.setRotationPoint(0.0F, 24.0F, 0.0F);
		Base.setTextureOffset(0, 15).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 2.0F, 9.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(-5.0F, -2.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(-5.0F, -2.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(-4.0F, -2.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(2.0F, -2.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(4.0F, -2.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(4.0F, -2.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(-3.0F, -1.0F, 5.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(5.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		Base.setTextureOffset(0, 15).addBox(-6.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 24.0F, 0.0F);
		neck.setTextureOffset(19, 0).addBox(-1.0F, -30.0F, -5.0F, 2.0F, 28.0F, 1.0F, 0.0F, false);
		neck.setTextureOffset(19, 0).addBox(4.0F, -30.0F, -1.0F, 1.0F, 28.0F, 2.0F, 0.0F, false);
		neck.setTextureOffset(19, 0).addBox(-5.0F, -30.0F, -1.0F, 1.0F, 28.0F, 2.0F, 0.0F, false);
		neck.setTextureOffset(19, 0).addBox(-3.0F, -30.0F, -4.0F, 6.0F, 27.0F, 9.0F, 0.0F, false);
		neck.setTextureOffset(19, 0).addBox(3.0F, -30.0F, -3.0F, 1.0F, 27.0F, 6.0F, 0.0F, false);
		neck.setTextureOffset(19, 0).addBox(-4.0F, -30.0F, -3.0F, 1.0F, 27.0F, 6.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, -7.0F);
		body.setTextureOffset(0, 14).addBox(-5.0F, -31.0F, -5.0F, 11.0F, 1.0F, 17.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-7.0F, -32.0F, -7.0F, 15.0F, 1.0F, 19.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-9.0F, -33.0F, -9.0F, 19.0F, 1.0F, 21.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-11.0F, -34.0F, -11.0F, 23.0F, 1.0F, 22.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-10.0F, -37.0F, -12.0F, 21.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-10.0F, -37.0F, 11.0F, 21.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-11.0F, -37.0F, -11.0F, 2.0F, 1.0F, 22.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(10.0F, -37.0F, -11.0F, 2.0F, 1.0F, 22.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-9.0F, -38.0F, 11.0F, 19.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-11.0F, -36.0F, -11.0F, 6.0F, 2.0F, 22.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(6.0F, -36.0F, -11.0F, 6.0F, 2.0F, 22.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-5.0F, -36.0F, 6.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-5.0F, -36.0F, -11.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-5.0F, -35.0F, -6.0F, 11.0F, 1.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-5.0F, -35.0F, 3.0F, 11.0F, 1.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(-5.0F, -35.0F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(0, 14).addBox(3.0F, -35.0F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		tap = new ModelRenderer(this);
		tap.setRotationPoint(0.0F, 24.0F, -7.0F);
		tap.setTextureOffset(0, 0).addBox(-1.0F, -42.0F, 9.0F, 3.0F, 6.0F, 2.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -40.0F, 8.0F);
		tap.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.5708F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(-1.0F, -6.0F, 4.0F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -40.0F, 8.0F);
		tap.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.7854F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 1.4F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(5.0F, -36.0F, 9.0F);
		tap.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.5236F);
		cube_r3.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-4.0F, -36.0F, 9.0F);
		tap.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.5236F);
		cube_r4.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(SinkEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Base.render(matrixStack, buffer, packedLight, packedOverlay);
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		tap.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}