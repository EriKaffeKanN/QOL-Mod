package com.erikaffekann.qualityoflife.tools;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ObamiumPickaxe extends PickaxeItem {
    public ObamiumPickaxe() {
        super(ModItemTier.OBAMIUM, -1, -1, new Item.Properties().group(ItemGroup.TOOLS));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("Looks strong enough to break infusers..."));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
