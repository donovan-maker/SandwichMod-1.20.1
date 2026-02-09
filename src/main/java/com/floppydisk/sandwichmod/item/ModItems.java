package com.floppydisk.sandwichmod.item;

import com.floppydisk.sandwichmod.SandwichMod;
import com.floppydisk.sandwichmod.item.custom.StainlessSteelKnifeItem;
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
    public static final RegistryObject<Item> STAINLESS_STEEL_KNIFE = ITEMS.register("stainless_steel_knife",
        () -> new StainlessSteelKnifeItem(new Item.Properties().durability(250)));
    public static final RegistryObject<Item> STAINLESS_STEEL_BLADE = ITEMS.register("stainless_steel_blade",
        () -> new Item(new Item.Properties()));
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}