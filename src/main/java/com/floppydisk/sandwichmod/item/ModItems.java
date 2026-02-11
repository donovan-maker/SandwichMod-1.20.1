package com.floppydisk.sandwichmod.item;

import com.floppydisk.sandwichmod.SandwichMod;
import com.floppydisk.sandwichmod.item.custom.KnifeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, SandwichMod.MODID);

    public static final RegistryObject<Item> STAINLESS_STEEL_INGOT = ITEMS.register("stainless_steel_ingot",
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STAINLESS_STEEL_DUST = ITEMS.register("stainless_steel_dust",
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHROMIUM_DUST = ITEMS.register("chromium_dust",
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust",
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KNIFE = ITEMS.register("knife",
        () -> new KnifeItem(new Item.Properties()));
    public static final RegistryObject<Item> STAINLESS_STEEL_BLADE = ITEMS.register("stainless_steel_blade",
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PB_J_SANDWICH = ITEMS.register("pb_j_sandwich",
        () -> new Item(new Item.Properties().food(ModFoods.PB_J_SANDWICH)));
    public static final RegistryObject<Item> CUT_PB_J_SANDWICH = ITEMS.register("cut_pb_j_sandwich",
        () -> new Item(new Item.Properties().food(ModFoods.CUT_PB_J_SANDWICH)));
    public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut",
            () -> new Item(new Item.Properties().food(ModFoods.PEANUT)));
    public static final RegistryObject<Item> PEANUT_BUTTER = ITEMS.register("peanut_butter",
            () -> new Item(new Item.Properties().food(ModFoods.PEANUT_BUTTER)));
    public static final RegistryObject<Item> SWEET_BERRY_JELLY = ITEMS.register("sweet_berry_jelly",
            () -> new Item(new Item.Properties().food(ModFoods.SWEET_BERRY_JELLY)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}