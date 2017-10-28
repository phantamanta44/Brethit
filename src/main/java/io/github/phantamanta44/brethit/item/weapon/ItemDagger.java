package io.github.phantamanta44.brethit.item.weapon;

import io.github.phantamanta44.brethit.item.base.UtilityArchetype;
import io.github.phantamanta44.brethit.item.base.UtilityClass;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;

import java.util.function.BiConsumer;

public class ItemDagger extends ItemWeapon {

    public ItemDagger(UtilityArchetype arch) {
        super("dagger_" + arch.name, UtilityClass.W_DAGGER, arch);
    }

    @Override
    public void registerAttrs(BiConsumer<IAttribute, AttributeModifier> attrs) {
        // NO-OP
    }

}
