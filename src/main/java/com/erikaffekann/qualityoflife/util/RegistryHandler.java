package com.erikaffekann.qualityoflife.util;

import com.erikaffekann.qualityoflife.QualityOfLife;
import com.erikaffekann.qualityoflife.blocks.BaseBlockItem;
import com.erikaffekann.qualityoflife.blocks.CumBlock;
import com.erikaffekann.qualityoflife.blocks.FakeDiamondOre;
import com.erikaffekann.qualityoflife.blocks.interactable.Infuser;
import com.erikaffekann.qualityoflife.blocks.interactable.UltraInfuser;
import com.erikaffekann.qualityoflife.entities.BossEntity;
import com.erikaffekann.qualityoflife.entities.PoliceEntity;
import com.erikaffekann.qualityoflife.entities.SinkEntity;
import com.erikaffekann.qualityoflife.items.BaseItem;
import com.erikaffekann.qualityoflife.items.EnderShield;
import com.erikaffekann.qualityoflife.items.LightGlove;
import com.erikaffekann.qualityoflife.items.Obamium;
import com.erikaffekann.qualityoflife.tools.ObamiumPickaxe;
import com.erikaffekann.qualityoflife.tools.ObamiumSword;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, QualityOfLife.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QualityOfLife.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, QualityOfLife.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> GLOVE = ITEMS.register("light_glove", LightGlove::new);
    public static final RegistryObject<Item> FAKE_DIAMOND = ITEMS.register("fake_diamond", () -> new BaseItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> OBAMIUM = ITEMS.register("obamium", Obamium::new);
    public static final RegistryObject<Item> ENDER_SHIELD = ITEMS.register("ender_shield", EnderShield::new);

    // Entity Initialization
    static final EntityType<PoliceEntity> policeEntity = EntityType.Builder.create(PoliceEntity::new, EntityClassification.MONSTER).build(QualityOfLife.MOD_ID + ".police_entity");
    static final EntityType<BossEntity> bossEntity = EntityType.Builder.create(BossEntity::new, EntityClassification.MONSTER).build(QualityOfLife.MOD_ID + ".boss_entity");
    static final EntityType<SinkEntity> sinkEntity = EntityType.Builder.create(SinkEntity::new, EntityClassification.MONSTER).size(0.7f, 1.7f).build(QualityOfLife.MOD_ID + ".sink_entity");

    // Spawn Eggs
    public static final RegistryObject<Item> POLICE_SPAWN_EGG = ITEMS.register("police_spawn_egg", () -> new SpawnEggItem(policeEntity, 0x2433a3, 0x2ecadb, new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> SINK_SPAWN_EGG = ITEMS.register("sink_spawn_egg", () -> new SpawnEggItem(sinkEntity, 0xffffff, 0xc2edeb, new Item.Properties().group(ItemGroup.MATERIALS)));

    // Tools
    public static final RegistryObject<SwordItem> OBAMIUM_SWORD = ITEMS.register("obamium_sword", ObamiumSword::new);
    public static final RegistryObject<PickaxeItem> OBAMIUM_PICKAXE = ITEMS.register("obamium_pickaxe", ObamiumPickaxe::new);

    // Blocks
    public static final RegistryObject<Block> CUM_BLOCK = BLOCKS.register("cum_block", CumBlock::new);
    public static final RegistryObject<Block> FAKE_DIAMOND_ORE = BLOCKS.register("fake_diamond_ore", FakeDiamondOre::new);
        // Interactable
    public static final RegistryObject<Block> INFUSER = BLOCKS.register("infuser", Infuser::new);
    public static final RegistryObject<Block> ULTRA_INFUSER = BLOCKS.register("ultra_infuser", UltraInfuser::new);

    // Block Items
    public static final RegistryObject<Item> CUM_BLOCK_ITEM = ITEMS.register("cum_block", () -> new BaseBlockItem(CUM_BLOCK.get()));
    public static final RegistryObject<Item> FAKE_DIAMOND_ORE_ITEM = ITEMS.register("fake_diamond_ore", () -> new BaseBlockItem(FAKE_DIAMOND_ORE.get()));
    public static final RegistryObject<Item> INFUSER_ITEM = ITEMS.register("infuser", () -> new BaseBlockItem(INFUSER.get()));
    public static final RegistryObject<Item> ULTRA_INFUSER_ITEM = ITEMS.register("ultra_infuser", () -> new BaseBlockItem(ULTRA_INFUSER.get()));

    // Entities (registering)
    public static final RegistryObject<EntityType<PoliceEntity>> POLICE_ENTITY = ENTITIES.register("police_entity", () -> policeEntity);
    public static final RegistryObject<EntityType<BossEntity>> BOSS_ENTITY = ENTITIES.register("boss_entity", () -> bossEntity);
    public static final RegistryObject<EntityType<SinkEntity>> SINK_ENTITY = ENTITIES.register("sink_entity", () -> sinkEntity);

}
