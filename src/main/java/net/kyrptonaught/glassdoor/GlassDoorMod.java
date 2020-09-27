package net.kyrptonaught.glassdoor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.client.render.RenderLayer;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystem;


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
/*
        String[] woods = {"oak", "spruce", "birch", "acacia", "jungle", "dark_oak", "iron"};

            for (String wood : woods) {
                File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\assets\\glassdoor\\models\\item\\" + wood + "_glasstrapdoor.json");
                try (FileOutputStream out = new FileOutputStream(file, false)) {
                    if (!file.exists())
                        file.createNewFile();
                    String output = "{\n" +
                            "  \"parent\": \"glassdoor:block/trapdoor/"+wood+"_glasstrapdoor_bottom\"\n" +
                            "}";
                    System.out.println(output);
                    out.write(output.getBytes());
                } catch (Exception e) {
                }
            }
        /*
        String[] woods = {"oak", "spruce", "birch", "acacia", "jungle", "dark_oak", "iron"};
        String[] types = {"bottom", "open", "top"};
        for (String type : types)
            for (String wood : woods) {
                File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\assets\\glassdoor\\models\\block\\trapdoor\\" + wood + "_glasstrapdoor_" + type + ".json");
                try (FileOutputStream out = new FileOutputStream(file, false)) {
                    if (!file.exists())
                        file.createNewFile();
                    String output = "{\n" +
                            "  \"parent\": \"glassdoor:block/template/template_trapdoor_"+type+"\",\n" +
                            "  \"textures\": {\n" +
                            "    \"texture\": \"glassdoor:block/"+wood+"_glasstrapdoor\",\n" +
                            "    \"texture2\": \"minecraft:block/"+wood+"_trapdoor\"\n" +
                            "  }\n" +
                            "}";
                    System.out.println(output);
                    out.write(output.getBytes());
                } catch (Exception e) {
                }
            }

         */
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
