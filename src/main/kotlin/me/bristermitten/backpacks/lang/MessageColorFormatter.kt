package me.bristermitten.backpacks.lang

import me.bristermitten.backpacks.utils.color
import org.bukkit.command.CommandSender

class MessageColorFormatter : MessageFormatter
{
	override fun format(player: CommandSender, message: String): String
	{
		return message.color()
	}
}
