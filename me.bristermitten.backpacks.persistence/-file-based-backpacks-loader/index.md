[Backpacks](../../index.md) / [me.bristermitten.backpacks.persistence](../index.md) / [FileBasedBackpacksLoader](./index.md)

# FileBasedBackpacksLoader

`class FileBasedBackpacksLoader : `[`BackpacksLoader`](../-backpacks-loader/index.md)

Main implementation of [BackpacksLoader](../-backpacks-loader/index.md).

This uses [Cbor](#) combined with GZIP for concise data storage.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Main implementation of [BackpacksLoader](../-backpacks-loader/index.md).`FileBasedBackpacksLoader(backpacks: `[`Backpacks`](../../me.bristermitten.backpacks.api/-backpacks/index.md)`, backpacksDirectory: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [load](load.md) | Load Backpacks data from the source.`fun load(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [save](save.md) | Save Backpacks data to the source.`fun save(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
