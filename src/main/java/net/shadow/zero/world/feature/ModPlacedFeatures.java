package net.shadow.zero.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> COBALT_GEODE_PLACED = PlacementUtils.register("cobalt_geode_placed",
            ModConfiguredFeature.COBALT_GEODE,
            RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
            BiomeFilter.biome());
}
