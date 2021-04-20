package com.erikaffekann.qualityoflife.blocks.interactable;

import com.erikaffekann.qualityoflife.items.Obamium;
import com.erikaffekann.qualityoflife.misc.damagesources.InfuserDamageSource;
import com.erikaffekann.qualityoflife.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.model.BlockModel;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeItem;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.NoteBlockEvent;

import javax.annotation.Nullable;
import java.util.function.ToIntFunction;

public class Infuser extends Block {

    private int x;
    private int y;
    private int z;

    public InfuserDamageSource damageSource;

    public Infuser() {
        super(
                AbstractBlock.Properties
                .create(Material.ROCK)
                .setRequiresTool()
                .hardnessAndResistance(3.5F)
                .harvestLevel(4)
        );

        damageSource = new InfuserDamageSource();
        BlockRendererDispatcher
    }

    /**
    *Handles transfusion between diamonds and obamium
     */
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if(!(worldIn.isRemote())) {
            ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);

            // Drop obamium if holding emeralds

            if(stack.getItem() == Items.EMERALD) {//if (Item.getIdFromItem(stack.getItem()) == Item.getIdFromItem(Items.DIAMOND)) {

                stack.setCount(stack.getCount() - 1);
                dropObamium(worldIn, player);

            }

            // Check if player not holding obamium pickaxe
            else if(Item.getIdFromItem(stack.getItem()) != Item.getIdFromItem(RegistryHandler.OBAMIUM_PICKAXE.get())) {
                // Kill player if holding nothing (this jank ass solution wouldn't be required if mojang didnt fucking remove Block.getBlockHardness())
                player.attackEntityFrom(damageSource, 200);
            }

        }
    }

    private void dropObamium(World worldIn, PlayerEntity player) {
        ItemStack obamiumStack = new ItemStack(RegistryHandler.OBAMIUM.get());
        worldIn.addEntity(new ItemEntity(worldIn, player.getPosX(), player.getPosY(), player.getPosZ(), obamiumStack));
    }
}
