package me.bristermitten.backpacks.entity.format

import kotlinx.serialization.Serializable
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

/**
 * Serializable data class representing the simple format of an [ItemStack].
 * This is deserialized from config.yml and has placeholders applied in [SimpleBackpackFormatter]
 * to make a Backpack item.
 */
data class ItemFormat(
        val type: Material,
        val name: String? = null,
        val lore: List<String> = emptyList()
)
