package dev.norska.dwaddon.gp.ndev;

import dev.norska.dwaddon.gp.ndev.handlers.CacheHandler;
import dev.norska.dwaddon.gp.ndev.handlers.ConfigHandler;
import lombok.Getter;

public class NorskaHandler {
	
	@Getter private CacheHandler cacheHandler = new CacheHandler();
	@Getter private ConfigHandler configurationHandler = new ConfigHandler();	

}
