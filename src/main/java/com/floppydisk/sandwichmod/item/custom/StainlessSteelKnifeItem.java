package com.floppydisk.sandwichmod.item.custom;

import com.floppydisk.sandwichmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class StainlessSteelKnifeItem extends Item {
    private boolean knifed;

    public StainlessSteelKnifeItem(Properties pProperties) {
        super(pProperties);
        this.knifed = false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            replaceItemInOffhand(pPlayer, new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.IRON_DUST.get(), 1));
        }
        if (this.knifed) {
            pPlayer.getItemInHand(pUsedHand).hurtAndBreak(1, pPlayer,
                    player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        }
        return InteractionResultHolder.sidedSuccess(pPlayer.getItemInHand(pUsedHand), pLevel.isClientSide);
    }

    private void replaceItemInOffhand(Player player, ItemStack takingItem, ItemStack givingItem) {
        if (ItemStack.isSameItemSameTags(player.getOffhandItem(), takingItem)) {
            player.getOffhandItem().shrink(1);
            player.getInventory().add(givingItem);
            this.knifed = true;
        }
    }
}