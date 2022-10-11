package noadev.nessentials;

import noadev.nessentials.Commands.Gamemode.Adventure;
import noadev.nessentials.Commands.Gamemode.Creative;
import noadev.nessentials.Commands.Gamemode.Spectator;
import noadev.nessentials.Commands.Gamemode.Survival;
import noadev.nessentials.Commands.Homes.DelHome;
import noadev.nessentials.Commands.Homes.Home;
import noadev.nessentials.Commands.Homes.SetHome;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	@Override
	public void onEnable() {
		instance = this;

		this.saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
		try {
			getInstance().getLogger().info("Hello :D");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Objects.requireNonNull(this.getCommand("gma")).setExecutor(new Adventure(this));
		Objects.requireNonNull(this.getCommand("gmc")).setExecutor(new Creative(this));
		Objects.requireNonNull(this.getCommand("gmsp")).setExecutor(new Spectator(this));
		Objects.requireNonNull(this.getCommand("gms")).setExecutor(new Survival(this));

		Objects.requireNonNull(this.getCommand("sethome")).setExecutor(new SetHome(this));
		Objects.requireNonNull(this.getCommand("home")).setExecutor(new Home(this));
		Objects.requireNonNull(this.getCommand("delhome")).setExecutor(new DelHome(this));
		getInstance().getLogger().info("Registered CommandExecutors");

		new noadev.nessentials.Handlers.ConfigHandler(this);
		getInstance().getLogger().info("Loaded ConfigHandler");
		new noadev.nessentials.Handlers.HomeHandler(this);
		getInstance().getLogger().info("Loaded HomeHandler");
		new noadev.nessentials.Handlers.LogHandler(this);
		getInstance().getLogger().info("Loaded LogHandler");
		new noadev.nessentials.Handlers.MessageHandler(this);
		getInstance().getLogger().info("Loaded MessageHandler");
		new noadev.nessentials.Handlers.PermissionHandler(this);
		getInstance().getLogger().info("Loaded PermissionHandler");

	}

	@Override
	public void onDisable() {
		try {
			getInstance().getLogger().info("Goodbye D:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}
}
