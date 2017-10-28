package io.github.phantamanta44.brethit;

import io.github.phantamanta44.brethit.constant.LangConst;
import io.github.phantamanta44.brethit.event.CommonEventHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

    public void onPreInit() {
        // NO-OP
    }

    public void onInit() {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
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
