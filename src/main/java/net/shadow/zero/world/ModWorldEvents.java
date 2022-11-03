package net.shadow.zero.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.shadow.zero.ZeroMod;
import net.shadow.zero.world.gen.ModEntityGeneration;

@Mod.EventBusSubscriber(modid = ZeroMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        ModEntityGeneration.onEntitySpawn(event);
    }
}