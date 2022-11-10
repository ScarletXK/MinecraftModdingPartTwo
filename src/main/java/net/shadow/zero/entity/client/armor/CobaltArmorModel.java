package net.shadow.zero.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.shadow.zero.ZeroMod;
import net.shadow.zero.item.custom.CobaltArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CobaltArmorModel extends AnimatedGeoModel<CobaltArmorItem> {
    @Override
    public ResourceLocation getModelLocation(CobaltArmorItem object) {
        return new ResourceLocation(ZeroMod.MOD_ID, "geo/cobalt_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CobaltArmorItem object) {
        return new ResourceLocation(ZeroMod.MOD_ID, "textures/models/armor/cobalt_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CobaltArmorItem animatable) {
        return new ResourceLocation(ZeroMod.MOD_ID, "animations/armor_animation.json");
    }
}
