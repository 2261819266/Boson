package net.yuxinhao.boson;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
		ObsidianIngot = new Item(new FabricItemSettings().group(ModGroups.ITEMS))
		;

	public static final Block 
		ObsidianBlock = new Block(FabricBlockSettings.of(Material.STONE)
			.strength(5, 1200).sounds(BlockSoundGroup.STONE).requiresTool())
		;
	
	public static final BlockItem 
		ObsidianBlockItem = new BlockItem(ObsidianBlock, new FabricItemSettings().group(ModGroups.BLOCKS));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "obsidian_ingot"), ObsidianIngot);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "obsidian_block"), ObsidianBlockItem);

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_block"), ObsidianBlock);

		LOGGER.info("Hello Fabric world!");
	}
}
