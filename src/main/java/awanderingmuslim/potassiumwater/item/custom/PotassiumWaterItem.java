package awanderingmuslim.potassiumwater.item.custom;

import awanderingmuslim.potassiumwater.entity.custom.PotassiumWaterProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.throwableitemprojectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class PotassiumWaterItem extends Item
        implements ProjectileItem {
    public static float PROJECTILE_SHOOT_POWER = 3.5f;
    private final float explosionPower = 20.0f;

    public PotassiumWaterItem(Properties properties) {
        super(properties);

    }

    @Override
    public InteractionResult use(Level level, Player user, InteractionHand hand) {


        ItemStack itemStack = user.getItemInHand(hand);

        level.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5f, 0.4f / (level.getRandom().nextFloat() * 0.4f + 0.8f));

        if (level instanceof ServerLevel serverLevel) {
            Projectile.spawnProjectileFromRotation(PotassiumWaterProjectile::new, serverLevel, itemStack, user, 0.0f, PROJECTILE_SHOOT_POWER, 1.0f);


        }

        user.awardStat(Stats.ITEM_USED.get(this));
        itemStack.consume(1, user);
        return InteractionResult.SUCCESS;
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        return new PotassiumWaterProjectile(level, position.x(), position.y(), position.z(), itemStack);

    }
}
