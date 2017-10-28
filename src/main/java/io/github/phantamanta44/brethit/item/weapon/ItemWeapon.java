package io.github.phantamanta44.brethit.item.weapon;

import io.github.phantamanta44.brethit.item.base.ItemUtility;
import io.github.phantamanta44.brethit.item.base.UtilityArchetype;
import io.github.phantamanta44.brethit.item.base.UtilityClass;

public abstract class ItemWeapon extends ItemUtility {

    public ItemWeapon(String name, UtilityClass uClass, UtilityArchetype arch) {
        super("w_" + name, uClass, arch);
    }

}
