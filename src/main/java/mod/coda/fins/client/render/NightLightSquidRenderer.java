package mod.coda.fins.client.render;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import mod.coda.fins.FinsAndTails;
import mod.coda.fins.client.model.BluWeeModel;
import mod.coda.fins.client.model.NightLightSquidModel;
import mod.coda.fins.entity.BluWeeEntity;
import mod.coda.fins.entity.NightLightSquidEntity;
import mod.coda.fins.entity.PenglilEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

import java.util.Map;

public class NightLightSquidRenderer extends MobRenderer<NightLightSquidEntity, NightLightSquidModel<NightLightSquidEntity>> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/night_light_squid/night_light_squid_1.png"));
        hashMap.put(1, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/night_light_squid/night_light_squid_2.png"));
        hashMap.put(2, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/night_light_squid/night_light_squid_3.png"));
        hashMap.put(3, new ResourceLocation(FinsAndTails.MOD_ID, "textures/entity/night_light_squid/night_light_squid_4.png"));
    });
    public NightLightSquidRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NightLightSquidModel<>(), 0.2F);
        this.addLayer(new NightLightSquidGlowLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(NightLightSquidEntity entity) {
        return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
    }

    @Override
    protected void applyRotations(NightLightSquidEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
    }
}