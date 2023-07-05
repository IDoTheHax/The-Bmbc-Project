package gg.hipposgrumm.bmbc.gui;

import gg.hipposgrumm.bmbc.BMBC_Main;
import gg.hipposgrumm.bmbc.recipes.AlloySmeltingRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class AlloyFurnaceMenu extends AbstractContainerMenu {
    private Level level;
    private BlockEntity blockEntity;

    public AlloyFurnaceMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(7));
    }

    public AlloyFurnaceMenu(int id, Inventory inventory, BlockEntity blockEntity, ContainerData data) {
        super(BMBC_Main.ALLOY_FURNACE_MENU.get(), id);
        this.level = inventory.player.level;
        this.blockEntity = blockEntity;

        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(inventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 144));
        }

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 12, 15));
            this.addSlot(new SlotItemHandler(handler, 1, 86, 15));
            this.addSlot(new SlotItemHandler(handler, 2, 86, 60));
        });
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        // TODO: Make this work. And while you're at it add the other slots.
        Slot sourceSlot = slots.get(index);
        return sourceSlot.hasItem()?sourceSlot.getItem():ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, BMBC_Main.ALLOY_FURNACE.get());
    }
}
