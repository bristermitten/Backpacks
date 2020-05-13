package me.bristermitten.backpacks.utils

import org.bukkit.ChatColor

fun String.color(): String = ChatColor.translateAlternateColorCodes('&', this)


