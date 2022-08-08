package net.yuxinhao.boson;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
// import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundEvents;

public enum ArmorMaterials implements ArmorMaterial {
    
	OBSIDIAN("obsidian", 35, new int[]{4, 7, 9, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2f, 0.1f, Ingredient.ofItems(BosonMod.OBSIDIAN_INGOT));

	public static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    public final String name;
    public final int durabilityMultiplier;
    public final int[] protectionAmounts;
    public final int enchantability;
    public final SoundEvent equipSound;
    public final float toughness;
    public final float knockbackResistance;
    public final Ingredient repairIngredientSupplier;

    private ArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Ingredient repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier;
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}