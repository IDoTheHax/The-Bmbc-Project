package net.matty.bmbc.util;

import net.minecraftforge.energy.EnergyStorage;

public abstract class BmbcEnergyStorage extends EnergyStorage {
    public BmbcEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int extractedEnergy = super.extractEnergy(maxExtract, simulate);
        if(extractedEnergy != 0) {
            onEnergyChanged();
        }

        return extractedEnergy;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int receiveEnergy = super.receiveEnergy(maxReceive, simulate);
        if(receiveEnergy != 0) {
            onEnergyChanged();
        }

        return receiveEnergy;
    }

    public int setEnergy(int energy) {
        this.energy = energy;
        return energy;
    }

    public abstract void onEnergyChanged();
}
