package io.github.phantamanta44.brethit.item.base;

import com.google.common.collect.Multimap;
import io.github.phantamanta44.brethit.util.HarvestPredicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;

import java.util.function.BiConsumer;

public abstract class ItemUtility extends ItemMod {

    private final UtilityClass uClass;
    private final UtilityArchetype arch;
    private final HarvestPredicate harvestability;

    public ItemUtility(String name, int maxDamage, UtilityClass uClass, UtilityArchetype arch) {
        super(name);
        this.uClass = uClass;
        this.arch = arch;
        this.harvestability = uClass.harvestability;
        setMaxStackSize(1);
        setMaxDamage(maxDamage);
    }

    @Override
    public boolean canHarvestBlock(IBlockState block) {
        return harvestability.test(block);
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> attrs = super.getItemAttributeModifiers(equipmentSlot);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            BiConsumer<IAttribute, AttributeModifier> addFunc = (a, m) -> attrs.put(a.getName(), m);
            arch.registerAttrs(uClass, addFunc);
            registerAttrs(addFunc);
        }
        return attrs;
    }

    public abstract void registerAttrs(BiConsumer<IAttribute, AttributeModifier> attrs);

}
