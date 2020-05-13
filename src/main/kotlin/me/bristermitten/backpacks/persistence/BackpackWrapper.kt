package me.bristermitten.backpacks.persistence

import kotlinx.serialization.Serializable
import me.bristermitten.backpacks.api.Backpack

@Serializable
class BackpackWrapper(val backpack: Backpack)
