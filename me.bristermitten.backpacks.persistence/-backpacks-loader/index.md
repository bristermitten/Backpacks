[Backpacks](../../index.md) / [me.bristermitten.backpacks.persistence](../index.md) / [BackpacksLoader](./index.md)

# BackpacksLoader

`interface BackpacksLoader`

Defines load and save functions for [Backpacks](../../me.bristermitten.backpacks.api/-backpacks/index.md).
It is implied that the implementation of this class will hold a reference to the effective singleton of [Backpacks](../../me.bristermitten.backpacks.api/-backpacks/index.md).

### Functions

| Name | Summary |
|---|---|
| [load](load.md) | Load Backpacks data from the source.`abstract fun load(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [save](save.md) | Save Backpacks data to the source.`abstract fun save(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [FileBasedBackpacksLoader](../-file-based-backpacks-loader/index.md) | Main implementation of [BackpacksLoader](./index.md).`class FileBasedBackpacksLoader : `[`BackpacksLoader`](./index.md) |
