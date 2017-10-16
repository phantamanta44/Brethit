package io.github.phantamanta44.brethit.client;

import io.github.phantamanta44.brethit.BrethitMod;
import io.github.phantamanta44.brethit.CommonProxy;
import io.github.phantamanta44.brethit.client.event.ClientEventHandler;
import io.github.phantamanta44.brethit.constant.LangConst;
import io.github.phantamanta44.brethit.util.GuiToastWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.ObjIntConsumer;

public class ClientProxy extends CommonProxy {

    private ObjIntConsumer<LangConst.LangStr> funcSendToast;

    @Override
    public void onPreInit() {
        super.onPreInit();
        Minecraft mc = Minecraft.getMinecraft();
        try {
            Field fieldToasts = ReflectionHelper.findField(Minecraft.class, "field_193034_aS", "toastGui");
            Field fieldMods = Field.class.getDeclaredField("modifiers");
            fieldMods.setAccessible(true);
            fieldMods.set(fieldToasts, fieldToasts.getModifiers() & ~Modifier.FINAL);
            fieldToasts.setAccessible(true);
            fieldToasts.set(mc, new GuiToastWrapper(mc));
        } catch (Exception e) {
            BrethitMod.LOGGER.error("Failed to do toastGui hack!");
            e.printStackTrace();
        }
    }

    @Override
    public void onInit() {
        super.onInit();
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        try {
            Method sendToast = Class.forName("vazkii.chatflow.handler.ToastHandler")
                    .getDeclaredMethod("setTooltip", String.class, Integer.TYPE);
            funcSendToast = (msg, time) -> {
                try {
                    sendToast.invoke(null, msg.raw(), time);
                } catch (InvocationTargetException e) {
                    BrethitMod.LOGGER.warn("ChatFlow integration failed!");
                    e.getCause().printStackTrace();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            BrethitMod.LOGGER.warn("ChatFlow not found! Falling back to chat-based notifications.");
            Minecraft mc = Minecraft.getMinecraft();
            funcSendToast = (msg, time) -> mc.player.sendMessage(new TextComponentString(msg.get()));
        }
    }

    @Override
    public void sendToast(LangConst.LangStr msg, int time) {
        funcSendToast.accept(msg, time);
    }

}
