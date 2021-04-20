package com.erikaffekann.qualityoflife.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

public class ObamiumSword extends SwordItem {
    public ObamiumSword() {
        super(ModItemTier.OBAMIUM, 2, -2.4F, new Item.Properties().group(ItemGroup.COMBAT));
    }
}
