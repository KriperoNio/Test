package com.kriperonio.testmod.block.customs;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TestBlockEffects extends Block {
    public TestBlockEffects(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player,
                                 InteractionHand hand, BlockHitResult hitResult) {

        if(!level.isClientSide) {
            if(hand == InteractionHand.MAIN_HAND) {
                player.sendSystemMessage(Component.literal("main hand"));
                player.sendSystemMessage(Component.literal( "/" + player.getX() + "/" +
                        player.getY() + "/" + player.getZ()));
                player.setXRot(player.getXRot() + 30);
                player.setYRot(player.getYRot() + 180);
            } else if(hand == InteractionHand.OFF_HAND) {
                player.sendSystemMessage(Component.literal("off hand"));
            }
        }

        return super.use(blockState, level, blockPos, player, hand, hitResult);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {

        onStepBlock(level, entity);

        super.stepOn(level, blockPos, blockState, entity);
    }

    private void onStepBlock(Level level, Entity entity){
        if(!level.isClientSide) {
            if(entity instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 25, 255));
            }
        }
    }
}
