package net.verity.modganteng.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.verity.modganteng.ModGanteng;
import net.verity.modganteng.block.ModBlocks;

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
    }
}
