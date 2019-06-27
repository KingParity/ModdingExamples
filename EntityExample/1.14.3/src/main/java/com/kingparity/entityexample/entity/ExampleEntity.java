package com.kingparity.entityexample.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.world.World;

//We extend CowEntity just as an example
public class ExampleEntity extends CowEntity
{
    /**
     * @param type the entity type this entity is
     * @param worldIn the world of this entity
     */
    public ExampleEntity(EntityType<? extends ExampleEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
