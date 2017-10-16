package io.github.phantamanta44.brethit.item.base;

import io.github.phantamanta44.brethit.constant.ModConst;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public abstract class ItemBlockMod extends ItemBlock {

    public ItemBlockMod(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedNameInefficiently(ItemStack stack) {
        return super.getUnlocalizedNameInefficiently(stack).replaceAll("tile\\.", "tile." + ModConst.MOD_PREF);
    }

}
