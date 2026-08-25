package net.verity.modganteng.tags;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.verity.modganteng.ModGanteng;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_VALDERIUM_TOOL = createTag("needs_valderium_tool");
        public static final TagKey<Block> INCORRECT_FOR_VALDERIUM_TOOL = createTag("incorrect_for_valderium_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(ModGanteng.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> VALDERIUM_REPAIRABLE = createTag("valderium_repairable");


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(ModGanteng.MOD_ID, name));
        }
    }
}
