package net.shadow.zero.event;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.shadow.zero.ZeroMod;
import net.shadow.zero.entity.ModEntityTypes;
import net.shadow.zero.entity.custom.RaccoonEntity;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = ZeroMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ModEntityTypes.RACCOON.get(), RaccoonEntity.setAttributes());
    }

}
