package com.floppydisk.sandwichmod.datagen;

import com.floppydisk.sandwichmod.SandwichMod;
import com.floppydisk.sandwichmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SandwichMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STAINLESS_STEEL_BLOCK.get(),
                        ModBlocks.CHROMITE_ORE.get(),
                        ModBlocks.DEEPSLATE_CHROMITE_ORE.get(),
                        ModBlocks.CUTTER.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.STAINLESS_STEEL_BLOCK.get(),
                        ModBlocks.CHROMITE_ORE.get(),
                        ModBlocks.DEEPSLATE_CHROMITE_ORE.get(),
                        ModBlocks.CUTTER.get());
    }
}