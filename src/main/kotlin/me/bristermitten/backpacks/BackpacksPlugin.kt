package me.bristermitten.backpacks

import co.aikar.commands.PaperCommandManager
import com.charleskorn.kaml.Yaml
import me.bristermitten.backpacks.api.BackpackFormatter
import me.bristermitten.backpacks.api.Backpacks
import me.bristermitten.backpacks.commands.BackpacksCommand
import me.bristermitten.backpacks.entity.BackpackStore
import me.bristermitten.backpacks.entity.format.SimpleBackpackFormatter
import me.bristermitten.backpacks.event.BackpackPlaceListener
import me.bristermitten.backpacks.event.ItemGainListener
import me.bristermitten.backpacks.persistence.BackpacksConfig
import me.bristermitten.backpacks.persistence.BackpacksLoader
import me.bristermitten.backpacks.persistence.FileBasedBackpacksLoader
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class BackpacksPlugin : JavaPlugin()
{
    val backpacks: Backpacks = BackpackStore()

    lateinit var backpacksLoader: BackpacksLoader
    lateinit var backpacksConfig: BackpacksConfig
    lateinit var backpackFormatter: BackpackFormatter

    override fun onEnable()
    {

        val backpacksDirectory = dataFolder.resolve("backpacks")
        backpacksDirectory.mkdirs()

        backpacksLoader = FileBasedBackpacksLoader(backpacks, backpacksDirectory)
        backpacksLoader.load()

        val configFile = dataFolder.resolve("config.yml")
        if (!configFile.exists())
        {
            saveResource("config.yml", false)
        }
        backpacksConfig = Yaml.default.parse(BackpacksConfig.serializer(), configFile.readText())
        backpackFormatter = SimpleBackpackFormatter(backpacksConfig.itemFormat)

        registerCommands()
        registerEvents()

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
        @Suppress("DEPRECATION")
        commandManager.enableUnstableAPI("help")
        commandManager.registerCommand(BackpacksCommand(backpacks, backpackFormatter))
    }

    override fun onDisable()
    {
        backpacksLoader.save()
    }
}
