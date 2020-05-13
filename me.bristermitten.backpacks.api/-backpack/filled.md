[Backpacks](../../index.md) / [me.bristermitten.backpacks.api](../index.md) / [Backpack](index.md) / [filled](./filled.md)

# filled

`abstract val filled: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

The amount of items that the backpack contains.

In the default implementation retrieving this is O(n), due to the use of a Multimap.
This is defined as the amount of individual items, not the amount of item types.
So 30 Stone and 2 Grass will result in the size 32, not 2.

