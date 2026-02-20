package com.floppydisk.sandwichmod.datagen;

import com.floppydisk.sandwichmod.SandwichMod;
import com.floppydisk.sandwichmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SandwichMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.STAINLESS_STEEL_BLOCK);

        blockWithItem(ModBlocks.CHROMITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CHROMITE_ORE);

        cutterBlock(ModBlocks.CUTTER);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void cutterBlock(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(),
                models().cubeBottomTop(
                        block.getId().getPath(),
                        modLoc("block/stainless_steel_block"),
                        modLoc("block/stainless_steel_block"),
                        modLoc("block/cutter")
                ));
    }
}