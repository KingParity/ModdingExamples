package com.kingparity.storageblockexample;

import com.kingparity.storageblockexample.init.ExampleContainerTypes;
import com.kingparity.storageblockexample.proxy.ClientProxy;
import com.kingparity.storageblockexample.proxy.IProxy;
import com.kingparity.storageblockexample.proxy.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.ID)
public class StorageBlockExample
{
    //our proxy
    public static final IProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    
    public StorageBlockExample()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        
        //Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
        PROXY.setup();
    }
    
    private void clientRegistries(final FMLClientSetupEvent event)
    {
        ExampleContainerTypes.bindScreens(event);
        PROXY.clientRegistries();
    }
}
