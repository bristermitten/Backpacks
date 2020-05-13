package me.bristermitten.backpacks.entity

import kotlinx.serialization.Serializable
import me.bristermitten.backpacks.api.Backpack
import me.bristermitten.backpacks.persistence.UUIDSerializer
import org.bukkit.inventory.ItemStack
import java.util.*

@Serializable
internal data class BackpackEntity(
        override var size: Int,

        @Serializable(with = UUIDSerializer::class)
        override val uuid: UUID = UUID.randomUUID()
) : Backpack
{
    override val items = ItemBag()

    override val filled
        get() = items.size

    override val filledPercentage: Double
        get() = filled.toDouble() / size.toDouble() * 100


    private fun addItems(override: Boolean, items: List<ItemStack>): Boolean
    {
        if (isFull() && !override)
        {
            return false
        }
        if (items.size == 1) //Optimization
        {
            return this.items.add(items.first())
        }
        return this.items.addAll(items)
    }

    override fun addItems(vararg items: ItemStack): Boolean
    {
        return addItems(false, items.toList())
    }

    override fun forceAddItems(vararg items: ItemStack): Boolean
    {
        return addItems(true, items.toList())
    }

    override fun removeItems(items: List<ItemStack>)
    {
        this.items.removeAll(items)
    }

    override fun removeItems(vararg items: ItemStack)
    {
        return removeItems(items.toList())
    }

    override fun addItems(items: List<ItemStack>): Boolean
    {
        return addItems(false, items)
    }

    override fun forceAddItems(items: List<ItemStack>): Boolean
    {
        return addItems(true, items)
    }


    override fun isFull() = filled >= size

    override fun clear() = items.clear()

    override fun toString(): String
    {
        return "Backpack(size=$size, uuid=$uuid, items=$items)"
    }

}
