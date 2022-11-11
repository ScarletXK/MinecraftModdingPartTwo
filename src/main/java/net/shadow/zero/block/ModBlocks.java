package net.shadow.zero.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shadow.zero.ZeroMod;
import net.shadow.zero.block.custom.CobaltBlasterBlock;
import net.shadow.zero.block.custom.ModFlammableRotatedPillarBlock;
import net.shadow.zero.block.custom.PedestalBlock;
import net.shadow.zero.block.custom.TurnipCropBlock;
import net.shadow.zero.item.ModCreativeModeTab;
import net.shadow.zero.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ZeroMod.MOD_ID);


    public static final RegistryObject<Block> TURNIP_CROP = BLOCKS.register("turnip_crop",
            ()-> new TurnipCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS).noCollission().noOcclusion()));

    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> PEDESTAL = registerBlock("pedestal",
            () -> new PedestalBlock(BlockBehaviour.Properties.of(Material.STONE)), ModCreativeModeTab.COURSE_TAB);


    public static final RegistryObject<Block> COBALT_BLASTER = registerBlock("cobalt_blaster",
            () -> new CobaltBlasterBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion()),
            ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_LOG = registerBlock("cherry_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> CHERRY_BLOSSOM_WOOD = registerBlock("cherry_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_CHERRY_BLOSSOM_LOG = registerBlock("stripped_cherry_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.COURSE_TAB);
    public static final RegistryObject<Block> STRIPPED_CHERRY_BLOSSOM_WOOD = registerBlock("stripped_cherry_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.COURSE_TAB);


    public static final RegistryObject<Block> CHERRY_BLOSSOM_PLANKS = registerBlock("cherry_blossom_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.COURSE_TAB);




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
