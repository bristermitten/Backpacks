package me.bristermitten.backpacks.utils

import org.bukkit.ChatColor

/**
 * Color a String according to [ChatColor.translateAlternateColorCodes]
 */
fun String.color(): String = ChatColor.translateAlternateColorCodes('&', this)


