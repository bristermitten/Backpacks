package me.bristermitten.backpacks.persistence

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.bristermitten.backpacks.entity.format.ItemFormat

@Serializable
data class BackpacksConfig(
        @SerialName("backpack-item")
        val itemFormat: ItemFormat
)
