package noadev.nessentials.Commands.Homes;

import noadev.nessentials.Handlers.HomeHandler;
import noadev.nessentials.Handlers.MessageHandler;
import noadev.nessentials.PluginMain;
import noadev.nessentials.Handlers.ConfigHandler;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SetHome implements CommandExecutor {

    private final PluginMain plugin;

    public SetHome(PluginMain plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof ConsoleCommandSender) {
            if(args.length == 6) {
                Player homePlayer = Bukkit.getPlayer(args[0]);
                if(homePlayer != null) {
                    HomeHandler.setHome(homePlayer, args[1], args[2], args[3], args[4], args[5]);

                    sender.sendMessage(ConfigHandler.messageConfig.getString("messages.homes.setother")
                            .replace("%player%", args[0])
                            .replace("%home%", args[1])
                            .replace("%x%", args[2])
                            .replace("%y%", args[3])
                            .replace("%z%", args[4])
                            .replace("%world%", args[5]));

                    return true;
                } else {
                    sender.sendMessage(ConfigHandler.messageConfig.getString("messages.homes.doesntexist").replace("%error%", "player"));
                }
            } else {
                sender.sendMessage(ConfigHandler.messageConfig.getString("messages.error.args").replace("%usage%", "/sethome <player> <home> <x> <y> <z>"));
            }
            return true;
        }

        if(sender instanceof Player) {
            Player player = (Player) sender;

            boolean hasPermission = player.hasPermission("nessentials.homes.other.set");

            if(args.length == 2 && hasPermission) { // admin trying to set a home for another player at their location
                Player homePlayer = Bukkit.getPlayer(args[0]);

                String coordsX = String.valueOf(player.getLocation().getBlockX());
                String coordsY = String.valueOf(player.getLocation().getBlockY());
                String coordsZ = String.valueOf(player.getLocation().getBlockZ());
                String world = player.getLocation().getWorld().getName();

                if(homePlayer != null) {
                    HomeHandler.setHome(homePlayer, args[1], coordsX, coordsY, coordsZ, world);

                    MessageHandler.InGame.sendMessage(player, ConfigHandler.messageConfig.getString("messages.homes.setother")
                            .replace("%player%", homePlayer.getName())
                            .replace("%home%", args[1])
                            .replace("%x%", coordsX)
                            .replace("%y%", coordsY)
                            .replace("%z%", coordsZ)
                            .replace("%world%", world));
                } else {
                    MessageHandler.Error
                            .sendDoesntExist(player, "player");
                }
            } else if(args.length == 6 && hasPermission) {
                Player homePlayer = Bukkit.getPlayer(args[0]);

                if(homePlayer != null) {
                    if(plugin.getServer().getWorld(args[5]) == null) {
                        MessageHandler.Error.sendDoesntExist(player, "world");
                    }
                    // admin trying to set a home for another player at a specific location
                    HomeHandler.setHome(homePlayer, args[1], args[2], args[3], args[4], args[5]);

                    MessageHandler.InGame.sendMessage(
                            player,
                            ConfigHandler.messageConfig.getString("messages.homes.setother")
                            .replace("%player%", homePlayer.getName())
                            .replace("%home%", args[1])
                            .replace("%x%", args[2])
                            .replace("%y%", args[3])
                            .replace("%z%", args[4])
                            .replace("%world%", args[5]));
                }
                else {
                    MessageHandler.InGame.sendMessage(player, ConfigHandler.messageConfig.getString("messages.error.doesntexist").replace("%error%", "player"));
                }
            } else if (args.length == 1){
                if(
                        (ConfigHandler.databaseConfig.getInt("db.homes." + String.valueOf(player.getUniqueId()) + ".number") < ConfigHandler.databaseConfig.getInt("config.homeslimit")) ||
                        player.hasPermission("nessentials.homes.bypassLimit")
                ) {
                    String coordsX = String.valueOf(player.getLocation().getBlockX());
                    String coordsY = String.valueOf(player.getLocation().getBlockY());
                    String coordsZ = String.valueOf(player.getLocation().getBlockZ());
                    String world = player.getLocation().getWorld().getName();

                    HomeHandler.setHome(player, args[0], coordsX, coordsY, coordsZ, world);

                    MessageHandler.InGame.sendMessage(player, ConfigHandler.messageConfig.getString("messages.homes.setself")
                            .replace("%home%", args[0])
                            .replace("%x%", coordsX)
                            .replace("%y%", coordsY)
                            .replace("%z%", coordsZ)
                            .replace("%world%", world));
                } else {
                    MessageHandler.Error.sendMax(player,"homes");
                }
            } else {
                MessageHandler.Error.sendArgs(player, "/sethome <home>");
            }
        }
        return true;
    }

}
