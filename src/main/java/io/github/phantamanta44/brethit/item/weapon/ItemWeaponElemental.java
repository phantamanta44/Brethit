package io.github.phantamanta44.brethit.item.weapon;

import io.github.phantamanta44.brethit.item.base.UtilityArchetype;
import io.github.phantamanta44.brethit.item.base.UtilityClass;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

import java.util.function.BiConsumer;

public abstract class ItemWeaponElemental extends ItemWeapon {

    public ItemWeaponElemental(String type, UtilityClass uClass, UtilityArchetype arch) {
        super(type + "_" + arch.name, uClass, arch);
    }

    @Override
    public void registerAttrs(BiConsumer<IAttribute, AttributeModifier> attrs) {
        // NO-OP
    }

    public static class Flame extends ItemWeaponElemental {

        public Flame(String type, UtilityClass uClass) {
            super(type, uClass, UtilityArchetype.FLAME);
        }

        @Override
        public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
            target.setFire(4);
            return super.hitEntity(stack, target, attacker);
        }

    }

    public static class Frost extends ItemWeaponElemental {

        public Frost(String type, UtilityClass uClass) {
            super(type, uClass, UtilityArchetype.FROST);
        }

        @Override
        public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
            target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 30, 1, true, false));
            return super.hitEntity(stack, target, attacker);
        }

    }

    public static class Thunder extends ItemWeaponElemental {

        public Thunder(String type, UtilityClass uClass) {
            super(type, uClass, UtilityArchetype.THUNDER);
        }

        @Override
        public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
            target.world.spawnEntity(new EntityLightningBolt(target.world, target.posX, target.posY, target.posZ, false));
            return super.hitEntity(stack, target, attacker);
        }

    }

}
