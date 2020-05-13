[Backpacks](../../index.md) / [me.bristermitten.backpacks.api](../index.md) / [Backpack](index.md) / [size](./size.md)

# size

`abstract var size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

The Maximum Size of the Backpack.

The implementation has no obligation to respect this. For example, [Backpack.forceAddItems](force-add-items.md) will override this limit,
and in the default implementation lowering [size](./size.md) will not remove any overflowing items.

