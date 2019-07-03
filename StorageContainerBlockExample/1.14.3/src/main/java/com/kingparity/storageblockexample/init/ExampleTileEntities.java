package com.kingparity.storageblockexample.init;

import com.kingparity.storageblockexample.Reference;
import com.kingparity.storageblockexample.tileentity.ExampleStorageTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Reference.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleTileEntities
{
    //An instance of our tile entity as a TileEntityType
    @ObjectHolder(Reference.ID + ":example_storage_tile_entity")
    public static final TileEntityType<?> EXAMPLE_STORAGE_TILE_ENTITY = null;
    
    //The list of the tile entities we want to register as TileEntityType
    private static final List<TileEntityType<?>> TILE_ENTITY_TYPES = new LinkedList<>();
    
    public static <T extends TileEntity> void add(TileEntityType<T> type)
    {
        TILE_ENTITY_TYPES.add(type);
    }
    
    public static List<TileEntityType<?>> getTileEntityTypes()
    {
        return Collections.unmodifiableList(TILE_ENTITY_TYPES);
    }
    
    //Instantiate our tile entity as a TileEntityType (we can have multiple in here)
    static
    {
        register("example_storage_tile_entity", ExampleStorageTileEntity::new, ExampleBlocks.EXAMPLE_STORAGE_BLOCK);
    }
    
    //Registers all values in the TILE_ENTITY_TYPES list
    @SubscribeEvent
    public static void addTileEntityTypes(final RegistryEvent.Register<TileEntityType<?>> event)
    {
        TILE_ENTITY_TYPES.forEach(type -> event.getRegistry().register(type));
    }
    
    /**
     * @param name the name of the tile entity
     * @param factory tile entity instance (must extend TileEntity)
     * @param validBlocks a list of the valid blocks this TileEntity can be for
     * @param <T> the tile entity java file (FurnaceTileEntity, ChestTileEntity, etc.)
     * @return a new tile entity type registered with the parameters given
     */
    private static <T extends TileEntity> void register(String name, Supplier<T> factory, Block... validBlocks)
    {
        TileEntityType<T> type = TileEntityType.Builder.create(factory, validBlocks).build(null);
        type.setRegistryName(new ResourceLocation(Reference.ID, name));
        TILE_ENTITY_TYPES.add(type);
    }
}