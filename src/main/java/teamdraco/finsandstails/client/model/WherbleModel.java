package teamdraco.finsandstails.client.model;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import software.bernie.finsandtails.geckolib3.model.AnimatedGeoModel;
import teamdraco.finsandstails.FinsAndTails;
import teamdraco.finsandstails.common.entities.WherbleEntity;

import java.util.Map;

public class WherbleModel extends AnimatedGeoModel<WherbleEntity> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/wherble/wherble_1.png"));
        hashMap.put(1, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/wherble/wherble_2.png"));
        hashMap.put(2, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/wherble/wherble_3.png"));
        hashMap.put(3, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/wherble/wherble_4.png"));
        hashMap.put(4, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/wherble/child.png"));
    });

    @Override
    public ResourceLocation getModelLocation(WherbleEntity wee) {
        return new ResourceLocation(FinsAndTails.MOD_ID, "geo/entity/wherble.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(WherbleEntity wee) {
        return wee.isBaby() ? TEXTURES.get(4) : TEXTURES.getOrDefault(wee.getVariant(), TEXTURES.get(0));
    }

    @Override
    public ResourceLocation getAnimationFileLocation(WherbleEntity wee) {
        return null;
        //return new ResourceLocation(FinsAndTails.MOD_ID, "animations/entity/wherble.animation.json");
    }
}