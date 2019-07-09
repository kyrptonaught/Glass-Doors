package net.kyrptonaught.glassdoor;

import com.swordglowsblue.artifice.api.Artifice;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import com.swordglowsblue.artifice.api.resource.StringResource;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

class ArtificeHelper {
    static void generateRecipies() {
        String[] woodtype = {"oak", "spruce", "birch", "acacia", "jungle", "dark_oak" , "iron"};
        Artifice.registerData("", pack -> {
            registerRecipe(pack, "glassoak", ModBlocks.oak_glassdoor, Blocks.OAK_DOOR);
            registerRecipe(pack, "glassspruce", ModBlocks.spruce_glassdoor, Blocks.SPRUCE_DOOR);
            registerRecipe(pack, "glassacacia", ModBlocks.acacia_glassdoor, Blocks.ACACIA_DOOR);
            registerRecipe(pack, "glassbirch", ModBlocks.birch_glassdoor, Blocks.BIRCH_DOOR);
            registerRecipe(pack, "glassjungle", ModBlocks.jungle_glassdoor, Blocks.JUNGLE_DOOR);
            registerRecipe(pack, "glassdarkoak", ModBlocks.dark_oak_glassdoor, Blocks.DARK_OAK_DOOR);
            registerRecipe(pack,"glassiron", ModBlocks.iron_glassdoor,Blocks.IRON_DOOR);
            for (String wood : woodtype)
                pack.add(new Identifier(GlassDoorMod.MOD_ID, "loot_tables/blocks/" + wood + "_glassdoor.json"), new StringResource(generateLootTable(wood)));
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
            for (String wood : woodtype) {
                pack.add(new Identifier(GlassDoorMod.MOD_ID, "blockstates/" + wood + "_glassdoor.json"), new StringResource(generateBlockState(wood)));
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
    }

    static String generateLootTable(String wood) {
        return "{\n" +
                "  \"type\": \"minecraft:block\",\n" +
                "  \"pools\": [\n" +
                "    {\n" +
                "      \"rolls\": 1,\n" +
                "      \"entries\": [\n" +
                "        {\n" +
                "          \"type\": \"minecraft:item\",\n" +
                "          \"conditions\": [\n" +
                "            {\n" +
                "              \"condition\": \"minecraft:block_state_property\",\n" +
                "              \"block\": \"glassdoor:" + wood + "_glassdoor\",\n" +
                "              \"properties\": {\n" +
                "                \"half\": \"lower\"\n" +
                "              }\n" +
                "            }\n" +
                "          ],\n" +
                "          \"name\": \"glassdoor:" + wood + "_glassdoor\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"conditions\": [\n" +
                "        {\n" +
                "          \"condition\": \"minecraft:survives_explosion\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    static String generateBlockState(String wood) {
        return ("{\n" +
                "    \"variants\": {\n" +
                "        \"facing=east,half=lower,hinge=left,open=false\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom\" },\n" +
                "        \"facing=south,half=lower,hinge=left,open=false\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom\", \"y\": 90 },\n" +
                "        \"facing=west,half=lower,hinge=left,open=false\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom\", \"y\": 180 },\n" +
                "        \"facing=north,half=lower,hinge=left,open=false\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom\", \"y\": 270 },\n" +
                "        \"facing=east,half=lower,hinge=right,open=false\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom_hinge\" },\n" +
                "        \"facing=south,half=lower,hinge=right,open=false\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom_hinge\", \"y\": 90 },\n" +
                "        \"facing=west,half=lower,hinge=right,open=false\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom_hinge\", \"y\": 180 },\n" +
                "        \"facing=north,half=lower,hinge=right,open=false\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom_hinge\", \"y\": 270 },\n" +
                "        \"facing=east,half=lower,hinge=left,open=true\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom_hinge\", \"y\": 90 },\n" +
                "        \"facing=south,half=lower,hinge=left,open=true\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom_hinge\", \"y\": 180 },\n" +
                "        \"facing=west,half=lower,hinge=left,open=true\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom_hinge\", \"y\": 270 },\n" +
                "        \"facing=north,half=lower,hinge=left,open=true\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom_hinge\" },\n" +
                "        \"facing=east,half=lower,hinge=right,open=true\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom\", \"y\": 270 },\n" +
                "        \"facing=south,half=lower,hinge=right,open=true\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom\" },\n" +
                "        \"facing=west,half=lower,hinge=right,open=true\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom\", \"y\": 90 },\n" +
                "        \"facing=north,half=lower,hinge=right,open=true\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_bottom\", \"y\": 180 },\n" +
                "        \"facing=east,half=upper,hinge=left,open=false\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top\" },\n" +
                "        \"facing=south,half=upper,hinge=left,open=false\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top\", \"y\": 90 },\n" +
                "        \"facing=west,half=upper,hinge=left,open=false\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top\", \"y\": 180 },\n" +
                "        \"facing=north,half=upper,hinge=left,open=false\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top\", \"y\": 270 },\n" +
                "        \"facing=east,half=upper,hinge=right,open=false\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top_hinge\" },\n" +
                "        \"facing=south,half=upper,hinge=right,open=false\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top_hinge\", \"y\": 90 },\n" +
                "        \"facing=west,half=upper,hinge=right,open=false\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top_hinge\", \"y\": 180 },\n" +
                "        \"facing=north,half=upper,hinge=right,open=false\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top_hinge\", \"y\": 270 },\n" +
                "        \"facing=east,half=upper,hinge=left,open=true\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top_hinge\", \"y\": 90 },\n" +
                "        \"facing=south,half=upper,hinge=left,open=true\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top_hinge\", \"y\": 180 },\n" +
                "        \"facing=west,half=upper,hinge=left,open=true\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top_hinge\", \"y\": 270 },\n" +
                "        \"facing=north,half=upper,hinge=left,open=true\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top_hinge\" },\n" +
                "        \"facing=east,half=upper,hinge=right,open=true\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top\", \"y\": 270 },\n" +
                "        \"facing=south,half=upper,hinge=right,open=true\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top\" },\n" +
                "        \"facing=west,half=upper,hinge=right,open=true\":  { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top\", \"y\": 90 },\n" +
                "        \"facing=north,half=upper,hinge=right,open=true\": { \"model\": \"" + GlassDoorMod.MOD_ID + ":block/" + wood + "_door_top\", \"y\": 180 }\n" +
                "    }\n" +
                "}\n");
    }
}
