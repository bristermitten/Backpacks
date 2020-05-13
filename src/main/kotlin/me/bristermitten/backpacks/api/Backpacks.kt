package me.bristermitten.backpacks.api

import org.bukkit.inventory.ItemStack
import java.util.*
import me.bristermitten.backpacks.utils.isBackpack

/**
 * Represents the global storage of all Backpacks.
 *
 * This is an effective singleton. Aside from 3rd party modification, only 1 instance will be created.
 */
interface Backpacks
{
    /**
     * A Set of all Backpacks present.
     *
     * This Set is not necessarily mutable, and should not be mutated directly.
     * Prefer the wrapper methods such as [createBackpack]
     */
    val all: Set<Backpack>

    /**
     * Create a new Backpack with a given size, or [DEFAULT_BACKPACK_SIZE] if no size is provided.
     */
    fun createBackpack(size: Int = DEFAULT_BACKPACK_SIZE): Backpack

    /**
     * Get a Backpack by its [Backpack.uuid].
     * This function will return null if no Backpack exists.
     */
    fun getBackpackById(id: UUID): Backpack?

    /**
     * Get a Backpack by an [ItemStack] that represents an ItemStack.
     *
     * The nullability of this function relates to the return value of [ItemStack.isBackpack]
     */
    fun getBackpackByItem(it: ItemStack): Backpack?

    /**
     * Operator function for getting a Backpack by its [Backpack.uuid]
     * @see getBackpackById
     */
    operator fun get(id: UUID): Backpack?

    /**
     * Remove a Backpack from the store.
     */
    fun remove(backpack: Backpack)


    /**
     * Load Backpacks from a given Set.
     *
     * This will clear the internal store, and replace all the values with the values in [backpacks].
     * Should be used with caution, typically for deserialization.
     */
    fun load(backpacks: Set<Backpack>)

    companion object
    {
        /**
         * The default size of a Backpack.
         */
        const val DEFAULT_BACKPACK_SIZE = 64
    }
}

