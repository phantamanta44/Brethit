package io.github.phantamanta44.brethit.event;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonEventHandler {

    @SubscribeEvent
    public void onRegen(WorldEvent event) {
        event.getWorld().getWorldInfo().getGameRulesInstance().setOrCreateGameRule("naturalRegeneration", "false");
    }

}
