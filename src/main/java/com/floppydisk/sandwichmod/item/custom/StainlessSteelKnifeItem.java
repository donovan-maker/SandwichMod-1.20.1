package com.floppydisk.sandwichmod.item.custom;

import com.floppydisk.sandwichmod.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class StainlessSteelKnifeItem extends Item {

    public StainlessSteelKnifeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        boolean knifed = false;
        if (!pLevel.isClientSide) {
            knifed = replaceItemInOffhand(pPlayer, 1, new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.IRON_DUST.get(), 1));
        }
        if (knifed) {
            pPlayer.getItemInHand(pUsedHand).hurtAndBreak(1, pPlayer,
                    player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        }
        return InteractionResultHolder.sidedSuccess(pPlayer.getItemInHand(pUsedHand), pLevel.isClientSide);
    }

    private boolean replaceItemInOffhand(Player player, int count, ItemStack takingItem, ItemStack givingItem) {
        if (ItemStack.isSameItemSameTags(player.getOffhandItem(), takingItem)) {
            player.getOffhandItem().shrink(count);
            player.getInventory().add(givingItem);
            return true;
        }
        return false;
    }
}