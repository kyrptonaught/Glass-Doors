package net.kyrptonaught.glassdoor;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;


public class GlassDoorMod implements ModInitializer {
    static final String MOD_ID = "glassdoor";

    public static BlockGlassDoor oak_glassdoor;
    public static BlockGlassDoor spruce_glassdoor;
    public static BlockGlassDoor birch_glassdoor;
    public static BlockGlassDoor acacia_glassdoor;
    public static BlockGlassDoor jungle_glassdoor;
    public static BlockGlassDoor dark_oak_glassdoor;
    public static BlockGlassDoor iron_glassdoor;

    @Override
    public void onInitialize() {
        oak_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.OAK_DOOR), "oak_glassdoor");
        spruce_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.SPRUCE_DOOR), "spruce_glassdoor");
        birch_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.BIRCH_DOOR), "birch_glassdoor");
        acacia_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.ACACIA_DOOR), "acacia_glassdoor");
        jungle_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.JUNGLE_DOOR), "jungle_glassdoor");
        dark_oak_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.DARK_OAK_DOOR), "dark_oak_glassdoor");
        iron_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.IRON_DOOR), "iron_glassdoor");
    }

    public static BlockState copyState(BlockState copyState) {
        if (!(copyState.getBlock() instanceof DoorBlock)) return copyState;

        BlockState newState = oak_glassdoor.getDefaultState();
        if (copyState.getBlock().equals(Blocks.JUNGLE_DOOR)) newState = jungle_glassdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.BIRCH_DOOR)) newState = birch_glassdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.SPRUCE_DOOR)) newState = spruce_glassdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.ACACIA_DOOR)) newState = acacia_glassdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.DARK_OAK_DOOR)) newState = dark_oak_glassdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.IRON_DOOR)) newState = iron_glassdoor.getDefaultState();
        return newState.with(DoorBlock.FACING, copyState.get(DoorBlock.FACING)).with(DoorBlock.HINGE, copyState.get(DoorBlock.HINGE)).with(DoorBlock.OPEN, copyState.get(DoorBlock.OPEN));
    }
}
