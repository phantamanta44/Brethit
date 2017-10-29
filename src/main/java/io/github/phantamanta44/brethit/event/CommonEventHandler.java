package io.github.phantamanta44.brethit.event;

import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.UUID;

public class CommonEventHandler {

    private final TObjectIntMap<UUID> eating = new TObjectIntHashMap<>();

    @SubscribeEvent
    public void onRegen(WorldEvent event) {
        event.getWorld().getWorldInfo().getGameRulesInstance().setOrCreateGameRule("naturalRegeneration", "false");
    }

    @SubscribeEvent
    public void onEatStart(LivingEntityUseItemEvent.Start event) {
        if (!event.getEntityLiving().world.isRemote && event.getItem().getItem() instanceof ItemFood) {
            eating.put(event.getEntityLiving().getUniqueID(), ((ItemFood)event.getItem().getItem()).getHealAmount(event.getItem()));
        }
    }

    @SubscribeEvent
    public void onEatCancel(LivingEntityUseItemEvent.Stop event) {
        if (!event.getEntityLiving().world.isRemote) {
            eating.remove(event.getEntityLiving().getUniqueID());
        }
    }

    @SubscribeEvent
    public void onEatFinish(LivingEntityUseItemEvent.Finish event) {
        if (!event.getEntityLiving().world.isRemote && eating.containsKey(event.getEntityLiving().getUniqueID())) {
            event.getEntityLiving().heal(eating.get(event.getEntityLiving().getUniqueID()));
            eating.remove(event.getEntityLiving().getUniqueID());
        }
    }

}
