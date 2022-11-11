package net.shadow.zero.block.entity;


import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shadow.zero.ZeroMod;
import net.shadow.zero.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ZeroMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CobaltBlasterBlockEntity>> COBALT_BLASTER =
            BLOCK_ENTITIES.register("cobalt_blaster", () ->
                    BlockEntityType.Builder.of(CobaltBlasterBlockEntity::new,
                            ModBlocks.COBALT_BLASTER.get()).build(null));
/*
    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.CHERRY_BLOSSOM_WALL_SIGN.get(),
                            ModBlocks.CHERRY_BLOSSOM_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<PedestalBlockEntity>> PEDESTAL =
            BLOCK_ENTITIES.register("pedestal", () ->
                    BlockEntityType.Builder.of(PedestalBlockEntity::new,
                            ModBlocks.PEDESTAL.get()).build(null));


 */
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
