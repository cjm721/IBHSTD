package com.cjm721.overloaded.common.block.tile.infinity;

import com.cjm721.overloaded.common.storage.energy.LongEnergyStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nonnull;

import static com.cjm721.overloaded.common.util.CapabilityHyperEnergy.HYPER_ENERGY_HANDLER;
import static net.minecraftforge.energy.CapabilityEnergy.ENERGY;


/**
 * Created by CJ on 4/8/2017.
 */
public class TileInfiniteCapacitor extends TileEntity {

    @Nonnull
    private LongEnergyStorage energyStorage;

    public TileInfiniteCapacitor() {
        energyStorage = new LongEnergyStorage();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        energyStorage.writeToNBT(compound);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        energyStorage.readFromNBT(compound);
    }

    public LongEnergyStorage getStorage() {
        return energyStorage;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if(capability == ENERGY || capability == HYPER_ENERGY_HANDLER) {
            return (T) energyStorage;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if(capability == ENERGY || capability == HYPER_ENERGY_HANDLER) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }
}