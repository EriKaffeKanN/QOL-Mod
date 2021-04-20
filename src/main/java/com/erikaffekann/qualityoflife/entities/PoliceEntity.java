package com.erikaffekann.qualityoflife.entities;

import com.erikaffekann.qualityoflife.util.RegistryHandler;
import net.minecraft.advancements.criterion.PlacedBlockTrigger;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import sun.security.provider.ConfigFile;

import javax.xml.stream.events.Attribute;

public class PoliceEntity extends MonsterEntity {

    public PoliceEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(RegistryHandler.POLICE_ENTITY.get(), worldIn);
        setCustomNameVisible(false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, false));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        // MonsterEntity.func_234295_ep_() creates an instance of an attribute map and gives it a value
        // MonsterEntity.registerAttributes() does the same things as this function essentially, it is meant to be used to
        // return a default mapping (for monsters)
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0d)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.7D);
    }

    @Override
    public boolean isCustomNameVisible() {
        return false;
    }
}
