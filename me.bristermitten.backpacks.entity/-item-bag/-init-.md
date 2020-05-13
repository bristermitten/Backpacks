[Backpacks](../../index.md) / [me.bristermitten.backpacks.entity](../index.md) / [ItemBag](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`ItemBag()`

The internal data structure used for storing items in a Backpack.

This uses a Multimap&lt;Material, ItemStack&gt; to condense ItemStacks that are similar, while allowing multiple items of the same type.
This comes with the benefit of small file size and memory usage (as 500000 Stone blocks can be condensed into 1 ItemStack)
however many operations are O(n) instead of O(1).

