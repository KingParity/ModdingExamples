package com.kingparity.storageblockexample.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy implements IProxy
{
    @Override
    public void clientRegistries()
    {
        //Register our ClientProxy game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
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
