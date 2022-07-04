# N-Essentials
# Table of Contents
1. [Introduction](#Introduction)
2. [Installation](#Installation)
3. [Commands](#Commands)
4. [Modules](#Modules)
   1. [Gamemodes](#Gamemodes)
   2. [Homes](#Homes)
   3. [Kits](#Kits)
   4. [Moderation](#Moderation)
   5. [Misc](#Misc)
5. [Permissions](#Permissions)
    1. [Gamemodes](#Gamemodes)
    2. [Homes](#Homes)
    3. [Kits](#Kits)
    4. [Moderation](#Moderation)
    5. [Misc](#Misc)
6. [Changelog](#Changelog)
7. [Contributors](#Contributors)
8. [Footnotes](#Footnotes)

## Introduction
N-Essentials is a simple alternative to EssentialsX, useful for small servers that might only need some important functions.

## Installation
- Download the latest release from the github repository
- Download the modules you want to use
- Place the files in the plugins directory of your minecraft server
- Enjoy !
- You can also use the [N-Essentials-Bundle]() to get everything in one package
## Modules
### Gamemodes 
A simple gamemode module that allows you to set your gamemode or the gamemode of a player, with `/gm` commands

### Homes
A home module that allows you to set named homes, teleport back to them, get directions to them and more

### Kits
A kit module, useful for small minigame servers that don't need something hard to setup.

### Moderation
A moderation module that allows you to ban, kick, mute, unmute, warn, unwarn, and more.

### Misc
More fun commands to play with that couldnt fit into other modules.

## Permissions
### Gamemodes
| Command                    | Permission Required (Self)     | Permission Required (Other) | Self is default? |
|:---------------------------|:-------------------------------|:----------------------------|:----------------:|
| n-essentials:gma [player]  | nessentials.gamemode.self.gma  | nessentials.gamemode.other  |        ✅         |
| n-essentials:gmc [player]  | nessentials.gamemode.self.gmc  | nessentials.gamemode.other  |        ✅         |
| n-essentials:gms [player]  | nessentials.gamemode.self.gms  | nessentials.gamemode.other  |        ✅         |
| n-essentials:gmsp [player] | nessentials.gamemode.self.gmsp | nessentials.gamemode.other  |        ✅         |

### Homes
| Command                                              | Permission Required (Self)     | Permission Required (Other)    | Self is default? |
|:-----------------------------------------------------|:-------------------------------|:-------------------------------|:----------------:|
| n-essentials:sethome [player] <name> [x,y,z] [world] | nessentials.homes.self.sethome | nessentials.gamemode.setother  |        ✅         |
| n-essentials:home [player] <name>                    | nessentials.homes.self.home    | nessentials.gamemode.homeother |        ✅         |
| n-essentials:delhome [player] <name>                 | nessentials.homes.self.delhome | nessentials.gamemode.delother  |        ✅         |
| n-essentials:homes [player]                          | nessentials.homes.self.list    | nessentials.gamemode.listother |        ✅         |
| Bypass the maximum number of houses                  | nessentials.homes.bypasslimit  | ❌                              |        ❌         |

### Kits

### Moderation

## Changelog
- [v1.0.0]() - Initial release
- [v1.1.0]() - Added `/gm_` commands
- [v1.1.2]() - Fixed `/gm_` permission issues
- [v1.2.0]() - Added home system
- [v1.2.1]() - Added `/home` `/sethome` `/delhome` commands
- [v1.2.2]() - Added `/home` `/sethome` `/delhome` permissions
- [v1.3.1]() - Separated systems into different handlers and modules
- [v1.3.2]() - Added configuration options for modules
- [v1.3.3]() - Added log, homes and config modules
- [v1.3.4]() - Added message handler using the config handler
- [v1.4.1]() - Full plugin refactor, added changelog, contributors, footnotes, and more

## Contributors
Want to see your name here ? Open a pull request or an issue !

## Footnotes
:)