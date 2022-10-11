package noadev.nessentials.Handlers;

import org.bukkit.entity.Player;

import noadev.nessentials.PluginMain;


public class PermissionHandler {
    private static PluginMain plugin;

    public PermissionHandler(PluginMain plugin) {
        PermissionHandler.plugin = plugin;
    }

    public static class Read {
        public static boolean hasPerm(Player player, String permission) {
            return player.hasPermission(permission);
        }
    }

    public static class Write {

    };
}
