package com.erikaffekann.qualityoflife.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BaseBlockItem extends BlockItem {
    public BaseBlockItem(Block blockIn) {
        super(blockIn, new Item.Properties().group(ItemGroup.MATERIALS));
    }
}
