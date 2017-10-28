package io.github.phantamanta44.brethit.block.base;

import io.github.phantamanta44.brethit.item.base.ItemBlockModSubs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockModSubs extends BlockMod {

    protected final int subs;

    public BlockModSubs(Material material, int subs) {
        super(material);
        this.subs = subs;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (int i = 0; i < subs; i++)
            items.add(new ItemStack(this, 1, i));
    }

    @Override
    protected ItemBlock generateItemBlock() {
        return new ItemBlockModSubs(this);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

}
