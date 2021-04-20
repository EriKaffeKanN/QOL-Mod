package com.erikaffekann.qualityoflife.blocks;

import com.erikaffekann.qualityoflife.misc.damagesources.SinkDeathMessageSource;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class FakeDiamondOre extends OreBlock {

    private SinkDeathMessageSource cumSink;

    public FakeDiamondOre() {
        super(AbstractBlock.Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0F, 3.0F)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
        cumSink = new SinkDeathMessageSource("sinking");
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return 1;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        player.attackEntityFrom(cumSink, 1);
    }
}
