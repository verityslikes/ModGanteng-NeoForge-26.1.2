package net.verity.modganteng.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.verity.modganteng.ModGanteng;
import net.verity.modganteng.block.ModBlocks;
import net.verity.modganteng.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.MISC, ModBlocks.VALDERIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.VALDERIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.VALDERIUM_INGOT.get()), has(ModItems.VALDERIUM_INGOT))
                .group("valderium")
                .save(output);

        shaped(RecipeCategory.MISC, ModBlocks.RAW_VALDERIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_VALDERIUM.get())
                .unlockedBy(getHasName(ModItems.RAW_VALDERIUM.get()), has(ModItems.RAW_VALDERIUM))
                .group("valderium")
                .save(output);


        shapeless(RecipeCategory.MISC, ModItems.VALDERIUM_INGOT.get(), 9)
                .requires(ModBlocks.VALDERIUM_BLOCK)
                .unlockedBy(getHasName(ModBlocks.VALDERIUM_BLOCK.get()), has(ModBlocks.VALDERIUM_BLOCK))
                .group("valderium")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.RAW_VALDERIUM.get(), 9)
                .requires(ModBlocks.RAW_VALDERIUM_BLOCK)
                .unlockedBy(getHasName(ModBlocks.RAW_VALDERIUM_BLOCK.get()), has(ModBlocks.RAW_VALDERIUM_BLOCK))
                .group("valderium")
                .save(output);




        List<ItemLike> VALDERIUM_SMELTABLES = List.of(ModItems.RAW_VALDERIUM, ModBlocks.VALDERIUM_ORE, ModBlocks.DEEPSLATE_VALDERIUM_ORE);

        oreSmelting(VALDERIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.VALDERIUM_INGOT.get(), 0.5F, 300, "valderium");
        oreBlasting(VALDERIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.VALDERIUM_INGOT.get(), 0.5F, 150, "valderium");
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory,
                                                                ItemLike result, float experience, int cookingTime, String group, String fromDesc) {
        for (ItemLike item : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(item), craftingCategory, cookingCategory, result, experience, cookingTime, factory)
                    .group(group)
                    .unlockedBy(getHasName(item), this.has(item))
                    .save(this.output, ModGanteng.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(item));
        }
    }
}
