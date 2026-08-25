package net.verity.modganteng.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.verity.modganteng.ModGanteng;
import net.verity.modganteng.block.ModBlocks;
import net.verity.modganteng.item.ModItems;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, ModGanteng.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.RAW_VALDERIUM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.VALDERIUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.VALDERIUM_APPLE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.VALDERIUM_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.VALDERIUM_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.VALDERIUM_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.VALDERIUM_SHOVEl.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.VALDERIUM_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModels.generateSpear(ModItems.VALDERIUM_SPEAR.get());


        /* BLOCKS */
        blockModels.createTrivialCube(ModBlocks.VALDERIUM_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.VALDERIUM_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_VALDERIUM_ORE.get());

    }
}
