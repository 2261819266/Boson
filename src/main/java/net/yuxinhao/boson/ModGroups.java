package net.yuxinhao.boson;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModGroups {
    static final ItemGroup ITEMS = FabricItemGroupBuilder.build(new Identifier(BosonMod.MOD_ID, "items"), () -> new ItemStack(BosonMod.ObsidianIngot));
    static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(new Identifier(BosonMod.MOD_ID, "blocks"), () -> new ItemStack(BosonMod.ObsidianBlockItem));
}
