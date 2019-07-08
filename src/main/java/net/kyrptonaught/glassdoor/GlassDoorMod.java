package net.kyrptonaught.glassdoor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;


public class GlassDoorMod implements ModInitializer, ClientModInitializer {
    static final String MOD_ID = "glassdoor";

    @Override
    public void onInitialize() {
        ModBlocks.register();
        ArtificeHelper.generateRecipies();
    }

    @Override
    public void onInitializeClient() {
        ArtificeHelper.generateAssets();
    }
}
