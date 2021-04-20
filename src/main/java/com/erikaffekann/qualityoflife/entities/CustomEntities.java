package com.erikaffekann.qualityoflife.entities;

import com.erikaffekann.qualityoflife.QualityOfLife;
import com.erikaffekann.qualityoflife.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class CustomEntities {

    public static void registerEntityAttributes() {
        GlobalEntityTypeAttributes.put(RegistryHandler.POLICE_ENTITY.get(), PoliceEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(RegistryHandler.BOSS_ENTITY.get(), BossEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(RegistryHandler.SINK_ENTITY.get(), SinkEntity.registerAttributes().create());
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerEntityWorldSpawn(BiomeLoadingEvent event) {
        List<MobSpawnInfo.Spawners> spawns = event.getSpawns().getSpawner(EntityClassification.MONSTER);

        // All custom spawns
        spawns.add(new MobSpawnInfo.Spawners(RegistryHandler.POLICE_ENTITY.get(), 10, 1, 2));
        spawns.add(new MobSpawnInfo.Spawners(RegistryHandler.SINK_ENTITY.get(), 10, 1, 7));
    }
}
