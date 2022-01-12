package teamdraco.finsandstails.client.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.finsandtails.geckolib3.model.AnimatedGeoModel;
import teamdraco.finsandstails.FinsAndTails;
import teamdraco.finsandstails.common.entities.HighFinnedBlueEntity;

public class HighFinnedBlueModel extends AnimatedGeoModel<HighFinnedBlueEntity> {

    @Override
    public ResourceLocation getModelLocation(HighFinnedBlueEntity entity) {
        return new ResourceLocation(FinsAndTails.MOD_ID, "geo/entity/high_finned_blue.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(HighFinnedBlueEntity entity) {
        return new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/high_finned_blue.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(HighFinnedBlueEntity entity) {
        return null;
        //return new ResourceLocation(FinsAndTails.MOD_ID, "animations/entity/high_finned_blue.animation.json");
    }
}
