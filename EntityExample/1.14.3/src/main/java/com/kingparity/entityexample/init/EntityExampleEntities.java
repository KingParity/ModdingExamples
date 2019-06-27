package com.kingparity.entityexample.init;

import com.kingparity.entityexample.Reference;
import com.kingparity.entityexample.entity.ExampleEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityExampleEntities
{
    //An instance of our entity as an EntityType
    public static EntityType<ExampleEntity> EXAMPLE_ENTITY;
    
    //The list of the entities we want to register as EntityType
    private static final List<EntityType<?>> ENTITY_TYPES = new LinkedList<>();
    
    public static <T extends Entity> void add(EntityType<T> type)
    {
        ENTITY_TYPES.add(type);
    }
    
    public static List<EntityType<?>> getEntityTypes()
    {
        return Collections.unmodifiableList(ENTITY_TYPES);
    }
    
    //Instantiate our entity as an EntityType (we can have multiple in here)
    static
    {
        EXAMPLE_ENTITY = register(ExampleEntity::new, EntityClassification.CREATURE, "example_entity", 0.6F, 0.85F);
    }
    
    //Registers all values in the ENTITY_TYPES list
    @SubscribeEvent
    public static void addEntities(final RegistryEvent.Register<EntityType<?>> event)
    {
        ENTITY_TYPES.forEach(entityType -> event.getRegistry().register(entityType));
    }
    
    /**
     * @param factory entity instance (must extend entity)
     * @param classification entity classification (MONSTER, CREATURE, AMBIENT, WATER_CREATURE, MISC)
     * @param name the name of the entity
     * @param width the bounding box width of the entity
     * @param height the bounding box height of the entity
     * @param <T> the entity java file (CowEntity, SheepEntity, etc.)
     * @return a new entity type registered with the parameters given
     */
    private static <T extends Entity> EntityType<T> register(EntityType.IFactory<T> factory, EntityClassification classification, String name, float width, float height)
    {
        return register(factory, classification, name, 256, 1, true, width, height);
    }
    
    /**
     * @param factory entity instance (must extend entity)
     * @param classification entity classification (MONSTER, CREATURE, AMBIENT, WATER_CREATURE, MISC)
     * @param name the name of the entity
     * @param range the range of the entity
     * @param updateFrequency the update frequency of the entity
     * @param sendVelocityUpdates does the entity send velocity updates
     * @param width the bounding box width of the entity
     * @param height the bounding box height of the entity
     * @param <T> the entity java file (CowEntity, SheepEntity, etc.)
     * @return a new entity type registered with the parameters given
     */
    private static <T extends Entity> EntityType<T> register(EntityType.IFactory<T> factory, EntityClassification classification, String name, int range, int updateFrequency, boolean sendVelocityUpdates, float width, float height)
    {
        EntityType<T> type = EntityType.Builder.create(factory, classification).size(width, height).setTrackingRange(range).setUpdateInterval(updateFrequency).setShouldReceiveVelocityUpdates(sendVelocityUpdates).build(Reference.ID + ":" + name);
        type.setRegistryName(new ResourceLocation(Reference.ID, name));
        //Adds the created entity type to an ArrayList so it can be registered when forge tells it to register
        ENTITY_TYPES.add(type);
        return type;
    }
}