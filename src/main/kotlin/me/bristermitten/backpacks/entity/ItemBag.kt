package me.bristermitten.backpacks.entity

import com.google.common.collect.ListMultimap
import com.google.common.collect.Multimap
import com.google.common.collect.MultimapBuilder
import kotlinx.serialization.Serializable
import me.bristermitten.backpacks.persistence.ItemBagSerializer
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

/**
 * The internal data structure used for storing items in a Backpack.
 *
 * This uses a [Multimap]<Material, ItemStack> to condense ItemStacks that are similar, while allowing multiple items of the same type.
 * This comes with the benefit of small file size and memory usage (as 500000 Stone blocks can be condensed into 1 ItemStack)
 * however many operations are O(n) instead of O(1).
 */
@Serializable(with = ItemBagSerializer::class)
class ItemBag : MutableCollection<ItemStack>
{
	/**
	 * The Multimap used for storing items.
	 * Enum keys are used for faster lookup.
	 */
	@Suppress("UnstableApiUsage")
	internal val data: ListMultimap<Material, ItemStack> =
			MultimapBuilder.enumKeys(Material::class.java)
					.arrayListValues()
					.build()

	/**
	 * Add an [ItemStack] to the Multimap.
	 *
	 * This is a simple algorithm:
	 * If an [ItemStack] with the same [Material] is present =>
	 *  {
	 *      If the 2 items are similar ([ItemStack.isSimilar]), condense them into 1 by adding amounts.
	 *  }
	 * Otherwise, add the [ItemStack] separately.
	 */
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

	/**
	 * The size of the Multimap based on its entries' amounts.
	 * This is O(n) :(
	 */
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
		var added = false
		elements.forEach {
			if (add(it))
			{
				added = true
			}
		}
		return added
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
