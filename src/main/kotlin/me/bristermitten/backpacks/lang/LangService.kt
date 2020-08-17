package me.bristermitten.backpacks.lang

import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class LangService(
		private val file: File,
		private val formatters: List<MessageFormatter>)
{
	private var yaml = YamlConfiguration.loadConfiguration(file)

	fun format(key: Lang, sender: CommandSender): String
	{
		val message = key[yaml]
		return formatters.fold(message) { s, messageHook ->
			messageHook.format(sender, s)
		}
	}

	fun reload()
	{
		yaml = YamlConfiguration.loadConfiguration(file)
	}
}
