package noadev.nessentials.Commands.Homes;

import noadev.nessentials.Handlers.ConfigHandler;
import noadev.nessentials.Handlers.LogHandler;
import noadev.nessentials.Handlers.MessageHandler;
import noadev.nessentials.PluginMain;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class Home implements CommandExecutor {

    private final PluginMain plugin;

    public Home(PluginMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            MessageHandler.Error.sendNoConsole();
            return true;
        }
        if(sender instanceof Player) {
            Player player = (Player) sender;
            boolean hasPermission = player.hasPermission("nessentials.homes.homeother");
            plugin.getLogger().info(args.length + "");
            if (args.length == 1) {
                // Player trying to teleport to their own home
                if(ConfigHandler.messageConfig.getString("db.homes." + player.getUniqueId() + "." + args[0]) != null) {
                    World homeWorld = plugin.getServer().getWorld(ConfigHandler.messageConfig.getString("db.homes." + player.getUniqueId() + "." + args[0] + ".world"));
                    double coordsX = Double.parseDouble(ConfigHandler.messageConfig.getString("db.homes." + player.getUniqueId() + "." + args[0] + ".x"));
                    double coordsY = Double.parseDouble(ConfigHandler.messageConfig.getString("db.homes." + player.getUniqueId() + "." + args[0] + ".y"));
                    double coordsZ = Double.parseDouble(ConfigHandler.messageConfig.getString("db.homes." + player.getUniqueId() + "." + args[0] + ".z"));

                    player.teleport(new Location(
                        homeWorld,
                        coordsX,
                        coordsY,
                        coordsZ));
                    MessageHandler.InGame.sendMessage(
                            player,
                        ConfigHandler.messageConfig.getString("messages.homes.tphome")
                            .replace("%home%", args[0])
                            .replace("%x%", ConfigHandler.messageConfig.getString("db.homes." + player.getUniqueId() + "." + args[0] + ".x"))
                            .replace("%y%", ConfigHandler.messageConfig.getString("db.homes." + player.getUniqueId() + "." + args[0] + ".y"))
                            .replace("%z%", ConfigHandler.messageConfig.getString("db.homes." + player.getUniqueId() + "." + args[0] + ".z"))
                            .replace("%world%", ConfigHandler.messageConfig.getString("db.homes." + player.getUniqueId() + "." + args[0] + ".world"))
                    );
                }
            } else if (args.length == 2 && player.hasPermission("nessentials.homes.homeother")) {
                // Admin trying to teleport to someone's home
            }
            return true;
        };
        return false;
    }
}
