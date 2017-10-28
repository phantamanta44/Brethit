package io.github.phantamanta44.brethit.event;

import net.minecraft.item.ItemFood;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonEventHandler {

    @SubscribeEvent
    public void onRegen(WorldEvent event) {
        event.getWorld().getWorldInfo().getGameRulesInstance().setOrCreateGameRule("naturalRegeneration", "false");
    }

    @SubscribeEvent
    public void onEat(LivingEntityUseItemEvent.Finish event) {
        if (event.getItem().getItem() instanceof ItemFood) {
            event.getEntityLiving().heal(((ItemFood)event.getItem().getItem()).getHealAmount(event.getItem()));
        }
    }

}
