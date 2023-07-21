package net.matty.bmbc.block.custom;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.ModArmorItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fml.common.Mod;

import java.util.stream.StreamSupport;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RadioactiveBlock extends Block {
    public static int radiationRange;
    public static float radiationDamage;

    public RadioactiveBlock(Properties properties, int radiationRange, float radiationDamage) {
        super(properties);
        RadioactiveBlock.radiationRange = radiationRange;
        RadioactiveBlock.radiationDamage = radiationDamage;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (player != null) {
            if (hasHazmatSuit(player)) {
                System.out.println("TEsT");
            } else {
                // Damage the player for breaking the block without a full hazmat suit.
                player.hurt(level.damageSources().generic(), radiationDamage);
            }
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }


    public static boolean hasHazmatSuit(Player player) {
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
    }

    public static void applyRadiationDamage(Player player, Level level) {
        if (player != null) {
            if (hasHazmatSuit(player)) {
                System.out.println("NOT HAZARDOUS");
            } else {
                // Damage the player for breaking the block without a full hazmat suit.
                System.out.println("RADIOACTIVE");
                player.hurt(level.damageSources().generic(), radiationDamage);
            }
        }
    }
}
