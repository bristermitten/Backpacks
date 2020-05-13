package me.bristermitten.backpacks.entity.format

import kotlinx.serialization.Serializable
import org.bukkit.Material

@Serializable
data class ItemFormat(
        val type: Material = Material.STONE,
        val name: String? = null,
        val lore: List<String> = emptyList()
)
