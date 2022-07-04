package noadev.nessentials.Commands.Homes;

import noadev.nessentials.Handlers.ConfigHandler;
import noadev.nessentials.Handlers.HomeHandler;
import noadev.nessentials.Handlers.LogHandler;
import noadev.nessentials.Handlers.MessageHandler;
import noadev.nessentials.PluginMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class DelHome implements CommandExecutor {
    private final PluginMain plugin;

    public DelHome(PluginMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args.length != 2) {
                MessageHandler.Error.sendArgs("/delhome <player> <home>");
            } else {
                Player homePlayer = Bukkit.getPlayer(args[0]);
                if (homePlayer == null) {
                    MessageHandler.Error.sendDoesntExist("player");
                } else {
                    String homeName = args[1];
                    if(ConfigHandler.messageConfig.getString("db.homes." + homePlayer.getUniqueId() + "." + homeName) != null) {
                        HomeHandler.deleteHome(homePlayer, homeName);
                        MessageHandler.Console.sendMessage(
                            ConfigHandler.messageConfig.getString("messages.console.delhome")
                                .replace("%player%", homePlayer.getName())
                                .replace("%home%", homeName)
                        );
                    }
                }
            }
        }
        if(sender instanceof Player) {
            // Delete home as player
            boolean hasPermission = sender.hasPermission("nessentials.homes.delother");
            if(args.length == 2 && hasPermission) {
                // Delete player home as admin
                Player homePlayer = Bukkit.getPlayer(args[0]);
                if (homePlayer == null) {
                    MessageHandler.Error.sendDoesntExist("player");
                } else {
                    String homeName = args[1];
                    if(ConfigHandler.messageConfig.getString("db.homes." + homePlayer.getUniqueId() + "." + homeName) != null) {
                        HomeHandler.deleteHome(homePlayer, homeName);
                        MessageHandler.InGame.sendMessage(
                            (Player) sender,
                            ConfigHandler.messageConfig.getString("messages.player.delhome")
                                .replace("%player%", homePlayer.getName())
                                .replace("%home%", homeName)
                        );
                    }
                }
            } else if(args.length == 1) {
                // Delete player home as player
                String homeName = args[0];
                Player commandPlayer = (Player) sender;
                if(ConfigHandler.messageConfig.getString("db.homes." + commandPlayer.getUniqueId() + "." + homeName) != null) {
                    ConfigHandler.databaseConfig.set("db.homes." + commandPlayer.getUniqueId() + "." + homeName, null);
                    ConfigHandler.databaseConfig.save();
                    MessageHandler.InGame.sendMessage(
                        (Player) sender,
                        ConfigHandler.messageConfig.getString("messages.player.delself")
                            .replace("%home%", homeName)
                    );
                } else {
                    MessageHandler.Error.sendDoesntExist("home");
                }
            } else {
                // Invalid arguments
                MessageHandler.Error.sendArgs((Player) sender, "/delhome <home>");
            }
        }
        return true;
    }
}
