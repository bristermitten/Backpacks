package me.bristermitten.backpacks.api

import org.bukkit.inventory.ItemStack
import me.bristermitten.backpacks.utils.isBackpack

/**
 * A BackpackFormatter is responsible for converting a [Backpack] to an [ItemStack].
 *
 * This [ItemStack] should represent all of the current Backpack data that is viewable.
 * This Interface should create [ItemStack]s that correctly trigger [ItemStack.isBackpack].
 */
interface BackpackFormatter
{
    /**
     * Create a new [ItemStack] based on a given [Backpack]
     */
    fun createItem(backpack: Backpack): ItemStack

    /**
     * Update a given [ItemStack] to format a given [Backpack]
     *
     * Typically, the returned [ItemStack] will be similar to the provided [ItemStack],
     * but there is no defined contract for the return value apart from that it represents the [Backpack].
     */
    fun updateItem(backpack: Backpack, toUpdate: ItemStack): ItemStack
}
