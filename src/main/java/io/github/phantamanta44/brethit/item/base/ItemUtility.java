package io.github.phantamanta44.brethit.item.base;

import com.google.common.collect.Multimap;
import io.github.phantamanta44.brethit.constant.ModConst;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

import java.util.UUID;
import java.util.function.BiConsumer;

public abstract class ItemUtility extends ItemMod {

    public static final UUID MOD_ATK_DMG = Item.ATTACK_DAMAGE_MODIFIER;
    public static final UUID MOD_ATK_SPD = Item.ATTACK_SPEED_MODIFIER;

    protected final UtilityClass uClass;
    protected final UtilityArchetype arch;

    private ModelResourceLocation modelEq, modelUneq;

    public ItemUtility(String name, UtilityClass uClass, UtilityArchetype arch) {
        super(name);
        this.uClass = uClass;
        this.arch = arch;
        setMaxStackSize(1);
        setMaxDamage(arch.getDamage(uClass));
        if (arch.eqTex) {
            ModelLoader.registerItemVariants(this,
                    modelEq = new ModelResourceLocation(ModConst.MOD_PREF + name + "_on", "equipped"),
                    modelUneq = new ModelResourceLocation(ModConst.MOD_PREF + name + "_off", "unequipped"));
            ModelLoader.setCustomMeshDefinition(this, stack -> {
                InventoryPlayer inv = Minecraft.getMinecraft().player.inventory;
                return inv.offHandInventory.contains(stack) || !inv.mainInventory.contains(stack) || inv.getCurrentItem() == stack
                        ? modelEq : modelUneq;
            });
        }
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        return arch.getBreakSpeed(uClass, stack, state);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState block, BlockPos pos, EntityLivingBase user) {
        if (block.getBlockHardness(world, pos) > 0) {
            stack.damageItem(1, user);
        }
        return true;
    }

    @Override
    public boolean canHarvestBlock(IBlockState block) {
        return uClass.canHarvest(block);
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    @SuppressWarnings("deprecation")
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
