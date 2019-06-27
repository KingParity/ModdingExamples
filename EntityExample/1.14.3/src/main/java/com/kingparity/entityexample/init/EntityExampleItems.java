package com.kingparity.entityexample.init;

import com.kingparity.entityexample.Reference;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityExampleItems
{
    //you can create a new item properties while instantiating your item, but I have it here to make the code cleaner
    public static Item.Properties tabMisc = new Item.Properties().group(ItemGroup.MISC);
    
    //An instance of our spawn egg item
    public static Item EXAMPLE_ENTITY_SPAWN_EGG;
    
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
    
    //Instantiate our item (we can have multiple in here)
    static
    {
        EXAMPLE_ENTITY_SPAWN_EGG = registerSpawnEgg("example_entity_spawn_egg", EntityExampleEntities.EXAMPLE_ENTITY, 14144467, 13545366, tabMisc);
    }
    
    //Registers all values in the ITEMS list
    @SubscribeEvent
    public static void addItems(final RegistryEvent.Register<Item> event)
    {
        ITEMS.forEach(item -> event.getRegistry().register(item));
    }
    
    /**
     * @param name the name of the item
     * @param builder the item properties
     * @return a new item with the parameters given
     */
    private static Item register(String name, Item.Properties builder)
    {
        return register(name, new Item(builder));
    }
    
    /**
     * @param name the name of the item
     * @param entity the entity the spawn egg will spawn
     * @param primary the primary color of the spawn egg
     * @param secondary the secondary color of the spawn egg
     * @param builder the item properties
     * @return a new item with the parameters given
     */
    private static Item registerSpawnEgg(String name, EntityType entity, int primary, int secondary, Item.Properties builder)
    {
        return register(name, new SpawnEggItem(entity, primary, secondary, builder));
    }
    
    /**
     * @param name the name of the item
     * @param item an assigned item instance (ex: new Item())
     * @return a new item with the parameters given
     */
    private static Item register(String name, Item item)
    {
        item.setRegistryName(new ResourceLocation(Reference.ID, name));
        ITEMS.add(item);
        return item;
    }
}
