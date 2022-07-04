package noadev.nessentials.Handlers;

import noadev.nessentials.PluginMain;
import org.bukkit.entity.Player;

public class HomeHandler {
    private static PluginMain plugin;

    public HomeHandler(PluginMain plugin) {
        HomeHandler.plugin = plugin;
    }

    public static void setHome(Player player, String home, String x, String y, String z, String world) {
        ConfigHandler.databaseConfig
                .set("db.homes." + player.getUniqueId() + "." + home + ".x", x);
        ConfigHandler.databaseConfig
                .set("db.homes." + player.getUniqueId() + "." + home + ".y", y);
        ConfigHandler.databaseConfig
                .set("db.homes." + player.getUniqueId() + "." + home + ".z", z);
        ConfigHandler.databaseConfig
                .set("db.homes." + player.getUniqueId() + "." + home + ".world", world);
        ConfigHandler.databaseConfig
                .set("db.homes." + player.getUniqueId() + ".number", ConfigHandler.databaseConfig.getInt("db.homes." + home + ".number") + 1);
        ConfigHandler.databaseConfig.save();
    }

    public static void deleteHome(Player player, String home) {
        ConfigHandler.databaseConfig.set("db.homes." + player.getUniqueId() + "." + home, null);
        ConfigHandler.databaseConfig.save();
    }
}
