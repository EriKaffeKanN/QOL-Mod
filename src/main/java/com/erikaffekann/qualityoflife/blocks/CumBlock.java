package com.erikaffekann.qualityoflife.blocks;

import com.erikaffekann.qualityoflife.CustomPlayerEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class CumBlock extends Block {
    public CumBlock() {
        super(AbstractBlock.Properties.create(Material.LAVA)
                .sound(SoundType.WET_GRASS)
                .setRequiresTool()
                .hardnessAndResistance(1F, 1F)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL));
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.attackEntityFrom(CustomPlayerEvents.cumSink, 20);
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
