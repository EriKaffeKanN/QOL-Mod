package com.erikaffekann.qualityoflife.items;

import com.erikaffekann.qualityoflife.CustomPlayerEvents;
import com.erikaffekann.qualityoflife.util.PlayerQuery;
import com.erikaffekann.qualityoflife.util.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLCommonLaunchHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber
public class LightGlove extends Item {

    private static ArrayList<PlayerQuery> activatedPlayers = new ArrayList<PlayerQuery>();

    private static int getPlayerQueryIndex(UUID playerUUID) {
        for(int q = 0; q < activatedPlayers.size(); q++) {
            if (activatedPlayers.get(q).playerUUID == playerUUID)
                return q;
        }
        activatedPlayers.add(new PlayerQuery(playerUUID, false));
        return activatedPlayers.size()-1;
    }

    public static boolean hasActiveGlove(PlayerEntity player) {
        int index = getPlayerQueryIndex(player.getUniqueID());
        return activatedPlayers.get(index).query;
    }

    public static void deactivateGloveFor(PlayerEntity player) {
        int playerIndex = getPlayerQueryIndex(player.getUniqueID());
        activatedPlayers.get(playerIndex).query = false;
    }

    public LightGlove() {
        super(new Item.Properties().group(ItemGroup.TOOLS));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A76"+"Right-Click me retard"+"\u00A7f"));
        tooltip.add(new StringTextComponent("\u00A76"+"Side effects may include arachnophopia..."+"\u00A7f"));
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        UUID playerUUID = Minecraft.getInstance().player.getUniqueID();
        int index = getPlayerQueryIndex(playerUUID);
        return activatedPlayers.get(index).query;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(worldIn.isRemote() || stack == null || stack.getItem() == null) return ActionResult.resultFail(stack);
        if(stack.getItem() == RegistryHandler.GLOVE.get()) {
            int playerIndex = getPlayerQueryIndex(playerIn.getUniqueID());
            activatedPlayers.get(playerIndex).query = !activatedPlayers.get(playerIndex).query;
            if (activatedPlayers.get(playerIndex).query) {
                worldIn.getServer().getCommandManager().handleCommand(worldIn.getServer().getCommandSource(), "tellraw " + playerIn.getName().getString() + " {\"text\":\"Activated\"}");
            }
            else {
                worldIn.getServer().getCommandManager().handleCommand(worldIn.getServer().getCommandSource(), "tellraw " + playerIn.getName().getString() + " {\"text\":\"Deactivated\"}");
            }
            return ActionResult.resultPass(stack);
        }
        return ActionResult.resultFail(stack);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
        int playerIndex = getPlayerQueryIndex(player.getUniqueID());
        activatedPlayers.get(playerIndex).query = false;
        return true;
    }
}
