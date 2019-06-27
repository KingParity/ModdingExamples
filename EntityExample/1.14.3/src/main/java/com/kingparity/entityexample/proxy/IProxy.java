package com.kingparity.entityexample.proxy;

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
