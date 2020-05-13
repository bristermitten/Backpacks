package me.bristermitten.backpacks.persistence

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.bristermitten.backpacks.entity.format.ItemFormat

/**
 * The serializable wrapper class of config.yml
 * @param itemFormat The format of any Backpack items.
 */
@Serializable
data class BackpacksConfig(
        @SerialName("backpack-item")
        val itemFormat: ItemFormat
)
