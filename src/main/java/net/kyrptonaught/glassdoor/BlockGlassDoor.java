package net.kyrptonaught.glassdoor;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.TallBlockItem;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;


public class BlockGlassDoor extends DoorBlock {

    BlockGlassDoor(Settings block$Settings_1, String name) {
        super(block$Settings_1);
        Registry.register(Registry.BLOCK, new Identifier(GlassDoorMod.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(GlassDoorMod.MOD_ID, name), new TallBlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));
    }

    @Override
    public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
        super.activate(blockState_1, world_1, blockPos_1, playerEntity_1, hand_1, blockHitResult_1);
        BlockTags.WOODEN_DOORS.values().forEach(block -> System.out.println(block.toString()));
        return true;
    }
}
