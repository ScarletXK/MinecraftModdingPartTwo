package net.shadow.zero;

import com.mojang.logging.LogUtils;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.shadow.zero.block.ModBlocks;
import net.shadow.zero.block.entity.ModBlockEntities;
import net.shadow.zero.entity.ModEntityTypes;
import net.shadow.zero.entity.client.ModBoatRenderer;
import net.shadow.zero.entity.client.RaccoonRenderer;
import net.shadow.zero.entity.client.TigerRenderer;
import net.shadow.zero.entity.custom.ModBoatEntity;
import net.shadow.zero.item.ModItems;
import net.shadow.zero.recipe.ModRecipes;
import net.shadow.zero.screen.ModMenuTypes;
import net.shadow.zero.sound.ModSounds;
import net.shadow.zero.villager.ModVillagers;
import net.shadow.zero.world.structure.ModStructures;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ZeroMod.MOD_ID)
public class ZeroMod {
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "zero";

    public ZeroMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModSounds.register(eventBus);
        GeckoLib.initialize();
        ModStructures.register(eventBus);
        ModVillagers.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);

        ModRecipes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TURNIP_CROP.get(), RenderType.cutout());


        EntityRenderers.register(ModEntityTypes.RACCOON.get(), RaccoonRenderer::new);
        EntityRenderers.register(ModEntityTypes.TIGER.get(), TigerRenderer::new);
        EntityRenderers.register(ModEntityTypes.BOAT_ENTITY.get(), ModBoatRenderer::new);



    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //ComposterBlock.COMPOSTABLES.put(ModItems.TURNIP_SEEDS.get(), 0.3f);

            ModVillagers.registerPOIs();



        });
    }
}