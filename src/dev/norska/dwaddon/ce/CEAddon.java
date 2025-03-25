package dev.norska.dwaddon.ce;

import java.io.IOException;

import dev.norska.niridiumcolorapi.IridiumColorAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.norska.dw.DeluxeWithdraw;
import dev.norska.dwaddon.ce.addon.CEInterface;
import dev.norska.dwaddon.ce.ndev.NorskaHandler;
import lombok.Getter;
import su.nightexpress.coinsengine.api.CoinsEngineAPI;
import su.nightexpress.coinsengine.api.currency.Currency;

public class CEAddon extends JavaPlugin {
	
	private static CEAddon instance;
	public CEAddon() { instance = this; }
	public static CEAddon getInstance() { return instance; }
	
	@Getter private NorskaHandler nHandler = new NorskaHandler();

	@Getter private Currency currency;

	public String prefix;
	
	public void onEnable() {
		
		prefix = Bukkit.getVersion().contains("1.16") || Bukkit.getVersion().contains("1.17") || Bukkit.getVersion().contains("1.18") || Bukkit.getVersion().contains("1.19") || Bukkit.getVersion().contains("1.20") ?
				IridiumColorAPI.process("§8[<GRADIENT:FFE818>&lDW Addon (CoinsEngine)</GRADIENT:B7FF1D>§8]§r") :
				IridiumColorAPI.process("&8[&e&lDW Addon (CoinsEngine)&8]&r");
		
		Bukkit.getConsoleSender().sendMessage(" ");
    	Bukkit.getConsoleSender().sendMessage(prefix + " §7" + getDescription().getVersion() + "§f, a §afree §faddon by §7Norska §f- §7Thanks for using!");
		Bukkit.getConsoleSender().sendMessage(" ");
		
		if (Bukkit.getServer().getPluginManager().getPlugin("DeluxeWithdraw") == null) {
			Bukkit.getConsoleSender().sendMessage(prefix + " §fCould not find DeluxeWithdraw, disabling plugin.");
			Bukkit.getConsoleSender().sendMessage(prefix + " §fPurchase the resource from here: §chttps://norska.dev/r/bbb/dw/§f, §chttps://norska.dev/r/spigot/dw/§f, §chttps://norska.dev/r/polymart/dw/");
			getServer().getPluginManager().disablePlugin(this);
			return;
		} 

		generateFiles();
		cache();

		String currencyS = getNHandler().getConfigurationHandler().getConfigFile().getString("settings.coinsEngineCurrency");
		currency = CoinsEngineAPI.getCurrencyManager().getCurrency(currencyS);

		if(currency == null) {
			Bukkit.getConsoleSender().sendMessage(prefix + " §fCould not find currency '" + currencyS + "' configured in CoinsEngine, disabling plugin.");
			getServer().getPluginManager().disablePlugin(this);
		}

		try {
			DeluxeWithdraw.getInstance().getAddonProvider().registerNewProvider("COINSENGINE", new CEInterface());
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void generateFiles() {
		try {
			getNHandler().getConfigurationHandler().generateFiles(this);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void cache() {
		getNHandler().getCacheHandler().cache(this);
	}
	
}
