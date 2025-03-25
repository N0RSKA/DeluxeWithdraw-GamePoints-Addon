package dev.norska.dwaddon.ce.ndev;

import dev.norska.dwaddon.ce.ndev.handlers.CacheHandler;
import dev.norska.dwaddon.ce.ndev.handlers.ConfigHandler;
import lombok.Getter;

public class NorskaHandler {
	
	@Getter private CacheHandler cacheHandler = new CacheHandler();
	@Getter private ConfigHandler configurationHandler = new ConfigHandler();	

}
