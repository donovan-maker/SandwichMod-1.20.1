package com.floppydisk.sandwichmod.item;

import com.floppydisk.sandwichmod.SandwichMod;
import com.floppydisk.sandwichmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SandwichMod.MODID);
    
    // Change creative mode tab icon to pb&j later
    public static final RegistryObject<CreativeModeTab> SANDWICH_TAB = CREATIVE_MODE_TABS.register("sandwich_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STAINLESS_STEEL_INGOT.get()))
        .title(Component.translatable("creativetab.sandwich_tab"))
        .displayItems((pParameters, pOutput) -> {
            pOutput.accept(ModBlocks.STAINLESS_STEEL_BLOCK.get());
            pOutput.accept(ModItems.STAINLESS_STEEL_INGOT.get());
            pOutput.accept(ModItems.STAINLESS_STEEL_DUST.get());
            pOutput.accept(ModItems.CHROMIUM_DUST.get());
            pOutput.accept(ModItems.IRON_DUST.get());
            pOutput.accept(ModBlocks.CHROMITE_ORE.get());
            pOutput.accept(ModBlocks.DEEPSLATE_CHROMITE_ORE.get());
        })
        .build());
    
    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }
}