package net.verity.modganteng.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.verity.modganteng.ModGanteng;
import net.verity.modganteng.block.ModBlocks;
import net.verity.modganteng.tags.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ModGanteng.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VALDERIUM_BLOCK.get())
                .add(ModBlocks.VALDERIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_VALDERIUM_ORE.get());

        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.VALDERIUM_ORE.get())
                .add(ModBlocks.VALDERIUM_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_VALDERIUM_ORE.get());

        tag(ModTags.Blocks.NEEDS_VALDERIUM_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_VALDERIUM_TOOL);

        List.of(
                BlockTags.INCORRECT_FOR_WOODEN_TOOL,
                BlockTags.INCORRECT_FOR_STONE_TOOL,
                BlockTags.INCORRECT_FOR_IRON_TOOL,
                BlockTags.INCORRECT_FOR_GOLD_TOOL,
                BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                BlockTags.INCORRECT_FOR_NETHERITE_TOOL
        ).forEach(tag -> this.tag(tag)
                .addTag(ModTags.Blocks.INCORRECT_FOR_VALDERIUM_TOOL)
        );

    }
}
