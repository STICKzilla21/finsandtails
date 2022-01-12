package teamdraco.finsandstails.common.entities;

import coda.dracoshoard.common.entities.ai.FancySwimmingMoveHelperController;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.HitResult;
import software.bernie.finsandtails.geckolib3.core.IAnimatable;
import software.bernie.finsandtails.geckolib3.core.IAnimationTickable;
import software.bernie.finsandtails.geckolib3.core.PlayState;
import software.bernie.finsandtails.geckolib3.core.controller.AnimationController;
import software.bernie.finsandtails.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.finsandtails.geckolib3.core.manager.AnimationData;
import software.bernie.finsandtails.geckolib3.core.manager.AnimationFactory;
import teamdraco.finsandstails.registry.FTItems;

public class BandedRedbackShrimpEntity extends AbstractSchoolingFish implements IAnimatable, IAnimationTickable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public BandedRedbackShrimpEntity(EntityType<? extends BandedRedbackShrimpEntity> type, Level world) {
        super(type, world);
        this.moveControl = new FancySwimmingMoveHelperController(this);
        this.lookControl = new SmoothSwimmingLookControl(this, 30);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new AvoidEntityGoal<>(this, OrnateBugfishEntity.class, 6.0F, 1.5D, 2.0D));
        this.goalSelector.addGoal(0, new AvoidEntityGoal<>(this, RubberBellyGliderEntity.class, 6.0F, 1.5D, 2.0D));
    }

    @Override
    public int getMaxSchoolSize() {
        return 3;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(FTItems.BANDED_REDBACK_SHRIMP_BUCKET.get());
    }

    public SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    public SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    public SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.COD_HURT;
    }

    public SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        return new ItemStack(FTItems.BANDED_REDBACK_SHRIMP_SPAWN_EGG.get());
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 5, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        return PlayState.STOP;
    }

    @Override
    public int tickTimer() {
        return tickCount;
    }
}