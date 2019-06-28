package com.kingparity.storageblockexample.proxy;

import net.minecraftforge.common.MinecraftForge;

public class ServerProxy implements IProxy
{
    @Override
    public void clientRegistries()
    {
        //Register our ServerProxy game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @Override
    public boolean isSinglePlayer()
    {
        return false;
    }
    
    @Override
    public boolean isDedicatedServer()
    {
        return true;
    }
}
