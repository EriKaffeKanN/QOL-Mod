package com.erikaffekann.qualityoflife.entities.customgoals;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.Difficulty;

import java.util.function.Predicate;

public class AggresiveBreakDoorGoal extends BreakDoorGoal {

    private Predicate<Difficulty> difficultyPredicate;

    public AggresiveBreakDoorGoal(MobEntity entity, Predicate<Difficulty> difficultyPredicate) {
        super(entity, difficultyPredicate);
        this.difficultyPredicate = difficultyPredicate;
    }

    public AggresiveBreakDoorGoal(MobEntity entity, int timeToBreak, Predicate<Difficulty> difficultyPredicate) {
        super(entity, timeToBreak, difficultyPredicate);
        this.difficultyPredicate = difficultyPredicate;
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return true;
    }

    private boolean correctDifficulty(Difficulty difficulty) {
        return this.difficultyPredicate.test(difficulty);
    }
}
