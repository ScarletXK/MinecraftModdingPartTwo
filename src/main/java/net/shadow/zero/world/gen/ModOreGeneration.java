package net.shadow.zero.world.gen;

import com.electronwill.nightconfig.core.AbstractConfig;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.shadow.zero.world.feature.ModPlacedFeatures;

import java.util.List;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event){
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);


        base.add(ModPlacedFeatures.COBALT_GEODE_PLACED);
    }
}
