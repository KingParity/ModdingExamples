package com.kingparity.storageblockexample.block;

import com.kingparity.storageblockexample.init.ExampleTileEntities;
import com.kingparity.storageblockexample.tileentity.ExampleStorageTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ExampleStorageBlock extends Block
{
    public ExampleStorageBlock(Block.Properties properties)
    {
        super(properties);
    }
    
    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit)
    {
        if(!world.isRemote)
        {
            NetworkHooks.openGui((ServerPlayerEntity)player, (ExampleStorageTileEntity)world.getTileEntity(pos), pos);
        }
        return true;
    }
    
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return ExampleTileEntities.EXAMPLE_STORAGE.create();
    }
    
    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }
}
