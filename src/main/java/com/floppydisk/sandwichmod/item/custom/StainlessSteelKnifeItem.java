package com.floppydisk.sandwichmod.item.custom;

import com.floppydisk.sandwichmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StainlessSteelKnifeItem extends Item {

    public StainlessSteelKnifeItem(Properties pProperties) {
        super(pProperties.durability(250));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        boolean cut = false;
        if (!pLevel.isClientSide) {
            cut = replaceItemInOffhand(pPlayer, 1, new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.IRON_DUST.get(), 1));
            cut = replaceItemInOffhand(pPlayer, 1, new ItemStack(ModItems.PB_J_SANDWICH.get()), new ItemStack(ModItems.CUT_PB_J_SANDWICH.get(), 2));
            cut = replaceItemInOffhand(pPlayer, 1, new ItemStack(ModItems.PEANUT.get()), new ItemStack(ModItems.PEANUT_BUTTER.get(), 1));
            cut = replaceItemInOffhand(pPlayer, 1, new ItemStack(Items.SWEET_BERRIES), new ItemStack(ModItems.SWEET_BERRY_JELLY.get(), 1));
        }
        if (cut) {
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

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.sandwichmod.stainless_steel_knife_line1.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.sandwichmod.stainless_steel_knife_line2.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack copy = itemStack.copy();
        copy.hurt(1, RandomSource.create(), null);
        return copy.isEmpty() ? ItemStack.EMPTY : copy;
    }
}