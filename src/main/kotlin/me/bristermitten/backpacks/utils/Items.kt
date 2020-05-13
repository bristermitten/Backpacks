package me.bristermitten.backpacks.utils

import de.tr7zw.nbtapi.NBTItem
import me.bristermitten.backpacks.BackpacksPlugin
import me.bristermitten.backpacks.api.Backpack
import me.bristermitten.backpacks.entity.format.SimpleBackpackFormatter
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.lang.IllegalArgumentException
import java.util.*

/**
 * Check if this [ItemStack] is a Backpack.
 *
 * Internally, this uses an NBT tag check.
 */
fun ItemStack.isBackpack(): Boolean
{
    if (type == Material.AIR) return false
    return NBTItem(this).hasKey(SimpleBackpackFormatter.NBT_BACKPACK_TAG)
}

/**
 * Get a [UUID] of a Backpack item.
 * [isBackpack] **must** be checked before this function is called, or errors **will** occur.
 */
fun ItemStack.getBackpackUUID(): UUID
{
    if (type == Material.AIR) throw IllegalArgumentException("Item is AIR! Check ItemStack.isBackpack() first!")
    return UUID.fromString(NBTItem(this).getString(SimpleBackpackFormatter.NBT_BACKPACK_TAG))
}


/**
 * Internal reference to [BackpacksPlugin]
 */
private val backpacks by lazy {
    val plugin = JavaPlugin.getPlugin(BackpacksPlugin::class.java)
    plugin.backpacks
}

/**
 * Extension function to get the first Backpack in an Inventory
 * that is not full.
 */
fun Inventory.firstNotFullBackpack(): Backpack?
{
    return asSequence()
            .filter(ItemStack::isBackpack)
            .map(ItemStack::getBackpackUUID)
            .mapNotNull(backpacks::getBackpackById)
            .filterNot(Backpack::isFull)
            .firstOrNull()
}


/**
 * Extension function to get slot of the first Backpack in an Inventory
 * that is not full, or -1 if none are present.
 */
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
