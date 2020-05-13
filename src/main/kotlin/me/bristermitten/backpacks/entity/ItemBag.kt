package me.bristermitten.backpacks.entity

import com.google.common.collect.ListMultimap
import com.google.common.collect.MultimapBuilder
import kotlinx.serialization.Serializable
import me.bristermitten.backpacks.persistence.ItemBagSerializer
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

@Serializable(with = ItemBagSerializer::class)
class ItemBag : MutableCollection<ItemStack>
{
    @Suppress("UnstableApiUsage")
    internal val data: ListMultimap<Material, ItemStack> =
            MultimapBuilder.enumKeys(Material::class.java)
                    .arrayListValues()
                    .build()

    override fun add(element: ItemStack): Boolean
    {
        val similar = data[element.type]?.firstOrNull(element::isSimilar)
        if (similar != null)
        {
            similar.amount += element.amount
            return true
        }
        return data.put(element.type, element)
    }

    override val size: Int
        get() = data.entries().sumBy { it.value.amount }

    override fun contains(element: ItemStack): Boolean
    {
        return data[element.type]?.any(element::isSimilar) ?: false
    }

    override fun containsAll(elements: Collection<ItemStack>): Boolean
    {
        return elements.all(this::contains)
    }

    override fun isEmpty(): Boolean
    {
        return data.isEmpty
    }

    override fun addAll(elements: Collection<ItemStack>): Boolean
    {
        return elements.any(this::add)
    }

    override fun clear()
    {
        data.clear()
    }

    override fun iterator(): MutableIterator<ItemStack>
    {
        return data.values().iterator()
    }

    override fun remove(element: ItemStack): Boolean
    {
        return data.remove(element.type, element)
    }

    override fun removeAll(elements: Collection<ItemStack>): Boolean
    {
        return elements.any(this::remove)
    }

    override fun retainAll(elements: Collection<ItemStack>): Boolean
    {
        val iterator = data.entries().iterator()
        var modified = false
        while (iterator.hasNext())
        {
            val next = iterator.next()
            if (elements.contains(next.value))
            {
                iterator.remove()
                modified = true
            }
        }
        return modified
    }
}
