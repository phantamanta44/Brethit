package io.github.phantamanta44.brethit.client.event;

import io.github.phantamanta44.brethit.item.base.ItemUtility;
import net.minecraft.client.gui.recipebook.IRecipeShownListener;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientEventHandler {

    @SubscribeEvent
    public void onDrawGui(GuiScreenEvent.InitGuiEvent event) {
        if (event.getGui() instanceof IRecipeShownListener) {
            event.getButtonList().removeIf(b -> b.id == 10);
        }
    }

    @SubscribeEvent
    public void handleBreakSpeed(PlayerEvent.BreakSpeed event) {
        if ((event.getEntityPlayer().inventory.getCurrentItem().isEmpty()
                || !(event.getEntityPlayer().inventory.getCurrentItem().getItem() instanceof ItemUtility))
                && event.getState().getBlockHardness(event.getEntityPlayer().getEntityWorld(), event.getPos()) > 0) {
            event.setNewSpeed(0);
        }
    }

}
