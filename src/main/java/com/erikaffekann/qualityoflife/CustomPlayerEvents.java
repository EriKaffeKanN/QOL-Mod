package com.erikaffekann.qualityoflife;

import com.erikaffekann.qualityoflife.entities.PoliceEntity;
import com.erikaffekann.qualityoflife.items.EnderShield;
import com.erikaffekann.qualityoflife.items.LightGlove;
import com.erikaffekann.qualityoflife.misc.damagesources.ArachnophobiaDamageSource;
import com.erikaffekann.qualityoflife.misc.damagesources.EndFogDamageSource;
import com.erikaffekann.qualityoflife.misc.damagesources.PunchDamageSource;
import com.erikaffekann.qualityoflife.misc.damagesources.SinkDeathMessageSource;
import com.erikaffekann.qualityoflife.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherrackBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.UUID;

@Mod.EventBusSubscriber
public class CustomPlayerEvents {
    public static ArrayList<UUID> scheduledDeaths = new ArrayList<UUID>(); // This exists because you cannot kill the player when changing dimensions

    public static SinkDeathMessageSource cumSink;
    public static ArachnophobiaDamageSource spiderDeath;
    public static PunchDamageSource punchDeath;
    public static EndFogDamageSource endFog;

    public static boolean insideFog;

    public static void init(){
        cumSink = new SinkDeathMessageSource("sinking");
        spiderDeath = new ArachnophobiaDamageSource();
        punchDeath = new PunchDamageSource();
        endFog = new EndFogDamageSource();
        insideFog = false;
    }

    @SubscribeEvent
    public static void alterFallDamage(LivingFallEvent event){
        if(event.getEntityLiving().getEntityWorld().isRemote()) return;
        if (!(event.getEntityLiving() instanceof PlayerEntity)) return;
        PlayerEntity player = (PlayerEntity)event.getEntityLiving();
        if(LightGlove.hasActiveGlove(player)) return;
        if(event.getDistance() >= 1.5F) event.setDistance(20f);
    }

    @SubscribeEvent
    public static void spiderInstaKill(LivingAttackEvent event){
        if (!(event.getEntityLiving() instanceof PlayerEntity)) return;
        PlayerEntity player = (PlayerEntity)event.getEntityLiving();
        if(LightGlove.hasActiveGlove(player)) {
            Entity spider = event.getSource().getTrueSource();
            if (spider != null & spider instanceof SpiderEntity) {
                player.attackEntityFrom(spiderDeath, 20);
            }
        }
    }

    @SubscribeEvent
    public static void punchDamage(PlayerInteractEvent.LeftClickBlock event){
        if(event.getWorld().isRemote) return;
        Item heldItem = event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem();
        if(heldItem == Items.AIR) event.getPlayer().attackEntityFrom(punchDeath, 3);
    }

    @SubscribeEvent
    public static void explodeCreeper(LivingAttackEvent event) {
        if(!(event.getEntityLiving() instanceof CreeperEntity) || event.getEntityLiving().getEntityWorld().isRemote()) return;
        if(!(event.getSource().getTrueSource() instanceof PlayerEntity)) return;
        CreeperEntity creeper = (CreeperEntity) event.getEntityLiving();
        creeper.getEntityWorld().createExplosion(creeper, creeper.getPosX(), creeper.getPosY(), creeper.getPosZ(), 15F, Explosion.Mode.BREAK);
    }

    @SubscribeEvent
    public static void dieFromFog(TickEvent.PlayerTickEvent event) {
        if(event.player.getEntityWorld().isRemote) return;
        if(!(event.player.getEntityWorld().getDimensionType().doesHasDragonFight())) return;
        if(EnderShield.getPlayerShouldDie(event.player.getUniqueID())) {
            event.player.attackEntityFrom(endFog, 200F);
        }
    }

    // Remove diamonds if you hit something with them
    // I'm a great person
    @SubscribeEvent
    public static void removeDiamondsOnHit(PlayerInteractEvent.LeftClickBlock event){
        if(!(event.getWorld().isRemote())){
            ItemStack stack = event.getItemStack();
            if(Item.getIdFromItem(stack.getItem()) != Item.getIdFromItem(Items.DIAMOND)) return;
            stack.setCount(0);
        }
    }

    @SubscribeEvent
    public static void disableGloveOnRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (event.getPlayer() == null) return;
        LightGlove.deactivateGloveFor(event.getPlayer());
    }

    @SubscribeEvent
    public static void imprisonPlayer(LivingAttackEvent event){
        if(event.getEntityLiving().getEntityWorld().isRemote()) return;
        if(!(event.getSource().getTrueSource() instanceof PoliceEntity)) return;
        PoliceEntity police = (PoliceEntity) event.getSource().getTrueSource();
        LivingEntity victim = event.getEntityLiving();

        generatePrison(
                (int)victim.getPosX(),
                (int)(victim.getPosY() - victim.getPosY() % 1)-1, // y pos is floored then subtracted by 1
                (int)victim.getPosZ(),
                victim.getEntityWorld()
        );

        police.attackEntityFrom(cumSink, 30f);
    }

    public static void generatePrison(int x, int y, int z, World worldIn){
        BlockPos basePos = new BlockPos(x,y,z);

        // Base (5x5)
        for(int ix = -2; ix <= 2; ix++){
            for(int iz = -2; iz <= 2; iz++){
                replaceBlock(basePos.add(ix, 0, iz), true, Blocks.STONE, worldIn);
            }
        }

        // Top (5x5, 4 up)
        for(int ix = -2; ix <= 2; ix++){
            for(int iz = -2; iz <= 2; iz++){
                replaceBlock(basePos.add(ix, 4, iz), true, Blocks.STONE, worldIn);
            }
        }

        // Left Wall
        for(int iz = -1; iz <= 1; iz++){
            for(int iy = -1; iy <= 1; iy++){
                replaceBlock(basePos.add(-2, 2+iy, iz), true, Blocks.IRON_BARS, worldIn);
            }
        }

        // Right Wall
        for(int iz = -1; iz <= 1; iz++){
            for(int iy = -1; iy <= 1; iy++){
                replaceBlock(basePos.add(2, 2+iy, iz), true, Blocks.IRON_BARS, worldIn);
            }
        }

        // Front Wall
        for(int ix = -2; ix <= 2; ix++){
            for(int iy = -1; iy <= 1; iy++){
                replaceBlock(basePos.add(ix, 2+iy, -2), true, Blocks.IRON_BARS, worldIn);
            }
        }

        // Back Wall
        for(int ix = -2; ix <= 2; ix++){
            for(int iy = -1; iy <= 1; iy++){
                replaceBlock(basePos.add(ix, 2+iy, 2), true, Blocks.IRON_BARS, worldIn);
            }
        }
    }

    public static void replaceBlock(BlockPos pos, boolean dropBlock, Block block, World worldIn){
        BlockState blockState = worldIn.getBlockState(pos);
        worldIn.playEvent(2001, pos, Block.getStateId(blockState));
        if(dropBlock){
            TileEntity tileEntity = blockState.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
            Block.spawnDrops(blockState, worldIn, pos.add(0, 1.5, 0), tileEntity);
        }
        worldIn.setBlockState(pos, block.getDefaultState());
    }
}
