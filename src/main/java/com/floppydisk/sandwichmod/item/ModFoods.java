package com.floppydisk.sandwichmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PB_J_SANDWICH = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.8f)
            .build();

    public static final FoodProperties CUT_PB_J_SANDWICH = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.6f)
            .build();

    public static final FoodProperties PEANUT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.2f)
            .build();

    public static final FoodProperties PEANUT_BUTTER = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.4f)
            .build();

    public static final FoodProperties SWEET_BERRY_JELLY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.4f)
            .build();
}