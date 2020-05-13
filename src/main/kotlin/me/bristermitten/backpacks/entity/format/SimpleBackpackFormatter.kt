package me.bristermitten.backpacks.entity.format

import de.tr7zw.nbtapi.NBTItem
import me.bristermitten.backpacks.api.Backpack
import me.bristermitten.backpacks.api.BackpackFormatter
import me.bristermitten.backpacks.utils.color
import me.bristermitten.backpacks.utils.truncated
import org.bukkit.inventory.ItemStack

internal class SimpleBackpackFormatter(
        private val format: ItemFormat
) : BackpackFormatter
{
    companion object
    {
        const val NBT_BACKPACK_TAG = "BackpackID"
    }

    override fun createItem(backpack: Backpack): ItemStack
    {
        val item = ItemStack(format.type)
        return updateItem(backpack, item)
    }

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
