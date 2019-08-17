package net.kyrptonaught.glassdoor;

import net.minecraft.block.DoorBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.TallBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class BlockGlassDoor extends DoorBlock {

    BlockGlassDoor(Settings block$Settings_1, String name) {
        super(block$Settings_1);
        Registry.register(Registry.BLOCK, new Identifier(GlassDoorMod.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(GlassDoorMod.MOD_ID, name), new TallBlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));
    }
}
