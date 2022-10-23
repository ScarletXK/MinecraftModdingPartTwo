package net.shadow.zero.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.shadow.zero.ZeroMod;
import net.shadow.zero.entity.custom.RaccoonEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RaccoonModel extends AnimatedGeoModel <RaccoonEntity> {
    @Override
    public ResourceLocation getModelLocation(RaccoonEntity object) {
        return new ResourceLocation(ZeroMod.MOD_ID, "geo/raccoon.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RaccoonEntity object) {
        return new ResourceLocation(ZeroMod.MOD_ID,"textures/entity/raccoon/raccoon.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RaccoonEntity animatable) {
        return new ResourceLocation(ZeroMod.MOD_ID,"animations/raccoon.animation.json");
    }
}
