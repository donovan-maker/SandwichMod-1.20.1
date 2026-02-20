package com.floppydisk.sandwichmod.datagen;

import com.floppydisk.sandwichmod.SandwichMod;
import com.floppydisk.sandwichmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SandwichMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.STAINLESS_STEEL_INGOT);

        simpleItem(ModItems.STAINLESS_STEEL_DUST);
        simpleItem(ModItems.CHROMIUM_DUST);
        simpleItem(ModItems.IRON_DUST);

        simpleItem(ModItems.KNIFE);

        simpleItem(ModItems.STAINLESS_STEEL_BLADE);

        simpleItem(ModItems.PB_J_SANDWICH);
        simpleItem(ModItems.CUT_PB_J_SANDWICH);
        simpleItem(ModItems.PEANUT);
        simpleItem(ModItems.PEANUT_BUTTER);
        simpleItem(ModItems.SWEET_BERRY_JELLY);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SandwichMod.MODID, "item/" + item.getId().getPath()));
    }
}