package me.bristermitten.backpacks.entity.format

import de.tr7zw.nbtapi.NBTItem
import me.bristermitten.backpacks.api.Backpack
import me.bristermitten.backpacks.api.BackpackFormatter
import me.bristermitten.backpacks.utils.color
import me.bristermitten.backpacks.utils.truncated
import org.bukkit.inventory.ItemStack

/**
 * The default [BackpackFormatter] implementation.
 *
 * This uses an [ItemFormat] that is loaded from config.yml
 * to create Backpack items.
 */
internal class SimpleBackpackFormatter(
        private val format: ItemFormat
) : BackpackFormatter
{
    companion object
    {
        /**
         * The NBT tag that stores a Backpack's [Backpack.uuid]
         */
        const val NBT_BACKPACK_TAG = "BackpackID"
    }

    /**
     * Create a new [ItemStack] based on a given [Backpack]
     * @see updateItem
     */
    override fun createItem(backpack: Backpack): ItemStack
    {
        val item = ItemStack(format.type)
        return updateItem(backpack, item)
    }

    /**
     * Update a given [ItemStack] based on a given [Backpack].
     *
     * In this function, the [format] is used to update the given [ItemStack]'s name and lore.
     * The NBT is also updated.
     */
    override fun updateItem(backpack: Backpack, toUpdate: ItemStack): ItemStack
    {
        val itemMeta = toUpdate.itemMeta ?: return toUpdate
        itemMeta.setDisplayName(format.name?.color()?.let { applyBackpackPlaceholders(backpack, it) })
        itemMeta.lore = format.lore.map(String::color).map { applyBackpackPlaceholders(backpack, it) }

        toUpdate.itemMeta = itemMeta

        val nbtItem = NBTItem(toUpdate)
        nbtItem.setString(NBT_BACKPACK_TAG, backpack.uuid.toString())
        return nbtItem.item
    }

    private fun applyBackpackPlaceholders(backpack: Backpack, message: String): String
    {
        return message
                .replace("{max-size}", backpack.size.toString())
                .replace("{current-size}", backpack.filled.toString())
                .replace("{filled-percentage}", backpack.filledPercentage.truncated().toString())
    }
}
