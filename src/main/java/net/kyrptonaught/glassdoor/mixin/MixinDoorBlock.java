package net.kyrptonaught.glassdoor.mixin;

import net.kyrptonaught.glassdoor.BlockGlassDoor;
import net.kyrptonaught.glassdoor.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DoorBlock.class)
public abstract class MixinDoorBlock extends Block {
    public MixinDoorBlock(Settings block$Settings_1) {
        super(block$Settings_1);
    }

    @Inject(method = "activate", at = @At("HEAD"), cancellable = true)
    public void glassdoor$activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        ItemStack hand = playerEntity_1.inventory.getMainHandStack();
        if (!(blockState_1.getBlock() instanceof BlockGlassDoor) && hand.getItem() == Items.GLASS_PANE) {
            if (blockState_1.get(DoorBlock.HALF) == DoubleBlockHalf.UPPER) blockPos_1 = blockPos_1.down();
            BlockState lowerState = ModBlocks.copyState(blockState_1);
            BlockState upperState = ModBlocks.copyState(world_1.getBlockState(blockPos_1.up()));
            world_1.setBlockState(blockPos_1, Blocks.AIR.getDefaultState());
            world_1.setBlockState(blockPos_1.up(), Blocks.AIR.getDefaultState());
            world_1.setBlockState(blockPos_1, ModBlocks.copyState(lowerState).with(DoorBlock.HALF, DoubleBlockHalf.LOWER));
            world_1.setBlockState(blockPos_1.up(), ModBlocks.copyState(upperState).with(DoorBlock.HALF, DoubleBlockHalf.UPPER));
            if (!playerEntity_1.isCreative()) hand.increment(-1);
            callbackInfoReturnable.setReturnValue(true);
        }
    }
}