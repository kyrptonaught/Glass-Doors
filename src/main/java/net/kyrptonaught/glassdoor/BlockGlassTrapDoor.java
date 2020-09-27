package net.kyrptonaught.glassdoor;

import net.minecraft.block.TrapdoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.TallBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockGlassTrapDoor extends TrapdoorBlock {
    protected BlockGlassTrapDoor(Settings settings, String name) {
        super(settings);
        Registry.register(Registry.BLOCK, new Identifier(GlassDoorMod.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(GlassDoorMod.MOD_ID, name), new BlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));
    }
}
