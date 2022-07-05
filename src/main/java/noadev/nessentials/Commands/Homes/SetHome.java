package noadev.nessentials.Commands.Homes;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import noadev.nessentials.PluginMain;
import noadev.nessentials.Handlers.ConfigHandler;
import noadev.nessentials.Handlers.HomeHandler;
import noadev.nessentials.Handlers.MessageHandler;
import noadev.nessentials.Handlers.PermissionHandler;

/*
 * This class is part of the plugin noadev-nessentials
 * Module : Homes
 * Class : _SetHome
 * CommandSenders : Console and Player
*/

public class SetHome implements CommandExecutor {
  private final Plugin plugin;

  public SetHome(PluginMain plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof ConsoleCommandSender) {
      if (args.length == 6) {
        Player argsPlayer = Bukkit.getPlayer(args[0]);
        if (argsPlayer != null) {
          HomeHandler.setHome(argsPlayer, args[1], args[2], args[3], args[4], args[5]);
          MessageHandler.Console.sendMessage(ConfigHandler.messageConfig.getString("messages.homes.setother")
              .replace("%player%", args[0])
              .replace("%home%", args[1])
              .replace("%x%", args[2])
              .replace("%y%", args[3])
              .replace("%z%", args[4])
              .replace("%world%", args[5]));
        } else {
          MessageHandler.Error.sendDoesntExist("player");
        }
      } else {
        MessageHandler.Error.sendArgs("/sethome <player> <name> <x> <y> <z> <world>");
      }
    } else if (sender instanceof Player) {
      Player p_ = (Player) sender;
      if (args.length == 2) {
        int maxHomes = ConfigHandler.messageConfig.getInt("config.homeslimit");
        int homes = ConfigHandler.databaseConfig.getInt("db.homes." + String.valueOf(p_.getUniqueId()) + ".number");
        boolean hp_ = PermissionHandler.Read.hasPerm(p_, "nessentials.homes.bypassLimit");
        if (homes < maxHomes || hp_) {
          String coordsX = String.valueOf(p_.getLocation().getBlockX());
          String coordsY = String.valueOf(p_.getLocation().getBlockY());
          String coordsZ = String.valueOf(p_.getLocation().getBlockZ());
          String world = p_.getLocation().getWorld().getName();
          HomeHandler.setHome(p_, args[0], coordsX, coordsY, coordsZ, world);
          MessageHandler.InGame.sendMessage(p_,
              ConfigHandler.messageConfig.getString("messages.homes.set")
                  .replace("%home%", args[0])
                  .replace("%x%", coordsX)
                  .replace("%y%", coordsY)
                  .replace("%z%", coordsZ)
                  .replace("%world%", world));
        } else {
          MessageHandler.Error.sendMax(p_, "homes");
        }
      } else if (args.length == 6) {
        if (PermissionHandler.Read.hasPerm(p_, "nessentials.homes.setother")) {
          Player argsPlayer = Bukkit.getPlayer(args[0]);
          if (argsPlayer != null) {
            HomeHandler.setHome(argsPlayer, args[1], args[2], args[3], args[4], args[5]);
            MessageHandler.InGame.sendMessage(
                p_,
                ConfigHandler.messageConfig.getString("messages.homes.setother")
                    .replace("%player%", args[0])
                    .replace("%home%", args[1])
                    .replace("%x%", args[2])
                    .replace("%y%", args[3])
                    .replace("%z%", args[4])
                    .replace("%world%", args[5]));
          } else {
            MessageHandler.Error.sendDoesntExist("player");
          }
        } else {
          MessageHandler.Error.sendNoPermission(p_);
        }
      } else {
        MessageHandler.Error.sendArgs("/sethome <player> <name> <x> <y> <z> <world>");
      }
    }
    return false;
  }
}
