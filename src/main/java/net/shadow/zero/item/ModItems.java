package net.shadow.zero.item;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shadow.zero.ZeroMod;
import net.shadow.zero.block.ModBlocks;
import net.shadow.zero.entity.ModEntityTypes;
import net.shadow.zero.entity.custom.ModBoatEntity;
import net.shadow.zero.item.custom.DataTabletItem;
import net.shadow.zero.item.custom.ModBoatItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZeroMod.MOD_ID);

    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));


    public static final RegistryObject<Item> TURNIP_SEEDS = ITEMS.register("turnip_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TURNIP_CROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> TURNIP = ITEMS.register("turnip",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).food(ModFoods.TURNIP)));

    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));




    public static final RegistryObject<ForgeSpawnEggItem> RACCOON_SPAWN_EGG = ITEMS.register("raccoon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.RACCOON,0x948e8d, 0x3b3635,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> TIGER_SPAWN_EGG = ITEMS.register("tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TIGER,0xfcb603, 0x242321,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> CHERRY_BLOSSOM_BOAT = ITEMS.register("cherry_blossom_boat",
            () -> new ModBoatItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB), ModBoatEntity.Type.CHERRY_BLOSSOM));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}