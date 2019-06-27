package com.kingparity.entityexample.client.renderer.entity;

import com.kingparity.entityexample.client.renderer.entity.model.ExampleEntityModel;
import com.kingparity.entityexample.entity.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

//the super requires the entity this renderer is for and the model this renderer is for.
//our model asks for our entity, so we give it our entity
public class ExampleEntityRenderer extends MobRenderer<ExampleEntity, ExampleEntityModel<ExampleEntity>>
{
    //Our entity textures
    //the path format is the same as 1.12.2 and 1.13.2
    private static final ResourceLocation TEXTURES = new ResourceLocation("textures/entity/wolf/wolf.png");
    
    /**
     * @param manager the render manager for the entity
     */
    public ExampleEntityRenderer(EntityRendererManager manager)
    {
        //we give the super the manager that was given to us, our entity model, and the entity shadow
        super(manager, new ExampleEntityModel<>(), 0.7F);
    }
    
    /**
     * @param entity the entity this renderer is for
     * @return the entity texture
     */
    @Override
    protected ResourceLocation getEntityTexture(ExampleEntity entity)
    {
        return TEXTURES;
    }
}