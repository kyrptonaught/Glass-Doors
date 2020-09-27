package net.kyrptonaught.glassdoor;

import java.io.File;
import java.io.FileOutputStream;

public class DataGenerator {
    static String[] woods = {"oak", "spruce", "birch", "acacia", "jungle", "dark_oak", "iron"};
    static String[] types = {"bottom", "open", "top"};

    public static void genModels() {
        for (String type : types)
            for (String wood : woods) {
                File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\assets\\glassdoor\\models\\block\\trapdoor\\" + wood + "_glasstrapdoor_" + type + ".json");
                try (FileOutputStream out = new FileOutputStream(file, false)) {
                    if (!file.exists())
                        file.createNewFile();
                    String output = "{\n" +
                            "  \"parent\": \"glassdoor:block/template/template_trapdoor_" + type + "\",\n" +
                            "  \"textures\": {\n" +
                            "    \"texture\": \"glassdoor:block/" + wood + "_glasstrapdoor\",\n" +
                            "    \"texture2\": \"minecraft:block/" + wood + "_trapdoor\"\n" +
                            "  }\n" +
                            "}";
                    out.write(output.getBytes());
                } catch (Exception e) {
                }
            }
    }

    public static void genItemModels() {
        for (String wood : woods) {
            File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\assets\\glassdoor\\models\\item\\" + wood + "_glasstrapdoor.json");
            try (FileOutputStream out = new FileOutputStream(file, false)) {
                if (!file.exists())
                    file.createNewFile();
                String output = "{\n" +
                        "  \"parent\": \"glassdoor:block/trapdoor/" + wood + "_glasstrapdoor_bottom\"\n" +
                        "}";
                out.write(output.getBytes());
            } catch (Exception e) {
            }
        }
    }

    public static void genRecipies() {
        for (String wood : woods) {
            File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\data\\glassdoor\\recipes\\trapdoor\\" + wood + "_glasstrapdoor.json");
            try (FileOutputStream out = new FileOutputStream(file, false)) {
                if (!file.exists())
                    file.createNewFile();
                String output = "{\n" +
                        "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                        "  \"result\": {\n" +
                        "    \"item\": \"glassdoor:" + wood + "_glasstrapdoor\",\n" +
                        "    \"count\": 1\n" +
                        "  },\n" +
                        "  \"ingredients\": [\n" +
                        "    {\n" +
                        "      \"item\": \"minecraft:" + wood + "_trapdoor\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"item\": \"minecraft:glass_pane\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                out.write(output.getBytes());
            } catch (Exception e) {
            }
        }
    }

    public static void genRecipiesReverse() {
        for (String wood : woods) {
            File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\data\\glassdoor\\recipes\\reverse\\trapdoor\\" + wood + "_glasstrapdoor.json");
            try (FileOutputStream out = new FileOutputStream(file, false)) {
                if (!file.exists())
                    file.createNewFile();
                String output = "{\n" +
                        "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                        "  \"result\": {\n" +
                        "    \"item\": \"minecraft:" + wood + "_trapdoor\",\n" +
                        "    \"count\": 1\n" +
                        "  },\n" +
                        "  \"ingredients\": [\n" +
                        "    {\n" +
                        "      \"item\": \"glassdoor:" + wood + "_glasstrapdoor\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                out.write(output.getBytes());
            } catch (Exception e) {
            }
        }
    }
    public static void genloot() {
        for (String wood : woods) {
            File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\data\\glassdoor\\loot_tables\\blocks\\" + wood + "_glasstrapdoor.json");
            try (FileOutputStream out = new FileOutputStream(file, false)) {
                if (!file.exists())
                    file.createNewFile();
                String output = "{\n" +
                        "  \"type\": \"minecraft:block\",\n" +
                        "  \"pools\": [\n" +
                        "    {\n" +
                        "      \"rolls\": 1,\n" +
                        "      \"entries\": [\n" +
                        "        {\n" +
                        "          \"type\": \"minecraft:item\",\n" +
                        "          \"name\": \"glassdoor:"+wood+"_glasstrapdoor\"\n" +
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
                out.write(output.getBytes());
            } catch (Exception e) {
            }
        }
    }
}
