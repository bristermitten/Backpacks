package me.bristermitten.backpacks.api

import org.bukkit.inventory.ItemStack
import java.util.*

interface Backpacks
{

    val all: Set<Backpack>

    fun createBackpack(size: Int = 64): Backpack

    fun getBackpackById(id: UUID): Backpack?

    fun getBackpackByItem(it: ItemStack): Backpack?

    operator fun get(id: UUID): Backpack?

    fun load(backpacks: Set<Backpack>)
}
