package net.kyrptonaught.glassdoor;

import net.minecraft.block.*;

public class ModBlocks {
    public static BlockGlassDoor oak_glassdoor;
    public static BlockGlassDoor spruce_glassdoor;
    public static BlockGlassDoor birch_glassdoor;
    public static BlockGlassDoor acacia_glassdoor;
    public static BlockGlassDoor jungle_glassdoor;
    public static BlockGlassDoor dark_oak_glassdoor;
    public static BlockGlassDoor iron_glassdoor;

    static void register() {
        oak_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.OAK_DOOR), "oak_glassdoor");
        spruce_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.SPRUCE_DOOR), "spruce_glassdoor");
        birch_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.BIRCH_DOOR), "birch_glassdoor");
        acacia_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.ACACIA_DOOR), "acacia_glassdoor");
        jungle_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.JUNGLE_DOOR), "jungle_glassdoor");
        dark_oak_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.DARK_OAK_DOOR), "dark_oak_glassdoor");
        iron_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.IRON_DOOR), "iron_glassdoor");
        //BlockTags.WOODEN_DOORS.values().add(oak_glassdoor);
    }


    public static BlockState copyState(BlockState copyState) {
        if (copyState.getBlock() instanceof AirBlock) return copyState;
        String type = copyState.getBlock().toString();
        BlockState newState = oak_glassdoor.getDefaultState();
        if (type.contains("jungle")) newState = jungle_glassdoor.getDefaultState();
        else if (type.contains("birch")) newState = birch_glassdoor.getDefaultState();
        else if (type.contains("spruce")) newState = spruce_glassdoor.getDefaultState();
        else if (type.contains("acacia")) newState = acacia_glassdoor.getDefaultState();
        else if (type.contains("dark")) newState = dark_oak_glassdoor.getDefaultState();
        else if (type.contains("iron")) newState = iron_glassdoor.getDefaultState();
        return newState.with(DoorBlock.FACING, copyState.get(DoorBlock.FACING)).with(DoorBlock.HINGE, copyState.get(DoorBlock.HINGE)).with(DoorBlock.OPEN, copyState.get(DoorBlock.OPEN));
    }
}
