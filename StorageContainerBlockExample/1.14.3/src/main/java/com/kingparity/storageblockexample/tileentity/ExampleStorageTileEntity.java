package com.kingparity.storageblockexample.tileentity;

import com.kingparity.storageblockexample.gui.container.ExampleStorageContainer;
import com.kingparity.storageblockexample.init.ExampleTileEntities;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class ExampleStorageTileEntity extends BaseStorageTileEntity
{
    public static int slotNum = 27;
    
    public ExampleStorageTileEntity()
    {
        super(ExampleTileEntities.EXAMPLE_STORAGE, "example_storage", slotNum);
    }
    
    @Override
    protected Container createMenu(int id, PlayerInventory inventory)
    {
        return new ExampleStorageContainer(id, inventory, this);
    }
}