package net.verity.modganteng.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
                .save(output);

        shaped(RecipeCategory.MISC, ModBlocks.RAW_VALDERIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_VALDERIUM.get())
                .unlockedBy(getHasName(ModItems.RAW_VALDERIUM.get()), has(ModItems.RAW_VALDERIUM))
                .save(output);

        shaped(RecipeCategory.FOOD, ModItems.VALDERIUM_APPLE.get())
                .pattern("AAA")
                .pattern("ACA")
                .pattern("AAA")
                .define('A', ModItems.VALDERIUM_INGOT.get())
                .define('C', Items.APPLE)
                .unlockedBy(getHasName(ModItems.RAW_VALDERIUM.get()), has(ModItems.RAW_VALDERIUM))
                .save(output);


        shapeless(RecipeCategory.MISC, ModItems.VALDERIUM_INGOT.get(), 9)
                .requires(ModBlocks.VALDERIUM_BLOCK)
                .unlockedBy(getHasName(ModBlocks.VALDERIUM_BLOCK.get()), has(ModBlocks.VALDERIUM_BLOCK))
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.RAW_VALDERIUM.get(), 9)
                .requires(ModBlocks.RAW_VALDERIUM_BLOCK)
                .unlockedBy(getHasName(ModBlocks.RAW_VALDERIUM_BLOCK.get()), has(ModBlocks.RAW_VALDERIUM_BLOCK))
                .save(output);

        copyTemplate(ModItems.VALDERIUM_SMITHING_TEMPLATE.get(), ModItems.VALDERIUM_INGOT.get(), Items.DEEPSLATE);

        smithing(ModItems.VALDERIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_PICKAXE, ModItems.VALDERIUM_INGOT.get(), ModItems.VALDERIUM_PICKAXE.get());
        smithing(ModItems.VALDERIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, ModItems.VALDERIUM_INGOT.get(), ModItems.VALDERIUM_SWORD.get());
        smithing(ModItems.VALDERIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_AXE, ModItems.VALDERIUM_INGOT.get(), ModItems.VALDERIUM_AXE.get());
        smithing(ModItems.VALDERIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_HOE, ModItems.VALDERIUM_INGOT.get(), ModItems.VALDERIUM_HOE.get());
        smithing(ModItems.VALDERIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_SHOVEL, ModItems.VALDERIUM_INGOT.get(), ModItems.VALDERIUM_SHOVEL.get());
        smithing(ModItems.VALDERIUM_SMITHING_TEMPLATE.get(), Items.NETHERITE_SPEAR, ModItems.VALDERIUM_INGOT.get(), ModItems.VALDERIUM_SPEAR.get());
        smithing(ModItems.VALDERIUM_SMITHING_TEMPLATE.get(), Items.MACE, ModItems.VALDERIUM_INGOT.get(), ModItems.VALDERIUM_MACE.get());

        List<ItemLike> VALDERIUM_SMELTABLES = List.of(ModItems.RAW_VALDERIUM, ModBlocks.VALDERIUM_ORE, ModBlocks.DEEPSLATE_VALDERIUM_ORE);

        oreSmelting(VALDERIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.VALDERIUM_INGOT.get(), 0.5F, 300, "valderium");
        oreBlasting(VALDERIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.VALDERIUM_INGOT.get(), 0.5F, 150, "valderium");
    }

    protected void copyTemplate(Item template, Item material, ItemLike baseBlock) {
        shaped(RecipeCategory.MISC, template, 2)
                .pattern("ASA")
                .pattern("ACA")
                .pattern("AAA")
                .define('A', material)
                .define('C', baseBlock)
                .define('S', template)
                .unlockedBy("has_" + getHasName(template), has(template))
                .save(output);
    }

    protected void smithing(Item template, Item base, Item addition, Item result) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(template),
                        Ingredient.of(base),
                        Ingredient.of(addition),
                        RecipeCategory.MISC,
                        result
                )
                .unlocks("has_" + getItemName(addition), this.has(addition))
                .save(this.output, ModGanteng.MOD_ID + ":" + getItemName(result) + "_smithing");
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
