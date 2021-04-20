package com.erikaffekann.qualityoflife.items;

import com.erikaffekann.qualityoflife.util.PlayerQuery;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EnderShield extends Item {

    private static ArrayList<PlayerQuery> activatedPlayers = new ArrayList<PlayerQuery>();

    private static int getPlayerQueryIndex(UUID playerUUID) {
        for(int q = 0; q < activatedPlayers.size(); q++) {
            if (activatedPlayers.get(q).playerUUID == playerUUID)
                return q;
        }
        activatedPlayers.add(new PlayerQuery(playerUUID, false));
        return activatedPlayers.size()-1;
    }

    public static boolean getPlayerShouldDie(UUID player) {
        int index = getPlayerQueryIndex(player);
        return !activatedPlayers.get(index).query; // player not safe
    }

    public static void setPlayerSafety(UUID player, boolean safe) {
        int index = getPlayerQueryIndex(player);
        activatedPlayers.get(index).query = safe;
    }

    public EnderShield() {
        super(new Item.Properties().group(ItemGroup.MATERIALS));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Keeps you safe from the end fog"));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!(entityIn instanceof PlayerEntity)) return;
        setPlayerSafety(entityIn.getUniqueID(), true);
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
        setPlayerSafety(player.getUniqueID(), false);
        return true;
    }
}
