package dev.norska.dwaddon.ce.ndev.handlers;

import java.io.File;
import java.io.IOException;

import dev.norska.dwaddon.ce.CEAddon;
import dev.norska.dwaddon.ce.config.CommentedConfiguration;
import lombok.Getter;

public class ConfigHandler {
	
	@Getter private CommentedConfiguration configFile;
	
	private File path = null;
	
	public void generateFiles(CEAddon main) throws IOException {
		
		if(path == null) path = new File("plugins/DeluxeWithdraw/addons");
		if(!path.exists()) path.mkdirs();
		
		File file = new File(path, "addon-coinsengine.yml");

        if(!file.exists()) file.createNewFile();

        configFile = CommentedConfiguration.loadConfiguration(file);
        try {
			configFile.syncWithConfig(file, main.getResource("addon-coinsengine.yml"), "no");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
