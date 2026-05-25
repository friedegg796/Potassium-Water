package awanderingmuslim.potassiumwater.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class PotassiumWaterProjectile extends ThrowableItemProjectile {
    public PotassiumWaterProjectile(EntityType<? extends PotassiumWaterProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public PotassiumWaterProjectile(Level level, LivingEntity livingEntity, ItemStack itemStack) {
        super(EntityType.SNOWBALL, livingEntity, level, itemStack);
    }

    public PotassiumWaterProjectile(Level level, double d, double e, double f, ItemStack itemStack) {
        super(EntityType.SNOWBALL, d, e, f, level, itemStack);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.SNOWBALL;
    }


    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            level().explode(null,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    3.5f,
                    Level.ExplosionInteraction.BLOCK);
            this.discard();
        }
    }
}