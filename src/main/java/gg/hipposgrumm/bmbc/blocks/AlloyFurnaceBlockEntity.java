package gg.hipposgrumm.bmbc.blocks;

import gg.hipposgrumm.bmbc.BMBC_Main;
import gg.hipposgrumm.bmbc.gui.AlloyFurnaceMenu;
import gg.hipposgrumm.bmbc.recipes.AlloySmeltingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class AlloyFurnaceBlockEntity extends AbstractFurnaceBlockEntity { // TODO: This needs more.
    private final ContainerData data;
    private final int tier;
    protected NonNullList<ItemStack> items;
    private int progress = 0;
    private int maxProgress = 78;
    public AlloyFurnaceBlockEntity(BlockPos pos, BlockState block) {
        super(BMBC_Main.ALLOY_FURNACE_BE.get(), pos, block, AlloySmeltingRecipe.Type.INSTANCE);
        this.tier = 1;
        items = NonNullList.withSize(3+tier, ItemStack.EMPTY);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> AlloyFurnaceBlockEntity.this.progress;
                    case 1 -> AlloyFurnaceBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> AlloyFurnaceBlockEntity.this.progress = value;
                    case 1 -> AlloyFurnaceBlockEntity.this.maxProgress = value;
                 }
             }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDefaultName() {
        return Component.translatable("container.bmbc.alloy_furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new AlloyFurnaceMenu(id, inventory, this, this.data);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        dataAccess.set(1, this.getBurnDuration(items.get(0)));
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return new int[]{2,1};
        } else {
            if (side == Direction.UP) {
                int[] slotList = new int[]{0};
                for (int i=3;i<=tier;i++) {
                    ArrayUtils.add(slotList, i);
                }
                return slotList;
            } else {
                return new int[]{1};
            }
        }
    }
}
