package net.kyrptonaught.glassdoor;

import com.swordglowsblue.artifice.api.Artifice;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.resource.TemplateResource;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.server.command.CommandSource;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Collectors;

class ArtificeHelper {
    static void generateRecipies() {
        String[] woodtype = {"oak", "spruce", "birch", "acacia", "jungle", "dark_oak", "iron"};
        Artifice.registerData("", pack -> {
            registerRecipe(pack, "glassoak", ModBlocks.oak_glassdoor, Blocks.OAK_DOOR);
            registerRecipe(pack, "glassspruce", ModBlocks.spruce_glassdoor, Blocks.SPRUCE_DOOR);
            registerRecipe(pack, "glassacacia", ModBlocks.acacia_glassdoor, Blocks.ACACIA_DOOR);
            registerRecipe(pack, "glassbirch", ModBlocks.birch_glassdoor, Blocks.BIRCH_DOOR);
            registerRecipe(pack, "glassjungle", ModBlocks.jungle_glassdoor, Blocks.JUNGLE_DOOR);
            registerRecipe(pack, "glassdarkoak", ModBlocks.dark_oak_glassdoor, Blocks.DARK_OAK_DOOR);
            registerRecipe(pack, "glassiron", ModBlocks.iron_glassdoor, Blocks.IRON_DOOR);
            String templateFile = readTemplateFile("loot_door");
            for (String wood : woodtype)
                pack.add(new Identifier(GlassDoorMod.MOD_ID, "loot_tables/blocks/" + wood + "_glassdoor.json"), new TemplateResource(templateFile).expand("woodtype", wood));
        });
        File Path = new File(FabricLoader.getInstance().getGameDirectory() +"/dump");
        try {
            Files.createDirectories(Path.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Artifice.DATA.iterator().forEachRemaining(pack -> {
            try {
                pack.dumpResources(Path.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void registerRecipe(ArtificeResourcePack.ServerResourcePackBuilder pack, String name, Block output, Block input) {
        pack.addShapelessRecipe(new Identifier(GlassDoorMod.MOD_ID, name + "_recipe"), recipe -> {
            recipe.result(Registry.BLOCK.getId(output), 1);
            recipe.ingredientItem(Registry.BLOCK.getId(input));
            recipe.ingredientItem(Registry.BLOCK.getId(Blocks.GLASS_PANE));
        });
    }

    static void generateAssets() {
        String[] woodtype = {"oak", "spruce", "birch", "acacia", "jungle", "dark_oak", "iron"};
        Artifice.registerAssets(GlassDoorMod.MOD_ID + ":glassdoors", pack -> {
            String templateFile = readTemplateFile("blockstate_door");
            for (String wood : woodtype) {
                pack.add(new Identifier(GlassDoorMod.MOD_ID, "blockstates/" + wood + "_glassdoor.json"), new TemplateResource(templateFile).expand("woodtype", wood));

                pack.addItemModel(new Identifier(GlassDoorMod.MOD_ID, wood + "_glassdoor"), model -> {
                    model.parent(new Identifier("item/generated"));
                    model.texture("layer0", new Identifier(GlassDoorMod.MOD_ID, "item/" + wood + "_door"));
                });
                pack.addBlockModel(new Identifier(GlassDoorMod.MOD_ID, wood + "_door_bottom"), model -> {
                    model.parent(new Identifier("block/door_bottom"));
                    model.texture("bottom", new Identifier(GlassDoorMod.MOD_ID, "block/" + wood + "_door_bottom"));
                    model.texture("top", new Identifier(GlassDoorMod.MOD_ID, "block/" + wood + "_door_top"));
                });
                pack.addBlockModel(new Identifier(GlassDoorMod.MOD_ID, "" + wood + "_door_bottom_hinge"), model -> {
                    model.parent(new Identifier("block/door_bottom_rh"));
                    model.texture("bottom", new Identifier(GlassDoorMod.MOD_ID, "block/" + wood + "_door_bottom"));
                    model.texture("top", new Identifier(GlassDoorMod.MOD_ID, "block/" + wood + "_door_top"));
                });
                pack.addBlockModel(new Identifier(GlassDoorMod.MOD_ID, "" + wood + "_door_top"), model -> {
                    model.parent(new Identifier("block/door_top"));
                    model.texture("bottom", new Identifier(GlassDoorMod.MOD_ID, "block/" + wood + "_door_bottom"));
                    model.texture("top", new Identifier(GlassDoorMod.MOD_ID, "block/" + wood + "_door_top"));
                });
                pack.addBlockModel(new Identifier(GlassDoorMod.MOD_ID, "" + wood + "_door_top_hinge"), model -> {
                    model.parent(new Identifier("block/door_top_rh"));
                    model.texture("bottom", new Identifier(GlassDoorMod.MOD_ID, "block/" + wood + "_door_bottom"));
                    model.texture("top", new Identifier(GlassDoorMod.MOD_ID, "block/" + wood + "_door_top"));
                });
            }
        });
        File Path = new File(FabricLoader.getInstance().getGameDirectory() +"/dump");
        try {
            Files.createDirectories(Path.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Artifice.ASSETS.iterator().forEachRemaining(pack -> {
            try {
                pack.dumpResources(Path.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static String readTemplateFile(String templateFile) {
        String file =  "/template/" + templateFile + ".json";
        InputStream in = GlassDoorMod.class.getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return reader.lines().collect(Collectors.joining());
    }
}
