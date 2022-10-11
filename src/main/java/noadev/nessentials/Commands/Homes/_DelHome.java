package noadev.nessentials.Commands.Homes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import noadev.nessentials.PluginMain;

/*
 * This class is part of the plugin noadev-nessentials
 * Module : Homes
 * Class : _DelHome
 * CommandSenders : Console and Player
*/

public class _DelHome implements CommandExecutor {
  private final Plugin plugin;

  public _DelHome(PluginMain plugin) {
      this.plugin = plugin;
  }

  @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      return false;
    }
}
