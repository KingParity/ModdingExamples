package com.kingparity.storageblockexample.init;

import com.kingparity.storageblockexample.Reference;
import com.kingparity.storageblockexample.block.ExampleStorageBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleBlocks
{
    //you can create a new block properties while instantiating your block, but I have it here to make the code cleaner
    private static final Block.Properties EXAMPLE_STORAGE_BLOCK_PROPERTIES = Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 10.0F);
    
    //you can create a new item properties while instantiating your BlockItem, but I have it here to make the code cleaner
    public static Item.Properties tabMisc = new Item.Properties().group(ItemGroup.MISC);
    
    //An instance of our storage block
    @ObjectHolder(Reference.ID + ":example_storage_block")
    public static final Block EXAMPLE_STORAGE_BLOCK = null;
    
    //The list of the blocks we want to register
    private static final List<Block> BLOCKS = new LinkedList<>();
    
    public static void add(Block block)
    {
        BLOCKS.add(block);
    }
    
    public static List<Block> getBlocks()
    {
        return Collections.unmodifiableList(BLOCKS);
    }
    
    //Instantiate our block (we can have multiple in here)
    static
    {
        register("example_storage_block", new ExampleStorageBlock(EXAMPLE_STORAGE_BLOCK_PROPERTIES), tabMisc);
    }
    
    //Registers all values in the BLOCKS list
    @SubscribeEvent
    public static void addBlocks(final RegistryEvent.Register<Block> event)
    {
        BLOCKS.forEach(block -> event.getRegistry().register(block));
    }
    
    private static Block register(String name, Block.Properties properties, Item.Properties itemBuilder)
    {
        Block block = new Block(properties);
        return register(name, block, new BlockItem(block, itemBuilder));
    }
    
    private static Block register(String name, Block block, Item.Properties itemBuilder)
    {
        return register(name, block, new BlockItem(block, itemBuilder));
    }
    
    private static Block register(String name, Block block, BlockItem itemBlock)
    {
        block.setRegistryName(new ResourceLocation(Reference.ID, name));
        if(block.getRegistryName() != null)
        {
            itemBlock.setRegistryName(block.getRegistryName());
        }
        else
        {
            throw new NullPointerException("Block registry name null!");
        }
        BLOCKS.add(block);
        ExampleItems.add(itemBlock);
        return block;
    }
}
