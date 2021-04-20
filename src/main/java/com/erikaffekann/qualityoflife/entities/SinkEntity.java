package com.erikaffekann.qualityoflife.entities;

import com.erikaffekann.qualityoflife.entities.customgoals.AggresiveBreakDoorGoal;
import com.erikaffekann.qualityoflife.entities.customgoals.CustomFollowTargetGoal;
import com.erikaffekann.qualityoflife.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class SinkEntity extends MonsterEntity {

    public SinkEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(RegistryHandler.SINK_ENTITY.get(), worldIn);
    }

    private static final Predicate<Difficulty> breakDoorCondition = (difficulty) -> true;

    @Override
    protected void registerGoals() {
        ((GroundPathNavigator)this.getNavigator()).setBreakDoors(true);
        this.goalSelector.addGoal(0, new BreakDoorGoal(this, breakDoorCondition));
        this.goalSelector.addGoal(1, new CustomFollowTargetGoal(this, 0.5D, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
        this.goalSelector.addGoal(5, new SwimGoal(this));

    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 75.0d)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 30D);
    }
}
