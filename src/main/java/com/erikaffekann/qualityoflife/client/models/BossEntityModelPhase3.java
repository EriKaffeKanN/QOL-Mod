package com.erikaffekann.qualityoflife.client.models;// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.erikaffekann.qualityoflife.entities.BossEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BossEntityModelPhase3 extends EntityModel<BossEntity> {
	private final ModelRenderer blob;
	private final ModelRenderer bone;
	private final ModelRenderer head;
	private final ModelRenderer whenyou;
	private final ModelRenderer w;
	private final ModelRenderer h;
	private final ModelRenderer e;
	private final ModelRenderer n;
	private final ModelRenderer y;
	private final ModelRenderer o;
	private final ModelRenderer u;

	public BossEntityModelPhase3() {
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

		whenyou = new ModelRenderer(this);
		whenyou.setRotationPoint(-2.0F, 24.0F, -9.0F);
		

		w = new ModelRenderer(this);
		w.setRotationPoint(3.0F, 0.0F, 6.0F);
		whenyou.addChild(w);
		w.setTextureOffset(12, 13).addBox(-1.0F, -17.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		w.setTextureOffset(12, 13).addBox(-1.0F, -19.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		w.setTextureOffset(12, 13).addBox(-1.0F, -17.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		w.setTextureOffset(12, 13).addBox(-1.0F, -17.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		w.setTextureOffset(12, 13).addBox(-1.0F, -19.0F, -7.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		w.setTextureOffset(12, 13).addBox(-1.0F, -19.0F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		w.setTextureOffset(12, 13).addBox(-1.0F, -15.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		w.setTextureOffset(12, 13).addBox(-1.0F, -15.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		w.setTextureOffset(12, 13).addBox(-1.0F, -17.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		h = new ModelRenderer(this);
		h.setRotationPoint(3.0F, -1.0F, 21.0F);
		whenyou.addChild(h);
		h.setTextureOffset(12, 13).addBox(-1.0F, -20.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		h.setTextureOffset(12, 13).addBox(-1.0F, -17.0F, 3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		h.setTextureOffset(12, 13).addBox(-1.0F, -17.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		e = new ModelRenderer(this);
		e.setRotationPoint(3.0F, 0.0F, 25.0F);
		whenyou.addChild(e);
		e.setTextureOffset(12, 13).addBox(-1.0F, -15.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		e.setTextureOffset(12, 13).addBox(-1.0F, -19.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		e.setTextureOffset(12, 13).addBox(-1.0F, -17.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		e.setTextureOffset(12, 13).addBox(-1.0F, -19.0F, 1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		n = new ModelRenderer(this);
		n.setRotationPoint(3.0F, 0.0F, -18.0F);
		whenyou.addChild(n);
		n.setTextureOffset(12, 13).addBox(-1.0F, -19.0F, 5.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		n.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 7.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		n.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		y = new ModelRenderer(this);
		y.setRotationPoint(3.0F, 0.0F, 4.0F);
		whenyou.addChild(y);
		y.setTextureOffset(12, 13).addBox(-1.0F, -16.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		y.setTextureOffset(12, 13).addBox(-1.0F, -15.0F, 11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		y.setTextureOffset(12, 13).addBox(-1.0F, -14.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		y.setTextureOffset(12, 13).addBox(-1.0F, -17.0F, 13.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		y.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 14.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		y.setTextureOffset(12, 13).addBox(-1.0F, -17.0F, 11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		y.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		o = new ModelRenderer(this);
		o.setRotationPoint(3.0F, 0.0F, -25.0F);
		whenyou.addChild(o);
		o.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 16.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		o.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 17.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		o.setTextureOffset(12, 13).addBox(-1.0F, -15.0F, 17.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		o.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 19.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		u = new ModelRenderer(this);
		u.setRotationPoint(3.0F, 0.0F, -12.0F);
		whenyou.addChild(u);
		u.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 22.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		u.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 24.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		u.setTextureOffset(12, 13).addBox(-1.0F, -18.0F, 23.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		u.setTextureOffset(12, 14).addBox(-1.0F, -16.0F, 23.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(BossEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.push();
		matrixStack.translate(0D, 1.5D, 0D);
		matrixStack.scale(9f, 9f, 9f);
		matrixStack.pop();
		blob.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		whenyou.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}