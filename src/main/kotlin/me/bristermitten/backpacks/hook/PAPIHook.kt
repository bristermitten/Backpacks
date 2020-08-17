package me.bristermitten.backpacks.hook

import me.bristermitten.backpacks.lang.MessageFormatter
import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class PAPIHook : MessageFormatter
{
	override fun format(player: CommandSender, message: String): String
	{
		return PlaceholderAPI.setPlaceholders(player as? Player, message)
	}

}
