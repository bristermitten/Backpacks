package me.bristermitten.backpacks.persistence

import me.bristermitten.backpacks.entity.format.ItemFormat
import org.bukkit.Material
import org.bukkit.configuration.ConfigurationSection

/**
 * The serializable wrapper class of config.yml
 * @param itemFormat The format of any Backpack items.
 */
data class BackpacksConfig(
		val itemFormat: ItemFormat
)
{
	companion object
	{
		fun load(configurationSection: ConfigurationSection): BackpacksConfig
		{
			val section = configurationSection.getConfigurationSection("backpack-item")
			requireNotNull(section) { "No backpack-item configured" }

			val type = section.getString("type")?.let(Material::matchMaterial)
			requireNotNull(type) { "No type or invalid material" }

			val name = section.getString("name")

			val lore = section.getStringList("lore")

			val format = ItemFormat(type, name, lore)

			return BackpacksConfig(format)
		}
	}
}
