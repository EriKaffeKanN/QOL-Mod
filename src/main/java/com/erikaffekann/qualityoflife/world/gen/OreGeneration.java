package com.erikaffekann.qualityoflife.world.gen;

import com.erikaffekann.qualityoflife.QualityOfLife;
import com.erikaffekann.qualityoflife.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class OreGeneration {

    public static final ArrayList<ConfiguredFeature<?,?>> OVERWORLD_ORES = new ArrayList<ConfiguredFeature<?,?>>();

    // Register ores (not as in register the blocks)
    public static void registerCustomOres(){
        OVERWORLD_ORES.add(register(
                "fake_diamond_ore",
                Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                                RegistryHandler.FAKE_DIAMOND_ORE.get().getDefaultState(), // Block Register (default state)
                                8)) // Vein size
                    .range(16).square() // Spawn height start
                    .func_242731_b(20) // Chunk spawn frequency
        ));
        OVERWORLD_ORES.add(register(
                "cum_block",
                Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                                RegistryHandler.CUM_BLOCK.get().getDefaultState(), // Block Register (default state)
                                4)) // Vein size
                        .range(72).square() // Spawn height start
                        .func_242731_b(90) // Chunk spawn frequency
        ));
        OVERWORLD_ORES.add(register(
                "infuser",
                Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                                RegistryHandler.INFUSER.get().getDefaultState(), // Block Register (default state)
                                3)) // Vein size
                        .range(16).square() // Spawn height start
                        .func_242731_b(20) // Chunk spawn frequency
        ));
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        for(ConfiguredFeature<?, ?> ore : OVERWORLD_ORES){
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, QualityOfLife.MOD_ID + ":" + name, configuredFeature);
    }
}
