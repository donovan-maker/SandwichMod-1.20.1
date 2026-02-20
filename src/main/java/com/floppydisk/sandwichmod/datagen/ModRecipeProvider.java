package com.floppydisk.sandwichmod.datagen;

import com.floppydisk.sandwichmod.SandwichMod;
import com.floppydisk.sandwichmod.block.ModBlocks;
import com.floppydisk.sandwichmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> CHROMITE_SMELTABLES = List.of(
            ModBlocks.CHROMITE_ORE.get(),
            ModBlocks.DEEPSLATE_CHROMITE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, CHROMITE_SMELTABLES, RecipeCategory.MISC, ModItems.CHROMIUM_DUST.get(), 0.7f, 200, "chromite");
        oreBlasting(pWriter, CHROMITE_SMELTABLES, RecipeCategory.MISC, ModItems.CHROMIUM_DUST.get(), 0.7f, 100, "chromite");

        oreSmelting(pWriter, List.of(ModItems.STAINLESS_STEEL_DUST.get()), RecipeCategory.MISC, ModItems.STAINLESS_STEEL_INGOT.get(), 0.7f, 200, "dusts");
        oreBlasting(pWriter, List.of(ModItems.STAINLESS_STEEL_DUST.get()), RecipeCategory.MISC, ModItems.STAINLESS_STEEL_INGOT.get(), 0.7f, 100, "dusts");

        oreBlasting(pWriter, List.of(Items.IRON_INGOT), RecipeCategory.MISC, ModItems.IRON_DUST.get(), 0.7f, 200, "dusts");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STAINLESS_STEEL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.STAINLESS_STEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.STAINLESS_STEEL_INGOT.get()), has(ModItems.STAINLESS_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CUTTER.get())
                .pattern("B")
                .pattern("S")
                .define('B', ModItems.STAINLESS_STEEL_BLADE.get())
                .define('S', ModBlocks.STAINLESS_STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModItems.STAINLESS_STEEL_BLADE.get()), has(ModItems.STAINLESS_STEEL_BLADE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KNIFE.get())
                .pattern("I")
                .pattern("S")
                .define('I', ModItems.STAINLESS_STEEL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.STAINLESS_STEEL_INGOT.get()), has(ModItems.STAINLESS_STEEL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STAINLESS_STEEL_BLADE.get())
                .pattern(" I ")
                .pattern("IPI")
                .pattern(" I ")
                .define('I', ModItems.STAINLESS_STEEL_INGOT.get())
                .define('P', ItemTags.create(new ResourceLocation("minecraft", "planks")))
                .unlockedBy(getHasName(ModItems.STAINLESS_STEEL_INGOT.get()), has(ModItems.STAINLESS_STEEL_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STAINLESS_STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STAINLESS_STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STAINLESS_STEEL_BLOCK.get()), has(ModBlocks.STAINLESS_STEEL_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PB_J_SANDWICH.get())
                .requires(Items.BREAD)
                .requires(ModItems.PEANUT_BUTTER.get())
                .requires(ModItems.SWEET_BERRY_JELLY.get())
                .requires(Items.BREAD)
                .requires(ModItems.KNIFE.get())
                .unlockedBy(getHasName(ModItems.KNIFE.get()), has(ModItems.KNIFE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STAINLESS_STEEL_DUST.get(), 2)
                .requires(ModItems.IRON_DUST.get())
                .requires(ModItems.CHROMIUM_DUST.get())
                .unlockedBy(getHasName(ModItems.CHROMIUM_DUST.get()), has(ModItems.CHROMIUM_DUST.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, SandwichMod.MODID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}