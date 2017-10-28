package io.github.phantamanta44.brethit.item.base;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.ItemStack;

import java.util.function.BiConsumer;

public enum UtilityArchetype {

    ANCIENT("ancient", 17, 1.75F, 20F, Constants.BASE_AS, true) {

    };

    private static class Constants {
        private static final float BASE_AS = 1.8F;
    }

    public final String name;
    public final boolean eqTex;

    private final int maxDmg;
    private final float baseHarvest;
    private final float baseAtkDmg;
    private final float baseAtkSpd;

    UtilityArchetype(String name, int maxDmg, float baseHarvest, float baseAtkDmg, float baseAtkSpd, boolean eqTex) {
        this.name = name;
        this.maxDmg = maxDmg;
        this.baseHarvest = baseHarvest;
        this.baseAtkDmg = baseAtkDmg;
        this.baseAtkSpd = baseAtkSpd;
        this.eqTex = eqTex;
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
