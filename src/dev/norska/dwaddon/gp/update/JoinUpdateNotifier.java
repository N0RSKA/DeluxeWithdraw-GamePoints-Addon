package dev.norska.dwaddon.gp.update;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import dev.norska.dwaddon.gp.GPAddon;

public class JoinUpdateNotifier implements Listener{
	
	private GPAddon main;
	public JoinUpdateNotifier(GPAddon main) {
		this.main = main;
	}
	
	@EventHandler
	public void onJoinUpdate(PlayerJoinEvent e) {	
		
		if(!main.getNHandler().getUpdateHandler().getNotifyForUpdates()) return;
		
		Player p = e.getPlayer();
		
		if(p.isOp() && main.getNHandler().getUpdateHandler().getUpdateAvailable()) {
			new BukkitRunnable() {
				@Override
				public void run() { main.getNHandler().getUpdateHandler().sendUpdateMessage(main, p, true); }
			}.runTaskLater(main, 60);
		}
	}

}
