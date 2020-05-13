package me.bristermitten.backpacks.api

import org.bukkit.inventory.ItemStack
import java.util.*

/**
 * Represents a Backpack.
 */
interface Backpack
{
    /**
     * The UUID of the Backpack. This is used for storage
     */
    val uuid: UUID

    /**
     * The Maximum Size of the Backpack.
     * The implementation has no obligation to respect this. For example, [Backpack.forceAddItems] will override this limit,
     * and in the default implementation lowering [size] will not remove any overflowing items.
     */
    var size: Int

    /**
     * The amount of items that the backpack contains.
     * In the default implementation retrieving this is O(n), due to the use of a Multimap.
     * This is defined as the amount of individual items, not the amount of item types.
     * So 30 Stone and 2 Grass will result in the size 32, not 2.
     */
    val filled: Int

    /**
     * The percentage of items that are filled in this Backpack.
     * This is a double from [0.0-100.0] with no rounding applied.
     */
    val filledPercentage: Double

    /**
     * The items that this Backpack contains.
     * This collection is not guaranteed to be mutable.
     */
    val items: Collection<ItemStack>

    /**
     * If this Backpack is full or not.
     * "Full" is defined as [filled] >= [size]
     */
    fun isFull(): Boolean

    /**
     * Add items to this Backpack.
     * This will only add items that will fit.
     * If 2 slots are free, then only the first 2 items will be added.
     */
    fun addItems(vararg items: ItemStack): Boolean

    /**
     * Add items to this Backpack as a List.
     * @see [Backpack.addItems]
     */
    fun addItems(items: List<ItemStack>): Boolean

    /**
     * Add items to this Backpack.
     * This function does not respect the Backpack's size.
     */
    fun forceAddItems(vararg items: ItemStack): Boolean

    /**
     * Add items to this Backpack as a List.
     * @see [Backpack.forceAddItems]
     */
    fun forceAddItems(items: List<ItemStack>): Boolean

    /**
     * Remove items from this Backpack.
     */
    fun removeItems(vararg items: ItemStack)

    /**
     * Remove items from this Backpack.
     */
    fun removeItems(items: List<ItemStack>)

    /**
     * Clear this Backpack, removing all of the items.
     */
    fun clear()

}
