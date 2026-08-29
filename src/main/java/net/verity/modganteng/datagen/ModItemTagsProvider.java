package net.verity.modganteng.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.verity.modganteng.ModGanteng;
import net.verity.modganteng.item.ModItems;
import net.verity.modganteng.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ModGanteng.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.VALDERIUM_REPAIRABLE)
                .add(ModItems.VALDERIUM_INGOT.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.VALDERIUM_SWORD.get());

        tag(ItemTags.PICKAXES)
                .add(ModItems.VALDERIUM_PICKAXE.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.VALDERIUM_SHOVEL.get());

        tag(ItemTags.HOES)
                .add(ModItems.VALDERIUM_HOE.get());

        tag(ItemTags.AXES)
                .add(ModItems.VALDERIUM_AXE.get());

        tag(ItemTags.SPEARS)
                .add(ModItems.VALDERIUM_SPEAR.get());

        tag(ItemTags.MACE_ENCHANTABLE)
                .add(ModItems.VALDERIUM_MACE.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.VALDERIUM_BOOTS.get());

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.VALDERIUM_LEGGINGS.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.VALDERIUM_CHESTPLATE.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.VALDERIUM_HELMET.get());
    }
}
