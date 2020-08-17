package me.bristermitten.backpacks.lang

import org.bukkit.configuration.ConfigurationSection

enum class Lang(private val key: String)
{
	NOT_A_BACKPACK("not-a-backpack"),
	BACKPACK_SIZE_SET("size-set"),
	BACKPACK_GIVEN("backpack-given");

	operator fun get(configuration: ConfigurationSection): String
	{
		return configuration.getString(key) ?: key
	}
}
