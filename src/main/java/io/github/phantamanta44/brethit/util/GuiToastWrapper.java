package io.github.phantamanta44.brethit.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.client.gui.toasts.RecipeToast;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class GuiToastWrapper extends GuiToast {

    private static final RecipeToastNoOp NO_OP_RECIPE = new RecipeToastNoOp();

    public GuiToastWrapper(Minecraft mc) {
        super(mc);
    }

    @Nullable
    @Override
    @ParametersAreNonnullByDefault
    @SuppressWarnings("unchecked")
    public <T extends IToast> T getToast(Class<? extends T> clazz, Object type) {
        return clazz == RecipeToast.class ? (T)NO_OP_RECIPE : super.getToast(clazz, type);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void add(IToast toast) {
        super.add(toast);
    }

    private static class RecipeToastNoOp extends RecipeToast {

        public RecipeToastNoOp() {
            super(new ItemStack(Blocks.STONE));
        }

        @Override
        public void addRecipeOutput(ItemStack output) {
            // NO-OP
        }

        @Override
        public Visibility draw(GuiToast toastGui, long delta) {
            return Visibility.HIDE;
        }

    }

}
