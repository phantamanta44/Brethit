package io.github.phantamanta44.brethit.item;

import io.github.phantamanta44.brethit.item.base.ItemUtility;
import io.github.phantamanta44.brethit.item.base.UtilityArchetype;
import io.github.phantamanta44.brethit.item.base.UtilityClass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import java.util.function.BiConsumer;

public class ItemUtilityUnique extends ItemUtility {

    private final float atkDmg;
    private final float breakSpeed;
    private final EnumRarity rarity;

    public ItemUtilityUnique(String name, UtilityClass uClass, int durability, float atkDmg, float breakSpeed, EnumRarity rarity, boolean ancient) {
        super(name, uClass, ancient ? UtilityArchetype.GENERIC_ANCIENT : UtilityArchetype.GENERIC);
        setMaxDamage(durability);
        this.atkDmg = atkDmg;
        this.breakSpeed = breakSpeed;
        this.rarity = rarity;
    }

    public ItemUtilityUnique(String name, UtilityClass uClass, int durability, float atkDmg, float breakSpeed, EnumRarity rarity) {
        this(name, uClass, durability, atkDmg, breakSpeed, rarity, false);
    }

    public ItemUtilityUnique(String name, UtilityClass uClass, int durability, float atkDmg, float breakSpeed) {
        this(name, uClass, durability, atkDmg, breakSpeed, EnumRarity.COMMON);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState block) {
        return uClass.canHarvest(block) ? breakSpeed : 0;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return rarity;
    }

    @Override
    public void registerAttrs(BiConsumer<IAttribute, AttributeModifier> attrs) {
        attrs.accept(SharedMonsterAttributes.ATTACK_DAMAGE,
                new AttributeModifier(ItemUtility.MOD_ATK_DMG, "Tool modifier", atkDmg, 0));
        attrs.accept(SharedMonsterAttributes.ATTACK_SPEED,
                new AttributeModifier(ItemUtility.MOD_ATK_SPD, "Tool modifier", uClass.atkSpdFactor - 4, 0));
    }

}
