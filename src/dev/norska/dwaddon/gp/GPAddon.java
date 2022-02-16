package dev.norska.dwaddon.gp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.iridium.iridiumcolorapi.IridiumColorAPI;

import dev.norska.dw.DeluxeWithdraw;
import dev.norska.dwaddon.gp.addon.GPInterface;
import dev.norska.dwaddon.gp.ndev.NorskaHandler;
import lombok.Getter;

public class GPAddon extends JavaPlugin {
	
	private static GPAddon instance;
	public GPAddon() { instance = this; }
	public static GPAddon getInstance() { return instance; }
	
	@Getter private NorskaHandler nHandler = new NorskaHandler();
	
	public String prefix;
	
	public void onEnable() {
		
		prefix = Bukkit.getVersion().contains("1.16") || Bukkit.getVersion().contains("1.17") || Bukkit.getVersion().contains("1.18") ? 
				IridiumColorAPI.process("§8[<GRADIENT:FFE818>&lDeluxeWithdraw SuperMobcoins Addon</GRADIENT:B7FF1D>§8]§r") :
				IridiumColorAPI.process("&8[&e&lDeluxeWithdraw SuperMobcoins Addon&8]&r");
		
		Bukkit.getConsoleSender().sendMessage(" ");
    	Bukkit.getConsoleSender().sendMessage(prefix + " §7" + getDescription().getVersion() + "§f, a §efreemium §faddon by §7Norska §f- §7Thanks for using!");
		Bukkit.getConsoleSender().sendMessage(" ");
		
		getNHandler().getConfigurationHandler().generateFiles(this);
		getNHandler().getCacheHandler().cache(this);
		
		try {
			DeluxeWithdraw.getInstance().getAddonProvider().registerNewProvider("GAMEPOINTS", new GPInterface());
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
