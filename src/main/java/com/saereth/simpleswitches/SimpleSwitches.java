package com.saereth.simpleswitches;

import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = SimpleSwitches.MODID, name = "Simple Switches", version="0.0.1")
public class SimpleSwitches {
	
	public static final String MODID = "simpleswitches";
	
	@Instance(MODID)
	public static SimpleSwitches instance;
	
	@SidedProxy(clientSide = "com.saereth.simpleswitches.client.ClientProxy", serverSide = "com.saereth.simpleswitches.CommonProxy")
	public static CommonProxy proxy;
	
	

	public static Configuration config;
	public static String[] switchTypes = {"iron_block", "emerald_block", "gold_block"};
	public static boolean enabled[] = new boolean[switchTypes.length];
	public static Block[] blockSwitch = new Block[switchTypes.length];
	
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		for (int i = 0; i < switchTypes.length; i++)
		{
			enabled[i] = config.get("switchTypes", switchTypes[i], true).getBoolean();
		}
		

	}
	

}
