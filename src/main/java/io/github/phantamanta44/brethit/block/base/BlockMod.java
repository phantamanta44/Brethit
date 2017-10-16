package io.github.phantamanta44.brethit.block.base;

import io.github.phantamanta44.brethit.constant.ModConst;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public abstract class BlockMod extends Block {

    public BlockMod(Material material) {
        super(material);
        setCreativeTab(ModConst.CREATIVE_TAB);
    }

    protected ItemBlock registerBlock(String name) {
        setUnlocalizedName(name);
        if (!Block.REGISTRY.containsKey(new ResourceLocation(ModConst.MOD_ID, name))) {
            setRegistryName(name);
            ForgeRegistries.BLOCKS.register(this);
        }
        ItemBlock item;
        if ((item = (ItemBlock)Item.getItemFromBlock(this)) == Items.AIR) {
            item = generateItemBlock();
            item.setRegistryName(name);
            ForgeRegistries.ITEMS.register(item);
        }
        return item;
    }

    @Override
    public Block setUnlocalizedName(String name) {
        return super.setUnlocalizedName(name);
    }

    protected ItemBlock generateItemBlock() {
        return new ItemBlock(this);
    }

}
