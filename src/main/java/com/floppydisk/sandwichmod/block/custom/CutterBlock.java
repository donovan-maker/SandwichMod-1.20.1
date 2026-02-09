package com.floppydisk.sandwichmod.block.custom;

import com.floppydisk.sandwichmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CutterBlock extends Block {
    private boolean cut;

    public CutterBlock(Properties pProperties) {
        super(pProperties);
        this.cut = false;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide) {
            boolean cut = false;
            cut = replaceItem(pPlayer, pHand, 1, new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.IRON_DUST.get(), 1)) || cut;
            cut = replaceItem(pPlayer, pHand, 1, new ItemStack(ModItems.PB_J_SANDWICH.get()), new ItemStack(ModItems.CUT_PB_J_SANDWICH.get(), 2)) || cut;
            cut = replaceItem(pPlayer, pHand, 1, new ItemStack(ModItems.PEANUT.get()), new ItemStack(ModItems.PEANUT_BUTTER.get(), 1)) || cut;
            cut = replaceItem(pPlayer, pHand, 1, new ItemStack(Items.SWEET_BERRIES), new ItemStack(ModItems.SWEET_BERRY_JELLY.get(), 1)) || cut;
            if (cut) {
                pLevel.playSound(null, pPos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1f, 1f);
            }
        }
        return InteractionResult.SUCCESS;
    }

    private boolean replaceItem(Player player, InteractionHand hand, int count, ItemStack takingItem, ItemStack givingItem) {
        if (ItemStack.isSameItemSameTags(player.getItemInHand(hand), takingItem)) {
            player.getItemInHand(hand).shrink(count);
            player.getInventory().add(givingItem);
            return true;
        }
        return false;
    }
}