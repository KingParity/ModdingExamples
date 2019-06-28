package com.kingparity.storageblockexample.proxy;

public interface IProxy
{
    default void setup()
    {
    }
    
    default void clientRegistries()
    {
    }
    
    boolean isSinglePlayer();
    
    boolean isDedicatedServer();
}
