package me.bristermitten.backpacks.api

import org.bukkit.inventory.ItemStack

interface BackpackFormatter
{
    fun createItem(backpack: Backpack): ItemStack

    fun updateItem(backpack: Backpack, toUpdate: ItemStack): ItemStack

}
