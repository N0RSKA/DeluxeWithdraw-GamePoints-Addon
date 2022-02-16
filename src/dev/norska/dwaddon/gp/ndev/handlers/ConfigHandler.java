package dev.norska.dwaddon.gp.ndev.handlers;

import java.io.File;
import java.io.IOException;

import dev.norska.dwaddon.gp.GPAddon;
import dev.norska.dwaddon.gp.config.CommentedConfiguration;
import lombok.Getter;

public class ConfigHandler {
	
	@Getter private CommentedConfiguration configFile;
	
	public void generateFiles(GPAddon main) {
		File file = new File(main.getDataFolder(), "config.yml");

        if(!file.exists()) main.saveResource("config.yml", false);

        configFile = CommentedConfiguration.loadConfiguration(file);
        try {
			configFile.syncWithConfig(file, main.getResource("config.yml"), "no");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
