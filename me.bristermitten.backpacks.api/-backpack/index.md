[Backpacks](../../index.md) / [me.bristermitten.backpacks.api](../index.md) / [Backpack](./index.md)

# Backpack

`interface Backpack`

Represents a Backpack.

### Properties

| Name | Summary |
|---|---|
| [filled](filled.md) | The amount of items that the backpack contains.`abstract val filled: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [filledPercentage](filled-percentage.md) | The percentage of items that are filled in this Backpack. This is a double from [0.0-100.0](#) with no rounding applied.`abstract val filledPercentage: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [items](items.md) | The items that this Backpack contains. This collection is not guaranteed to be mutable.`abstract val items: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<ItemStack>` |
| [size](size.md) | The Maximum Size of the Backpack.`abstract var size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [uuid](uuid.md) | The UUID of the Backpack. This is used for storage`abstract val uuid: `[`UUID`](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html) |

### Functions

| Name | Summary |
|---|---|
| [addItems](add-items.md) | Add items to this Backpack. This will only add items that will fit. If 2 slots are free, then only the first 2 items will be added.`abstract fun addItems(vararg items: ItemStack): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Add items to this Backpack as a List.`abstract fun addItems(items: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [clear](clear.md) | Clear this Backpack, removing all of the items.`abstract fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [forceAddItems](force-add-items.md) | Add items to this Backpack. This function does not respect the Backpack's size.`abstract fun forceAddItems(vararg items: ItemStack): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Add items to this Backpack as a List.`abstract fun forceAddItems(items: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isFull](is-full.md) | If this Backpack is full or not. "Full" is defined as [filled](filled.md) &gt;= [size](size.md)`abstract fun isFull(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [removeItems](remove-items.md) | Remove items from this Backpack.`abstract fun removeItems(vararg items: ItemStack): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`abstract fun removeItems(items: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
