package net.shadow.zero.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.shadow.zero.ZeroMod;
import net.shadow.zero.entity.custom.TigerEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TigerModel extends AnimatedGeoModel<TigerEntity> {
    @Override
    public ResourceLocation getModelLocation(TigerEntity entity){
        return new ResourceLocation(ZeroMod.MOD_ID, "geo/tiger.geo.json");
    }
    @Override
    public ResourceLocation getTextureLocation(TigerEntity entity){
        return new ResourceLocation(ZeroMod.MOD_ID, "textures/entity/tiger/tiger.png");
    }
    @Override
    public ResourceLocation getAnimationFileLocation(TigerEntity entity){
        return new ResourceLocation(ZeroMod.MOD_ID, "animations/tiger.animation.json");
    }
}
