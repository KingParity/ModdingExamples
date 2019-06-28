package com.kingparity.storageblockexample.init;

import com.kingparity.storageblockexample.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//We have this class just so we can register out itemblock. didn't add anything extra here
@Mod.EventBusSubscriber(modid = Reference.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleItems
{
    //The list of the items we want to register
    private static final List<Item> ITEMS = new LinkedList<>();
    
    public static void add(Item item)
    {
        ITEMS.add(item);
    }
    
    public static List<Item> getItems()
    {
        return Collections.unmodifiableList(ITEMS);
    }
    
    //Registers all values in the ITEMS list
    @SubscribeEvent
    public static void addItems(final RegistryEvent.Register<Item> event)
    {
        ITEMS.forEach(item -> event.getRegistry().register(item));
    }
}
