package com.erikaffekann.qualityoflife.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class BossEntity extends MonsterEntity {

    public BossEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 3.0D, true));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        // MonsterEntity.func_234295_ep_() creates an instance of an attribute map and gives it a value
        // MonsterEntity.registerAttributes() does the same things as this function essentially, it is meant to be used to
        // return a default mapping (for monsters)
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0d)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 5.0d);
    }
}
