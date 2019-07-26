package net.kyrptonaught.glassdoor;

import net.fabricmc.api.ModInitializer;


public class GlassDoorMod implements ModInitializer {
    static final String MOD_ID = "glassdoor";

    @Override
    public void onInitialize() {
        ModBlocks.register();
    }
}
