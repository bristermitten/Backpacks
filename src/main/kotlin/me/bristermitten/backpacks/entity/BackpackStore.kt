package me.bristermitten.backpacks.entity

import me.bristermitten.backpacks.api.Backpack
import me.bristermitten.backpacks.api.Backpacks
import me.bristermitten.backpacks.utils.getBackpackUUID
import me.bristermitten.backpacks.utils.isBackpack
import org.bukkit.inventory.ItemStack
import java.util.*

/**
 * Main implementation of [Backpacks]
 */
internal class BackpackStore : Backpacks
{
    private val allBackpacks = mutableMapOf<UUID, Backpack>()

    override val all
        get() = allBackpacks.values.toSet()


    override fun load(backpacks: Set<Backpack>)
    {
        allBackpacks.clear()
        backpacks.forEach(::register)
    }

    private fun register(backpack: Backpack)
    {
        allBackpacks[backpack.uuid] = backpack
    }

    override fun createBackpack(size: Int): Backpack
    {
        return BackpackEntity(size).also(::register)
    }

    override fun getBackpackById(id: UUID): Backpack? = allBackpacks[id]

    override fun getBackpackByItem(it: ItemStack): Backpack?
    {
        if (!it.isBackpack()) return null
        return get(it.getBackpackUUID())
    }

    override fun get(id: UUID): Backpack? = getBackpackById(id)

    override fun remove(backpack: Backpack)
    {
        allBackpacks.remove(backpack.uuid, backpack)
    }
}
