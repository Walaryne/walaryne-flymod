package com.walaryne.flymod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = FlyMod.MODID, version = FlyMod.VERSION)
public class FlyMod {
	
    public static final String MODID = "flymod";
    public static final String VERSION = "1.0";
    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("HELLO MINECRAFT!");
    }
    @EventHandler
    public static void init(FMLServerStartingEvent event) {
    	event.registerServerCommand(new FlyCommand());
    }
}
