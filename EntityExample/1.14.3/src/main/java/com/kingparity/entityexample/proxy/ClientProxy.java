package com.kingparity.entityexample.proxy;

import com.kingparity.entityexample.client.renderer.entity.ExampleEntityRenderer;
import com.kingparity.entityexample.entity.ExampleEntity;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy implements IProxy
{
    @Override
    public void clientRegistries()
    {
        //Register our ClientProxy game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        //register our entity renderer for our entity. We don't need to register our entity model
        RenderingRegistry.registerEntityRenderingHandler(ExampleEntity.class, ExampleEntityRenderer::new);
    }
    
    @Override
    public boolean isSinglePlayer()
    {
        return Minecraft.getInstance().isSingleplayer();
    }
    
    @Override
    public boolean isDedicatedServer()
    {
        return false;
    }
}
