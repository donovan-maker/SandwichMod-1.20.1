package com.floppydisk.sandwichmod.datagen.loot;

import com.floppydisk.sandwichmod.block.ModBlocks;
import com.floppydisk.sandwichmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.STAINLESS_STEEL_BLOCK.get());

        this.dropSelf(ModBlocks.CUTTER.get());

        this.add(ModBlocks.CHROMITE_ORE.get(),
                block -> createBasicOreDrops(ModBlocks.CHROMITE_ORE.get(), ModItems.CHROMIUM_DUST.get(), 1.0f, 2.0f));
        this.add(ModBlocks.DEEPSLATE_CHROMITE_ORE.get(),
                block -> createBasicOreDrops(ModBlocks.DEEPSLATE_CHROMITE_ORE.get(), ModItems.CHROMIUM_DUST.get(), 1.0f, 3.0f));
    }

    protected LootTable.Builder createBasicOreDrops(Block pBlock, Item item, float min, float max) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}