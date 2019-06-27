package com.kingparity.entityexample.client.renderer.entity.model;

import com.kingparity.entityexample.entity.ExampleEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

//Lets just create and use a wolf model since the cow model isn't a good example on how to create a custom model
public class ExampleEntityModel<T extends ExampleEntity> extends EntityModel<T>
{
    //Create the model variables
    private final RendererModel head;
    private final RendererModel body;
    private final RendererModel legBackRight;
    private final RendererModel legBackLeft;
    private final RendererModel legFrontRight;
    private final RendererModel legFrontLeft;
    private final RendererModel tail;
    private final RendererModel mane;
    
    /**
     * Where you create the models
     */
    public ExampleEntityModel()
    {
        //textureWidth is 64 by default, just showing you can change it
        this.textureWidth = 64;
        //textureHeight is 32 by default, just showing you can change it
        this.textureHeight = 32;
        this.head = new RendererModel(this, 0, 0);
        this.head.addBox(-2.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F);
        this.head.setRotationPoint(-1.0F, 13.5F, -7.0F);
        this.body = new RendererModel(this, 18, 14);
        this.body.addBox(-3.0F, -2.0F, -3.0F, 6, 9, 6, 0.0F);
        this.body.setRotationPoint(0.0F, 14.0F, 2.0F);
        this.mane = new RendererModel(this, 21, 0);
        this.mane.addBox(-3.0F, -3.0F, -3.0F, 8, 6, 7, 0.0F);
        this.mane.setRotationPoint(-1.0F, 14.0F, 2.0F);
        this.legBackRight = new RendererModel(this, 0, 18);
        this.legBackRight.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.legBackRight.setRotationPoint(-2.5F, 16.0F, 7.0F);
        this.legBackLeft = new RendererModel(this, 0, 18);
        this.legBackLeft.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.legBackLeft.setRotationPoint(0.5F, 16.0F, 7.0F);
        this.legFrontRight = new RendererModel(this, 0, 18);
        this.legFrontRight.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.legFrontRight.setRotationPoint(-2.5F, 16.0F, -4.0F);
        this.legFrontLeft = new RendererModel(this, 0, 18);
        this.legFrontLeft.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.legFrontLeft.setRotationPoint(0.5F, 16.0F, -4.0F);
        this.tail = new RendererModel(this, 9, 18);
        this.tail.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.tail.setRotationPoint(-1.0F, 12.0F, 8.0F);
        this.head.setTextureOffset(16, 14).addBox(-2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
        this.head.setTextureOffset(16, 14).addBox(2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
        this.head.setTextureOffset(0, 10).addBox(-0.5F, 0.0F, -5.0F, 3, 3, 4, 0.0F);
    }
    
    /**
     * Where you render the entity models
     */
    @Override
    public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        //Call the super function
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        //We need to do this
        this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        
        //Render the parts
        this.head.renderWithRotation(scale);
        this.body.render(scale);
        this.legBackRight.render(scale);
        this.legBackLeft.render(scale);
        this.legFrontRight.render(scale);
        this.legFrontLeft.render(scale);
        this.tail.renderWithRotation(scale);
        this.mane.render(scale);
    }
    
    /**
     * Where you set the living animations
     */
    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick)
    {
        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
    }
    
    /**
     * Where you set the rotation angles
     */
    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
    {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
    }
    
    /**
     * Where you set the model attributes
     */
    @Override
    public void setModelAttributes(EntityModel<T> model)
    {
        super.setModelAttributes(model);
    }
}
