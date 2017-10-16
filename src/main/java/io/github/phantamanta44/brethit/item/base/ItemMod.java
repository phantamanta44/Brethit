package io.github.phantamanta44.brethit.item.base;

import io.github.phantamanta44.brethit.constant.ModConst;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemMod extends Item {

    public ItemMod(String name) {
        setCreativeTab(ModConst.CREATIVE_TAB);
        registerItem(name);
    }

    protected void registerItem(String name) {
        setUnlocalizedName(name);
        if (!Item.REGISTRY.containsKey(new ResourceLocation(ModConst.MOD_ID, name))) {
            setRegistryName(name);
            ForgeRegistries.ITEMS.register(this);
        }
    }

    @Override
    public String getUnlocalizedNameInefficiently(ItemStack stack) {
        return super.getUnlocalizedNameInefficiently(stack).replaceAll("item\\.", "item." + ModConst.MOD_PREF);
    }

}
