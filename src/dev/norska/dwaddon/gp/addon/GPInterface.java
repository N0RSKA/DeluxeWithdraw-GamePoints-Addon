package dev.norska.dwaddon.gp.addon;

import java.util.List;

import org.bukkit.entity.Player;

import dev.norska.dw.api.DWAddonInterface;
import dev.norska.dwaddon.gp.GPAddon;
import su.nightexpress.gamepoints.api.GamePointsAPI;

public class GPInterface implements DWAddonInterface {

	@Override
	public void add(Player p, Double amount) {
		GamePointsAPI.getUserData(p).addPoints(amount.intValue());
	}

	@Override
	public void add(Player p, Integer amount) {
		GamePointsAPI.getUserData(p).addPoints(amount);
	}

	@Override
	public String adminCreator() {
		return GPAddon.getInstance().getNHandler().getCacheHandler().getCreatorForAdminItems();
	}

	@Override
	public int currencyFormat() {
		return GPAddon.getInstance().getNHandler().getCacheHandler().getCurrencyFormat();
	}

	@Override
	public String currencyString() {
		return GPAddon.getInstance().getNHandler().getCacheHandler().getCurrencyName();
	}

	@Override
	public Double getCurrent(Player p) {
		return (double) GamePointsAPI.getUserData(p).getBalance();
	}

	@Override
	public Boolean has(Player p, Double amount) {
		return GamePointsAPI.getUserData(p).getBalance() >= amount;
	}

	@Override
	public Boolean has(Player p, Integer amount) {
		return GamePointsAPI.getUserData(p).getBalance() >= amount;
	}

	@Override
	public String layout() {
		return GPAddon.getInstance().getNHandler().getCacheHandler().getItemLayout();
	}

	@Override
	public Double maxWithdraw() {
		return GPAddon.getInstance().getNHandler().getCacheHandler().getMaxWithdraw();
	}

	@Override
	public Double minWithdraw() {
		return GPAddon.getInstance().getNHandler().getCacheHandler().getMinWithdraw();
	}

	@Override
	public void set(Player p, Double arg1) {
		
		
	}

	@Override
	public void set(Player p, Integer amount) {
		
	}

	@Override
	public void take(Player p, Double amount) {
		GamePointsAPI.getUserData(p).takePoints(amount.intValue());
	}

	@Override
	public void take(Player p, Integer amount) {
		GamePointsAPI.getUserData(p).takePoints(amount);
	}

	@Override
	public List<String> withdrawCommands() {
		return GPAddon.getInstance().getNHandler().getCacheHandler().getCommands();
	}

	@Override
	public void reloadConfiguration() {
		GPAddon.getInstance().generateFiles();
		GPAddon.getInstance().cache();
	}

	@Override
	public Boolean useInt() {
		return true;
	}

}
