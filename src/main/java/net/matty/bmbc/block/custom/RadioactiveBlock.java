package net.matty.bmbc.block.custom;

import net.matty.bmbc.item.ModArmorItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class RadioactiveBlock extends Block {
    public RadioactiveBlock(Properties properties) {
        super(properties);
    }

    //public void randomTick(BlockState blockState, ServerLevel level, BlockPos blockPos, RandomSource source) {
    //    if (!level.isAreaLoaded(blockPos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
    //    if (level.getMaxLocalRawBrightness(blockPos.above()) >= 9) {
    //        BlockState blockstate = this.defaultBlockState();
//
    //        for(int i = 0; i < 4; ++i) {
    //            BlockPos blockpos = blockPos.offset(source.nextInt(3) - 1, source.nextInt(5) - 3, source.nextInt(3) - 1);
    //        }
    //    }
    //}


    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (hasHazmatSuit(player) == false) {
            System.out.println("RADIOACTIVE");
            player.hurt(level.damageSources().generic(), 2.0f);
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }


    public boolean hasHazmatSuit(Player player) {
        // Check if the player is wearing a hazmat suit item
        // Return true if they are, false otherwise
        ItemStack helmet = player.getInventory().armor.get(0);
        ItemStack chestplate = player.getInventory().armor.get(1);
        ItemStack leggings = player.getInventory().armor.get(2);
        ItemStack boots = player.getInventory().armor.get(3);

        return helmet.getItem() == ModArmorItems.NBC_HAZMAT_MASK.get() &&
                chestplate.getItem() == ModArmorItems.NBC_HAZMAT_CHESTPLATE.get() &&
                leggings.getItem() == ModArmorItems.NBC_HAZMAT_LEGGINGS.get() &&
                boots.getItem() == ModArmorItems.NBC_HAZMAT_BOOTS.get();
    }


    //private IItemHandlerModifiable hasHazmatSuit(Player player) {
    //    // Check if the player is wearing a hazmat suit item
    //    // Return true if they are, false otherwise
    //    return player.getCapability(ForgeCapabilities.ITEM_HANDLER)
    //            .map(itemHandler -> {
    //                if (itemHandler instanceof IItemHandlerModifiable) {
    //                    IItemHandlerModifiable itemHandlerModifiable = (IItemHandlerModifiable) itemHandler;
    //                    ItemStack chestplateSlot = itemHandlerModifiable.getStackInSlot(2); // Slot 2 is the chestplate slot
//
    //                    // Check if the item in the chestplate slot is a diamond chestplate
    //                    return chestplateSlot.getItem() == ModArmorItems.NBC_HAZMAT_CHESTPLATE;
    //                }
//
    //                return false; // Capability exists but is not an instance of IItemHandlerModifiable
    //            })
    //            .orElse(false); // Fallback if the capability doesn't exist
//
    //}
}
