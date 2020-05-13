[Backpacks](../../index.md) / [me.bristermitten.backpacks.api](../index.md) / [Backpacks](./index.md)

# Backpacks

`interface Backpacks`

Represents the global storage of all Backpacks.

This is an effective singleton. Aside from 3rd party modification, only 1 instance will be created.

### Properties

| Name | Summary |
|---|---|
| [all](all.md) | A Set of all Backpacks present.`abstract val all: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`Backpack`](../-backpack/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [createBackpack](create-backpack.md) | Create a new Backpack with a given size, or [DEFAULT_BACKPACK_SIZE](-d-e-f-a-u-l-t_-b-a-c-k-p-a-c-k_-s-i-z-e.md) if no size is provided.`abstract fun createBackpack(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_BACKPACK_SIZE): `[`Backpack`](../-backpack/index.md) |
| [get](get.md) | Operator function for getting a Backpack by its [Backpack.uuid](../-backpack/uuid.md)`abstract operator fun get(id: `[`UUID`](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`): `[`Backpack`](../-backpack/index.md)`?` |
| [getBackpackById](get-backpack-by-id.md) | Get a Backpack by its [Backpack.uuid](../-backpack/uuid.md). This function will return null if no Backpack exists.`abstract fun getBackpackById(id: `[`UUID`](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`): `[`Backpack`](../-backpack/index.md)`?` |
| [getBackpackByItem](get-backpack-by-item.md) | Get a Backpack by an [ItemStack](#) that represents an ItemStack.`abstract fun getBackpackByItem(it: ItemStack): `[`Backpack`](../-backpack/index.md)`?` |
| [load](load.md) | Load Backpacks from a given Set.`abstract fun load(backpacks: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`Backpack`](../-backpack/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [remove](remove.md) | Remove a Backpack from the store.`abstract fun remove(backpack: `[`Backpack`](../-backpack/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DEFAULT_BACKPACK_SIZE](-d-e-f-a-u-l-t_-b-a-c-k-p-a-c-k_-s-i-z-e.md) | The default size of a Backpack.`const val DEFAULT_BACKPACK_SIZE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
