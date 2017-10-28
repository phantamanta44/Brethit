package io.github.phantamanta44.brethit.item.base;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import java.util.function.BiConsumer;

public enum UtilityArchetype {

    ANCIENT("ancient", 17, 1.75F, 20F, Constants.BASE_AS, true, EnumRarity.UNCOMMON), // TODO guardian armour pierce
    ANCIENT2("ancient2", 26, 1.8F, 30F, Constants.BASE_AS, true, EnumRarity.RARE),
    ANCIENT3("ancient3", 32, 1.85F, 40F, Constants.BASE_AS, true, EnumRarity.EPIC),
    BOKO("boko", 8, 1F, 4F),
    BOKO2("boko2", 14, 1F, 12F, EnumRarity.UNCOMMON),
    BOKO3("boko3", 18, 1F, 24F, EnumRarity.RARE),
    MOBLIN("moblin", 10, 0.9F, 6F),
    MOBLIN2("moblin2", 14, 0.95F, 18F, EnumRarity.UNCOMMON),
    MOBLIN3("moblin3", 19, 1F, 30F, EnumRarity.RARE),
    STAL("stal", 5, 0.8F, 5F),
    STAL2("stal2", 8, 0.8F, 12F),
    STAL3("stal3", 5, 0.8F, 15F),
    GORON("goron", 30, 1.4F, 15F, EnumRarity.UNCOMMON),
    GORON2("goron2", 40, 1.4F, 42F, EnumRarity.RARE),
    LIZAL("lizal", 17, 1.55F, 14F, EnumRarity.UNCOMMON),
    LIZAL2("lizal2", 25, 1.55F, 24F, EnumRarity.RARE),
    LIZAL3("lizal3", 27, 1.55F, 36F, EnumRarity.RARE),
    FARMER("farmer", 5, 1.7F, 9F),
    RITO("rito", 27, 2F, 15F, EnumRarity.UNCOMMON),
    KOROK("korok", 27, 1.6F, 22F, EnumRarity.UNCOMMON),
    GERUDO("gerudo", 23, 1.65F, 18F, EnumRarity.UNCOMMON),
    ZORA("zora", 27, 1.5F, 15F, EnumRarity.UNCOMMON),
    SHEIKAH("sheikah", 26, 1.8F, 15F, EnumRarity.UNCOMMON),
    YIGA("yiga", 14, 1.8F, 16F, EnumRarity.RARE),
    YIGA2("yiga2", 25, 1.7F, 40F, EnumRarity.EPIC),
    RUSTY("rusty", 8, 1.25F, 6F),
    TRAVELER("traveler", 20, 1.4F, 5F),
    SOLDIER("soldier", 14, 1.5F, 25F, EnumRarity.UNCOMMON),
    KNIGHT("knight", 27, 1.6F, 27F, EnumRarity.UNCOMMON),
    ROYAL("royal", 36, 1.7F, 36F, EnumRarity.RARE),
    CALAMITY("calamity", 14, 1.7F, 48F, EnumRarity.EPIC),
    LYNEL("lynel", 26, 1.1F, 24F, EnumRarity.RARE),
    LYNEL2("lynel2", 32, 1F, 36F, EnumRarity.RARE),
    LYNEL3("lynel3", 41, 0.85F, 58F, EnumRarity.EPIC),
    FLAME("elem_fire", 36, 1.4F, 24F, EnumRarity.RARE),
    FROST("elem_ice", 30, 1.5F, 20F, EnumRarity.RARE),
    THUNDER("elem_elec", 36, 1.7F, 22F, EnumRarity.RARE),
    GENERIC("generic", -1, -1F, -1F, -1F, false, null) {
        @Override
        public void registerAttrs(UtilityClass uClass, BiConsumer<IAttribute, AttributeModifier> attrs) {
            // NO-OP
        }
    },
    GENERIC_ANCIENT("generic_ancient", -1, -1F, -1F, -1F, true, null) {
        @Override
        public void registerAttrs(UtilityClass uClass, BiConsumer<IAttribute, AttributeModifier> attrs) {
            // NO-OP
        }
    };

    private static class Constants {
        private static final float BASE_AS = 1.8F;
    }

    public final String name;
    public final boolean eqTex;
    public final EnumRarity rarity;

    private final int maxDmg;
    private final float baseHarvest;
    private final float baseAtkDmg;
    private final float baseAtkSpd;

    UtilityArchetype(String name, int maxDmg, float baseHarvest, float baseAtkDmg, float baseAtkSpd, boolean eqTex, EnumRarity rarity) {
        this.name = name;
        this.maxDmg = maxDmg;
        this.baseHarvest = baseHarvest;
        this.baseAtkDmg = baseAtkDmg;
        this.baseAtkSpd = baseAtkSpd;
        this.eqTex = eqTex;
        this.rarity = rarity;
    }

    UtilityArchetype(String name, int maxDmg, float baseHarvest, float baseAtkDmg, EnumRarity rarity) {
        this(name, maxDmg, baseHarvest, baseAtkDmg, Constants.BASE_AS, false, rarity);
    }

    UtilityArchetype(String name, int maxDmg, float baseHarvest, float baseAtkDmg) {
        this(name, maxDmg, baseHarvest, baseAtkDmg, EnumRarity.COMMON);
    }

    public void registerAttrs(UtilityClass uClass, BiConsumer<IAttribute, AttributeModifier> attrs) {
        attrs.accept(SharedMonsterAttributes.ATTACK_DAMAGE,
                new AttributeModifier(ItemUtility.MOD_ATK_DMG, "Tool modifier", baseAtkDmg * uClass.atkDmgFactor, 0));
        attrs.accept(SharedMonsterAttributes.ATTACK_SPEED,
                new AttributeModifier(ItemUtility.MOD_ATK_SPD, "Tool modifier", baseAtkSpd * uClass.atkSpdFactor - 4, 0));
    }

    public int getDamage(UtilityClass uClass) {
        return (int)Math.floor(maxDmg * uClass.durabilityFactor);
    }

    public float getBreakSpeed(UtilityClass uClass, ItemStack stack, IBlockState block) {
        return uClass.canHarvest(block) ? baseHarvest : 0;
    }

}
