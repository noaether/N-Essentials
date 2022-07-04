# N-Essentials

![Latest Release](https://img.shields.io/github/v/release/thenoadev/n-essentials) \
![Lines of code](https://img.shields.io/tokei/lines/github/thenoadev/n-essentials) \
![Commits](https://img.shields.io/github/commit-activity/m/thenoadev/n-essentials)

## Table of contents

- [N-Essentials](#n-essentials)
  - [Table of contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Installation](#installation)
  - [Modules](#modules)
    - [Gamemodes](#gamemodes)
    - [Homes](#homes)
    - [Kits](#kits)
    - [Moderation](#moderation)
    - [Misc](#misc)
  - [Permissions](#permissions)
    - [Gamemodes](#gamemodes-1)
    - [Homes](#homes-1)
    - [Kits](#kits-1)
    - [Moderation](#moderation-1)
  - [Changelog](#changelog)
  - [Contributors](#contributors)
  - [Footnotes](#footnotes)

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
| n-essentials:sethome [player] \<name> [x,y,z] [world] | nessentials.homes.self.sethome | nessentials.gamemode.setother  |        ✅         |
| n-essentials:home [player] \<name>                    | nessentials.homes.self.home    | nessentials.gamemode.homeother |        ✅         |
| n-essentials:delhome [player] \<name>                 | nessentials.homes.self.delhome | nessentials.gamemode.delother  |        ✅         |
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
