package me.bristermitten.backpacks.persistence

import me.bristermitten.backpacks.api.Backpacks

/**
 * Defines load and save functions for [Backpacks].
 * It is implied that the implementation of this class will hold a reference to the effective singleton of [Backpacks].
 */
interface BackpacksLoader
{
    /**
     * Load Backpacks data from the source.
     */
    fun load()

    /**
     * Save Backpacks data to the source.
     */
    fun save()
}
