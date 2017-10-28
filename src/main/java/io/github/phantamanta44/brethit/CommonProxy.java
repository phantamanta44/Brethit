package io.github.phantamanta44.brethit;

import io.github.phantamanta44.brethit.constant.LangConst;
import io.github.phantamanta44.brethit.event.CommonEventHandler;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CommonProxy {

    public void onPreInit() {
        // NO-OP
    }

    public void onInit() {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        ForgeRegistries.ITEMS.forEach(i -> {
            if (i instanceof ItemFood) {
                ((ItemFood)i).setAlwaysEdible();
            }
        });
    }

    public void onPostInit() {
        // NO-OP
    }

    public void sendToast(LangConst.LangStr msg) {
        sendToast(msg, 50);
    }

    public void sendToast(LangConst.LangStr msg, int time) {
        // NO-OP
    }

}
