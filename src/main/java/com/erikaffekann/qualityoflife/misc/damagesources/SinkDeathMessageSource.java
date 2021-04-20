package com.erikaffekann.qualityoflife.misc.damagesources;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;

public class SinkDeathMessageSource extends DamageSource {
    public SinkDeathMessageSource(String damageTypeIn) {
        super(damageTypeIn);
    }
}
