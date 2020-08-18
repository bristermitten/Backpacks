package me.bristermitten.backpacks.menu

import me.bristermitten.backpacks.BackpacksPlugin
import me.bristermitten.backpacks.api.Backpack
import me.mattstudios.mfgui.gui.components.buildItem
import me.mattstudios.mfgui.gui.guis.paginatedGui
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class BackpackMenu(val backpack: Backpack)
{
	init
	{
		paginatedGui(JavaPlugin.getPlugin(BackpacksPlugin::class.java), 6, "Backpack") {
			backpack.items.flatMap {
				var amount = it.amount
			}
		}
	}
}
