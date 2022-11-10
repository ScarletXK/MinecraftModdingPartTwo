package net.shadow.zero.event;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.shadow.zero.ZeroMod;
import net.shadow.zero.entity.ModEntityTypes;
import net.shadow.zero.entity.client.armor.CobaltArmorRenderer;
import net.shadow.zero.entity.custom.RaccoonEntity;
import net.shadow.zero.entity.custom.TigerEntity;
import net.shadow.zero.item.custom.CobaltArmorItem;
import org.apache.http.config.Registry;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = ZeroMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    /*
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new TurnipSeedsFromGrassAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(MCCourseMod.MOD_ID,"turnip_seeds_from_grass")),
                new DowsingRodInIglooAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(MCCourseMod.MOD_ID,"dowsing_rod_in_igloo"))
        );
    }

     */

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RACCOON.get(), RaccoonEntity.setAttributes());
        event.put(ModEntityTypes.TIGER.get(), TigerEntity.setAttributes());

    }
    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {

    }

    @SubscribeEvent
    public static void registerRecipeTypes(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(CobaltArmorItem.class, new CobaltArmorRenderer());
    }


}