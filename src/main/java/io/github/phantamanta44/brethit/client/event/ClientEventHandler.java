package io.github.phantamanta44.brethit.client.event;

import io.github.phantamanta44.brethit.BrethitMod;
import net.minecraft.client.gui.recipebook.GuiRecipeBook;
import net.minecraft.client.gui.recipebook.IRecipeShownListener;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClientEventHandler {

    private Method methodRecipeBookGuiSetVisible;

    public ClientEventHandler() {
        try {
            methodRecipeBookGuiSetVisible = ReflectionHelper.findMethod(
                    GuiRecipeBook.class, "setVisible", "func_193006_a", Boolean.TYPE);
            methodRecipeBookGuiSetVisible.setAccessible(true);
        } catch (Exception e) {
            BrethitMod.LOGGER.error("Failed to do recipe book hack!");
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onDrawGui(GuiScreenEvent.InitGuiEvent event) {
        if (event.getGui() instanceof IRecipeShownListener) {
            event.getButtonList().removeIf(b -> b.id == 10);
            try {
                methodRecipeBookGuiSetVisible.invoke(((IRecipeShownListener)event.getGui()).func_194310_f(), false);
            } catch (InvocationTargetException e) {
                BrethitMod.LOGGER.warn("Recipe book hiding failed!");
                e.getCause().printStackTrace();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
