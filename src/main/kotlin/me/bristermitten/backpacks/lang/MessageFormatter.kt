package me.bristermitten.backpacks.lang

import org.bukkit.command.CommandSender

interface MessageFormatter
{
	fun format(player: CommandSender, message: String): String
}
