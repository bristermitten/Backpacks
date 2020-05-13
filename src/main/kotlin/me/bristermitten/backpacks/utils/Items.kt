package me.bristermitten.backpacks.utils

import de.tr7zw.nbtapi.NBTItem
import me.bristermitten.backpacks.BackpacksPlugin
import me.bristermitten.backpacks.api.Backpack
import me.bristermitten.backpacks.entity.format.SimpleBackpackFormatter
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

fun ItemStack.isBackpack(): Boolean = NBTItem(this).hasKey(SimpleBackpackFormatter.NBT_BACKPACK_TAG)
fun ItemStack.getBackpackUUID(): UUID = UUID.fromString(NBTItem(this).getString(SimpleBackpackFormatter.NBT_BACKPACK_TAG))


private val backpacks by lazy {
    val plugin = JavaPlugin.getPlugin(BackpacksPlugin::class.java)
    plugin.backpacks
}

fun Inventory.firstNotFullBackpack(): Backpack?
{
    return asSequence()
            .filter(ItemStack::isBackpack)
            .map(ItemStack::getBackpackUUID)
            .mapNotNull(backpacks::getBackpackById)
            .filterNot(Backpack::isFull)
            .firstOrNull()
}

fun Inventory.firstNotFullBackpackSlot(): Int
{
    val firstBackpack = asSequence()
            .filterNotNull()
            .filter(ItemStack::isBackpack)
            .firstOrNull {
                val backpack = backpacks.getBackpackByItem(it)
                backpack?.isFull()?.not() ?: true
            }
    firstBackpack ?: return -1
    return contents.indexOf(firstBackpack)
}
