[Backpacks](../../index.md) / [me.bristermitten.backpacks.api](../index.md) / [Backpacks](index.md) / [load](./load.md)

# load

`abstract fun load(backpacks: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`Backpack`](../-backpack/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Load Backpacks from a given Set.

This will clear the internal store, and replace all the values with the values in [backpacks](load.md#me.bristermitten.backpacks.api.Backpacks$load(kotlin.collections.Set((me.bristermitten.backpacks.api.Backpack)))/backpacks).
Should be used with caution, typically for deserialization.

