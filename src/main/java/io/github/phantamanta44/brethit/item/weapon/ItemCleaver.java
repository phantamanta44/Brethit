package io.github.phantamanta44.brethit.item.weapon;

import io.github.phantamanta44.brethit.item.base.UtilityArchetype;
import io.github.phantamanta44.brethit.item.base.UtilityClass;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;

import java.util.function.BiConsumer;

public class ItemCleaver extends ItemWeapon {

    public ItemCleaver(UtilityArchetype arch) {
        super("cleaver_" + arch.name, UtilityClass.W_CLEAVER, arch);
    }

    @Override
    public void registerAttrs(BiConsumer<IAttribute, AttributeModifier> attrs) {
        // NO-OP
    }

}
