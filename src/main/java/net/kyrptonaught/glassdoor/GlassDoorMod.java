package net.kyrptonaught.glassdoor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;


public class GlassDoorMod implements ModInitializer, ClientModInitializer {
    static final String MOD_ID = "glassdoor";

    public static BlockGlassDoor oak_glassdoor;
    public static BlockGlassDoor spruce_glassdoor;
    public static BlockGlassDoor birch_glassdoor;
    public static BlockGlassDoor acacia_glassdoor;
    public static BlockGlassDoor jungle_glassdoor;
    public static BlockGlassDoor dark_oak_glassdoor;
    public static BlockGlassDoor iron_glassdoor;

    public static BlockGlassTrapDoor oak_glasstrapdoor;
    public static BlockGlassTrapDoor spruce_glasstrapdoor;
    public static BlockGlassTrapDoor birch_glasstrapdoor;
    public static BlockGlassTrapDoor acacia_glasstrapdoor;
    public static BlockGlassTrapDoor jungle_glasstrapdoor;
    public static BlockGlassTrapDoor dark_oak_glasstrapdoor;
    public static BlockGlassTrapDoor iron_glasstrapdoor;

    @Override
    public void onInitialize() {
        oak_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.OAK_DOOR), "oak_glassdoor");
        spruce_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.SPRUCE_DOOR), "spruce_glassdoor");
        birch_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.BIRCH_DOOR), "birch_glassdoor");
        acacia_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.ACACIA_DOOR), "acacia_glassdoor");
        jungle_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.JUNGLE_DOOR), "jungle_glassdoor");
        dark_oak_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.DARK_OAK_DOOR), "dark_oak_glassdoor");
        iron_glassdoor = new BlockGlassDoor(Block.Settings.copy(Blocks.IRON_DOOR), "iron_glassdoor");

        oak_glasstrapdoor = new BlockGlassTrapDoor(Block.Settings.copy(Blocks.OAK_TRAPDOOR), "oak_glasstrapdoor");
        spruce_glasstrapdoor = new BlockGlassTrapDoor(Block.Settings.copy(Blocks.SPRUCE_TRAPDOOR), "spruce_glasstrapdoor");
        birch_glasstrapdoor = new BlockGlassTrapDoor(Block.Settings.copy(Blocks.BIRCH_TRAPDOOR), "birch_glasstrapdoor");
        acacia_glasstrapdoor = new BlockGlassTrapDoor(Block.Settings.copy(Blocks.ACACIA_TRAPDOOR), "acacia_glasstrapdoor");
        jungle_glasstrapdoor = new BlockGlassTrapDoor(Block.Settings.copy(Blocks.JUNGLE_TRAPDOOR), "jungle_glasstrapdoor");
        dark_oak_glasstrapdoor = new BlockGlassTrapDoor(Block.Settings.copy(Blocks.DARK_OAK_TRAPDOOR), "dark_oak_glasstrapdoor");
        iron_glasstrapdoor = new BlockGlassTrapDoor(Block.Settings.copy(Blocks.IRON_TRAPDOOR), "iron_glasstrapdoor");
    }
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(oak_glassdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(spruce_glassdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(birch_glassdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(acacia_glassdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(jungle_glassdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(dark_oak_glassdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(iron_glassdoor, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(oak_glasstrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(spruce_glasstrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(birch_glasstrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(acacia_glasstrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(jungle_glasstrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(dark_oak_glasstrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(iron_glasstrapdoor, RenderLayer.getCutout());

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
    public static BlockState copytrapdoorState(BlockState copyState) {
        if (!(copyState.getBlock() instanceof TrapdoorBlock)) return copyState;

        BlockState newState = oak_glasstrapdoor.getDefaultState();
        if (copyState.getBlock().equals(Blocks.JUNGLE_TRAPDOOR)) newState = jungle_glasstrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.BIRCH_TRAPDOOR)) newState = birch_glasstrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.SPRUCE_TRAPDOOR)) newState = spruce_glasstrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.ACACIA_TRAPDOOR)) newState = acacia_glasstrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.DARK_OAK_TRAPDOOR)) newState = dark_oak_glasstrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.IRON_TRAPDOOR)) newState = iron_glasstrapdoor.getDefaultState();
        return newState.with(TrapdoorBlock.FACING, copyState.get(TrapdoorBlock.FACING)).with(TrapdoorBlock.OPEN, copyState.get(TrapdoorBlock.OPEN)).with(TrapdoorBlock.HALF, copyState.get(TrapdoorBlock.HALF)).with(TrapdoorBlock.POWERED, copyState.get(TrapdoorBlock.POWERED)).with(TrapdoorBlock.WATERLOGGED, copyState.get(TrapdoorBlock.WATERLOGGED));
    }
}
