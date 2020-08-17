package me.bristermitten.backpacks

import co.aikar.commands.ConditionFailedException
import co.aikar.commands.MessageType
import co.aikar.commands.PaperCommandManager
import kotlinx.serialization.ExperimentalSerializationApi
import me.bristermitten.backpacks.api.BackpackFormatter
import me.bristermitten.backpacks.api.Backpacks
import me.bristermitten.backpacks.commands.BackpacksCommand
import me.bristermitten.backpacks.entity.BackpackStore
import me.bristermitten.backpacks.entity.format.SimpleBackpackFormatter
import me.bristermitten.backpacks.event.BackpackPlaceListener
import me.bristermitten.backpacks.event.ItemGainListener
import me.bristermitten.backpacks.lang.LangService
import me.bristermitten.backpacks.lang.MessageColorFormatter
import me.bristermitten.backpacks.lang.MessageFormatter
import me.bristermitten.backpacks.hook.PAPIHook
import me.bristermitten.backpacks.persistence.BackpacksConfig
import me.bristermitten.backpacks.persistence.BackpacksLoader
import me.bristermitten.backpacks.persistence.FileBasedBackpacksLoader
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

/**
 * The Main class of Backpacks.
 */
class BackpacksPlugin : JavaPlugin()
{
	val backpacks: Backpacks = BackpackStore()

	lateinit var backpacksLoader: BackpacksLoader
	lateinit var backpacksConfig: BackpacksConfig
	lateinit var backpackFormatter: BackpackFormatter
	private lateinit var langService: LangService

	@ExperimentalSerializationApi
	override fun onEnable()
	{
		val backpacksDirectory = dataFolder.resolve("backpacks")
		backpacksDirectory.mkdirs()

		backpacksLoader = FileBasedBackpacksLoader(backpacks, backpacksDirectory)
		backpacksLoader.load()
		logger.info("Loaded ${backpacks.all.size} backpacks")

		saveDefaultConfig()

		backpacksConfig = BackpacksConfig.load(config)
		backpackFormatter = SimpleBackpackFormatter(backpacksConfig.itemFormat)

		loadLang()
		registerCommands()
		registerEvents()
	}

	private fun loadLang()
	{
		val langFileName = "lang.yml"
		val langFile = dataFolder.resolve(langFileName)
		if (!langFile.exists())
		{
			saveResource(langFileName, false)
		}
		val hooks = loadHooks()
		langService = LangService(langFile, hooks)
	}

	private fun loadHooks(): List<MessageFormatter>
	{
		val hooks = mutableListOf<MessageFormatter>(MessageColorFormatter())
		if (server.pluginManager.isPluginEnabled("PlaceholderAPI"))
		{
			hooks += PAPIHook()
			logger.info("Successfully hooked into PAPI!")
		}
		return hooks
	}

	private fun registerEvents()
	{
		val pluginManager = Bukkit.getPluginManager()
		pluginManager.registerEvents(BackpackPlaceListener(), this)
		pluginManager.registerEvents(ItemGainListener(backpackFormatter, backpacks), this)
	}

	private fun registerCommands()
	{
		val commandManager = PaperCommandManager(this)
		commandManager.setFormat(MessageType.HELP, ChatColor.DARK_PURPLE, ChatColor.LIGHT_PURPLE, ChatColor.GREEN)

		@Suppress("DEPRECATION")
		commandManager.enableUnstableAPI("help")
		commandManager.commandConditions.addCondition(Integer::class.java, "unsigned") { _, _, value ->
			if (value < 0)
			{
				throw ConditionFailedException("Value must be more than 0!")
			}
		}

		commandManager.registerCommand(BackpacksCommand(backpacks, backpackFormatter, langService))
	}

	override fun onDisable()
	{
		backpacksLoader.save()
	}
}
