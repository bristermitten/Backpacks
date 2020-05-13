[Backpacks](../../index.md) / [me.bristermitten.backpacks.entity](../index.md) / [ItemBag](index.md) / [add](./add.md)

# add

`fun add(element: ItemStack): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Add an [ItemStack](#) to the Multimap.

This is a simple algorithm:
If an [ItemStack](#) with the same [Material](#) is present =&gt;
{
    If the 2 items are similar ([ItemStack.isSimilar](#)), condense them into 1 by adding amounts.
}
Otherwise, add the [ItemStack](#) separately.

