package com.erikaffekann.qualityoflife.blocks.interactable;

import com.erikaffekann.qualityoflife.misc.damagesources.InfuserDamageSource;
import com.erikaffekann.qualityoflife.util.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UltraInfuser extends Block {

    private int x;
    private int y;
    private int z;

    public InfuserDamageSource damageSource;

    public UltraInfuser() {
        super(
                AbstractBlock.Properties
                        .create(Material.ROCK)
                        .setRequiresTool()
                        .hardnessAndResistance(3.5F)
                        .harvestLevel(4)
        );

        damageSource = new InfuserDamageSource();
    }

    /**
     *Handles transfusion between diamonds and obamium
     */
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if(!(worldIn.isRemote())) {
            ItemStack stack = player.getHeldItem(Hand.MAIN_HAND);

            // Drop shield if holding fake diamonds
            if (Item.getIdFromItem(stack.getItem()) == Item.getIdFromItem(RegistryHandler.FAKE_DIAMOND.get())) {

                stack.setCount(stack.getCount() - 1);
                dropShield(worldIn, player);

            }

            // Check if player not holding obamium pickaxe
            else if(Item.getIdFromItem(stack.getItem()) != Item.getIdFromItem(RegistryHandler.OBAMIUM_PICKAXE.get())) {
                // Kill player if holding nothing (this jank ass solution wouldn't be required if mojang didnt fucking remove Block.getBlockHardness())
                player.attackEntityFrom(damageSource, 200);
            }

        }
    }

    private void dropShield(World worldIn, PlayerEntity player) {
        ItemStack shieldStack = new ItemStack(RegistryHandler.ENDER_SHIELD.get());
        worldIn.addEntity(new ItemEntity(worldIn, player.getPosX(), player.getPosY(), player.getPosZ(), shieldStack));
    }
}
