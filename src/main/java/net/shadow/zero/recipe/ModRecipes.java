package net.shadow.zero.recipe;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shadow.zero.ZeroMod;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ZeroMod.MOD_ID);

    /*
    public static final RegistryObject<RecipeSerializer<CobaltBlasterRecipe>> COBALT_BLASTER_SERIALIZER =
            SERIALIZERS.register("cobalt_blasting", () -> CobaltBlasterRecipe.Serializer.INSTANCE);


     */
    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}