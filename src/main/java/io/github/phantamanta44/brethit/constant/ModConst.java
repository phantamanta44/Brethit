package io.github.phantamanta44.brethit.constant;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModConst {

    public static final String MOD_ID = "brethit";
    public static final String VERSION = "1.0.0";
    public static final String MOD_PREF = MOD_ID + ":";

    public static final CreativeTabs CREATIVE_TAB = new CreativeTabs("") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.APPLE);
        }

    };

}
