package io.github.phantamanta44.brethit;

import io.github.phantamanta44.brethit.constant.ModConst;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModConst.MOD_ID, version = ModConst.VERSION)
public class BrethitMod {

    public static final Logger LOGGER = LogManager.getLogger(ModConst.MOD_ID);

    @Mod.Instance(ModConst.MOD_ID)
    public static BrethitMod INSTANCE;

    @SidedProxy(
            serverSide = "io.github.phantamanta44.brethit.CommonProxy",
            clientSide = "io.github.phantamanta44.brethit.client.ClientProxy")
    public static CommonProxy PROXY;

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        PROXY.onPreInit();
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        PROXY.onInit();
    }

    @EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        PROXY.onPostInit();
    }

}
