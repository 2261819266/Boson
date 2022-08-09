package net.yuxinhao.boson;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BosonMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "boson";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static final Item 
		OBSIDIAN_INGOT = new Item(new FabricItemSettings().group(ModGroups.ITEMS))
		;

	public static final Block 
		OBSIDIAN_BLOCK = new Block(FabricBlockSettings.of(Material.STONE)
			.strength(5, 1200).sounds(BlockSoundGroup.STONE).requiresTool())
		;
	
	public static final BlockItem 
		OBSIDIAN_BLOCK_ITEM = new BlockItem(OBSIDIAN_BLOCK, new FabricItemSettings().group(ModGroups.BLOCKS));
	
	static public final ArmorMaterial ARMOR_MATERIAL = ArmorMaterials.OBSIDIAN;
	static public final ToolMaterial TOOL_MATERIAL = ToolMaterials.OBSIDIAN;

	public static final Item 
		OBSIDIAN_HELMET = new ArmorItem(ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ModGroups.ITEMS)),
		OBSIDIAN_CHESTPLATE = new ArmorItem(ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ModGroups.ITEMS)),
		OBSIDIAN_LEGGINGS = new ArmorItem(ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ModGroups.ITEMS)),
		OBSIDIAN_BOOTS = new ArmorItem(ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ModGroups.ITEMS)),

		OBSIDIAN_SWORD = new SwordItem(TOOL_MATERIAL, 3, -2, new Item.Settings().group(ModGroups.ITEMS)),
		OBSIDIAN_SHOVEL = new ShovelItem(TOOL_MATERIAL, 1, -3, new Item.Settings().group(ModGroups.ITEMS)),
		OBSIDIAN_AXE = new AxeItems(TOOL_MATERIAL, 4.5f, -3.1f, new Item.Settings().group(ModGroups.ITEMS)),
		OBSIDIAN_PICKAXE = new PickaxeItems(TOOL_MATERIAL, 0, -2.8f, new Item.Settings().group(ModGroups.ITEMS)),
		OBSIDIAN_HOE = new HoeItems(TOOL_MATERIAL, 0, 0, new Item.Settings().group(ModGroups.ITEMS))
		;

	public BosonMod addItem(String name, Item x) {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "obsidian_" + name), x);
		return this;
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		addItem("ingot", OBSIDIAN_INGOT).addItem("block", OBSIDIAN_BLOCK_ITEM);

		this
			.addItem("helmet", OBSIDIAN_HELMET)
			.addItem("chestplate", OBSIDIAN_CHESTPLATE)
			.addItem("leggings", OBSIDIAN_LEGGINGS)
			.addItem("boots", OBSIDIAN_BOOTS)

			.addItem("sword", OBSIDIAN_SWORD)
			.addItem("shovel", OBSIDIAN_SHOVEL)
			.addItem("axe", OBSIDIAN_AXE)
			.addItem("pickaxe", OBSIDIAN_PICKAXE)
			.addItem("hoe", OBSIDIAN_HOE)
		;

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_block"), OBSIDIAN_BLOCK);

		LOGGER.info("Hello Fabric world!");
	}
}
///summon minecraft:slime 30.01 -59.08 -37.21 {Brain: {memories: {}}, HurtByTimestamp: 0, Size: 30, Attributes: [{Base: 16.0d, Name: "minecraft:generic.max_health"}, {Base: 4.0d, Name: "minecraft:generic.attack_damage"}, {Base: 16.0d, Modifiers: [{Amount: -0.0034573359724754693d, Operation: 1, UUID: [I; -139883431, -2025438719, -1231902126, -1562317140], Name: "Random spawn bonus"}], Name: "minecraft:generic.follow_range"}, {Base: 0.6000000238418579d, Name: "minecraft:generic.movement_speed"}], Invulnerable: 0b, FallFlying: 0b, PortalCooldown: 0, AbsorptionAmount: 0.0f, FallDistance: 0.075444065f, DeathTime: 0s, HandDropChances: [0.085f, 0.085f], PersistenceRequired: 0b, Motion: [0.09119726272485101d, -0.15233518685055708d, 0.10128222046962035d], wasOnGround: 0b, Health: 16.0f, LeftHanded: 0b, Air: 300s, OnGround: 0b, Rotation: [318.0f, 0.0f], HandItems: [{}, {}], ArmorDropChances: [0.085f, 0.085f, 0.085f, 0.085f], Fire: -1s, ArmorItems: [{}, {}, {}, {}], CanPickUpLoot: 0b, HurtTime: 0s}
