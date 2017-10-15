package io.github.phantamanta44.brethit;

import io.github.phantamanta44.brethit.constant.LangConst;

public class CommonProxy {

    public void onPreInit() {
        // NO-OP
    }

    public void onInit() {
        // NO-OP
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
