package net.matty.bmbc.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.energy.IEnergyStorage;

public class BatteryItem extends Item implements IEnergyStorage {
    private int energy;

    public BatteryItem(Properties properties) {
        super(properties);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int energyReceived = Math.min(getMaxEnergyStored() - energy, maxReceive);
        if (!simulate) {
            energy += energyReceived;
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int energyExtracted = Math.min(energy, maxExtract);
        if (!simulate) {
            energy -= energyExtracted;
        }
        return energyExtracted;
    }

    @Override
    public int getEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return 100000; // Example value, replace with your desired maximum energy storage
    }

    @Override
    public int getDamage(ItemStack stack) {
        return getMaxDamage() - energy;
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        energy = getMaxDamage() - damage;
    }

    @Override
    public boolean canExtract() {
        return true; // Replace with your condition for whether the item can extract energy
    }

    @Override
    public boolean canReceive() {
        return energy < getMaxEnergyStored(); // Only allow receiving energy if not already fully charged
    }
}