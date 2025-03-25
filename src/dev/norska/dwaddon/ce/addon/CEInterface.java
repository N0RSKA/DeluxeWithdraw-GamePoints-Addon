package dev.norska.dwaddon.ce.addon;

import java.util.List;

import org.bukkit.entity.Player;

import dev.norska.dw.api.DWAddonInterface;
import dev.norska.dwaddon.ce.CEAddon;
import su.nightexpress.coinsengine.api.CoinsEngineAPI;
import su.nightexpress.coinsengine.api.currency.Currency;

public class CEInterface implements DWAddonInterface {

	Currency currency = CEAddon.getInstance().getCurrency();

	@Override
	public void add(Player p, Double amount) {
		CoinsEngineAPI.addBalance(p, currency, amount);
	}

	@Override
	public void add(Player p, Integer amount) {
		CoinsEngineAPI.addBalance(p, currency, amount);
	}

	@Override
	public String adminCreator() {
		return CEAddon.getInstance().getNHandler().getCacheHandler().getCreatorForAdminItems();
	}

	@Override
	public int currencyFormat() {
		return CEAddon.getInstance().getNHandler().getCacheHandler().getCurrencyFormat();
	}

	@Override
	public String currencyString() {
		return CEAddon.getInstance().getNHandler().getCacheHandler().getCurrencyName();
	}

	@Override
	public Double getCurrent(Player p) {

		return CoinsEngineAPI.getBalance(p, currency);

	}

	@Override
	public Boolean has(Player p, Double amount) {
		return CoinsEngineAPI.getBalance(p, currency) >= amount;
	}

	@Override
	public Boolean has(Player p, Integer amount) {
		return CoinsEngineAPI.getBalance(p, currency) >= amount;
	}

	@Override
	public String layout() {
		return CEAddon.getInstance().getNHandler().getCacheHandler().getItemLayout();
	}

	@Override
	public Double maxWithdraw() {
		return CEAddon.getInstance().getNHandler().getCacheHandler().getMaxWithdraw();
	}

	@Override
	public Double minWithdraw() {
		return CEAddon.getInstance().getNHandler().getCacheHandler().getMinWithdraw();
	}

	@Override
	public void set(Player p, Double arg1) {
		
		
	}

	@Override
	public void set(Player p, Integer amount) {
		
	}

	@Override
	public void take(Player p, Double amount) {
		CoinsEngineAPI.removeBalance(p, currency, amount);
	}

	@Override
	public void take(Player p, Integer amount) {
		CoinsEngineAPI.removeBalance(p, currency, amount);
	}

	@Override
	public List<String> withdrawCommands() {
		return CEAddon.getInstance().getNHandler().getCacheHandler().getCommands();
	}

	@Override
	public void reloadConfiguration() {
		CEAddon.getInstance().generateFiles();
		CEAddon.getInstance().cache();
	}

	@Override
	public Boolean useInt() {
		return true;
	}

}
