package net.shadow.zero.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.shadow.zero.ZeroMod;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, ZeroMod.MOD_ID);




  public static void  register(IEventBus eventBus){
      ENTITY_TYPES.register(eventBus);
  }
}
