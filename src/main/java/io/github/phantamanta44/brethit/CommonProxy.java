package io.github.phantamanta44.brethit;

import io.github.phantamanta44.brethit.constant.LangConst;
import io.github.phantamanta44.brethit.event.CommonEventHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.Field;
import java.util.BitSet;

public class CommonProxy {

    public void onPreInit() {
        // NO-OP
    }

    public void onInit() {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
    }

    public void onPostInit() {
        boolean mantleLoaded = true;
        Class<?> classItemEdible = null;
        Field fieldAlwaysEdible = null;
        try {
            classItemEdible = Class.forName("slimeknights.mantle.item.ItemEdible");
            fieldAlwaysEdible = ReflectionHelper.findField(classItemEdible, "field_77852_bZ", "alwaysEdible");
            fieldAlwaysEdible.setAccessible(true);
        } catch (Exception e) {
            BrethitMod.LOGGER.warn("Mantle food hack failed!");
            e.printStackTrace();
            mantleLoaded = false;
        }
        for (Item item : ForgeRegistries.ITEMS) {
            if (mantleLoaded && classItemEdible.isAssignableFrom(item.getClass())) {
                try {
                    BitSet alwaysEdible = (BitSet)fieldAlwaysEdible.get(item);
                    alwaysEdible.set(0, 16, true);
                } catch (Exception e) {
                    BrethitMod.LOGGER.warn("Mantle food hack failed for " + item.getRegistryName());
                    e.printStackTrace();
                }
            } else if (item instanceof ItemFood) {
                ((ItemFood)item).setAlwaysEdible();
            }
        }
    }

    public void sendToast(LangConst.LangStr msg) {
        sendToast(msg, 50);
    }

    public void sendToast(LangConst.LangStr msg, int time) {
        // NO-OP
    }

}
