package net.matty.bmbc.block.custom;

import net.matty.bmbc.item.ModArmorItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import java.util.stream.StreamSupport;

public class RadioactiveBlock extends Block {
    private final int radiationRange;
    private final float radiationDamage;

    public RadioactiveBlock(Properties properties, int radiationRange, float radiationDamage) {
        super(properties);
        this.radiationRange = radiationRange;
        this.radiationDamage = radiationDamage;
    }

    public int getRadiationRange() {
        return this.radiationRange;
    }

    public float getRadiationDamage() {
        return this.radiationDamage;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) { // TODO: THIS DOESNT WORK
        super.tick(state, level, pos, random);

        if (!level.isClientSide()) {
            // Check if a player is near the block
            Player player = level.getNearestPlayer(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, getRadiationRange(), false);
            if (player != null) {
                if (hasHazmatSuit(player)) {
                    System.out.println("NO NEARBY RADIATION");
                } else {
                    System.out.println("PLS WORK");
                    player.hurt(level.damageSources().generic(), getRadiationDamage());
                }
            }
        }
    }


    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (player != null) {
            if (hasHazmatSuit(player)) {
                System.out.println("NOT HAZARDOUS");
            } else {
                // Damage the player for breaking the block without a full hazmat suit.
                System.out.println("RADIOACTIVE");
                player.hurt(level.damageSources().generic(), getRadiationDamage());
            }
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }


    public boolean hasHazmatSuit(Player player) {
        // Check if the player is wearing a hazmat suit item
        // Return true if they are, false otherwise
        Item hazmatHelmet = ModArmorItems.NBC_HAZMAT_MASK.get();
        Item hazmatChestplate = ModArmorItems.NBC_HAZMAT_CHESTPLATE.get();
        Item hazmatLeggings = ModArmorItems.NBC_HAZMAT_LEGGINGS.get();
        Item hazmatBoots = ModArmorItems.NBC_HAZMAT_BOOTS.get();

        Iterable<ItemStack> armorSlots = player.getArmorSlots();
        return StreamSupport.stream(armorSlots.spliterator(), false)
                .allMatch(itemStack -> {
                    Item item = itemStack.getItem();
                    return item == hazmatHelmet || item == hazmatChestplate || item == hazmatLeggings || item == hazmatBoots;
                });

        //return helmet.getItem() == ModArmorItems.NBC_HAZMAT_MASK.get() &&
        //        chestplate.getItem() == ModArmorItems.NBC_HAZMAT_CHESTPLATE.get() &&
        //        leggings.getItem() == ModArmorItems.NBC_HAZMAT_LEGGINGS.get() &&
        //        boots.getItem() == ModArmorItems.NBC_HAZMAT_BOOTS.get();
    }
}
