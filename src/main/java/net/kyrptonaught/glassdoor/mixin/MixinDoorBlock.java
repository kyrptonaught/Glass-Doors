package net.kyrptonaught.glassdoor.mixin;

import net.kyrptonaught.glassdoor.BlockGlassDoor;
import net.kyrptonaught.glassdoor.GlassDoorMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(DoorBlock.class)
public abstract class MixinDoorBlock {

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void glassdoor$activate(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> callbackInfoReturnable) {
        ItemStack heldStack = player.getInventory().getMainHandStack();
        if (!(state.getBlock() instanceof BlockGlassDoor) && heldStack.getItem() == Items.GLASS_PANE) {
            if (state.get(DoorBlock.HALF) == DoubleBlockHalf.UPPER) pos = pos.down();

            BlockState glassDoorState = GlassDoorMod.copyState(state);

            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            world.setBlockState(pos.up(), Blocks.AIR.getDefaultState());

            world.setBlockState(pos, glassDoorState.with(DoorBlock.HALF, DoubleBlockHalf.LOWER));
            world.setBlockState(pos.up(), glassDoorState.with(DoorBlock.HALF, DoubleBlockHalf.UPPER));

            if (!player.isCreative()) heldStack.decrement(1);
            callbackInfoReturnable.setReturnValue(ActionResult.SUCCESS);

        }
    }
}