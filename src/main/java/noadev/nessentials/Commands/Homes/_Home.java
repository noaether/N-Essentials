package noadev.nessentials.Commands.Homes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import noadev.nessentials.PluginMain;

/*
 * This class is part of the plugin noadev-nessentials
 * Module : Homes
 * Class : _Home
 * CommandSenders : Player
*/


public class _Home implements CommandExecutor {
  private final Plugin plugin;

  public _Home(PluginMain plugin) {
      this.plugin = plugin;
  }

  @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      return false;
    }
}
