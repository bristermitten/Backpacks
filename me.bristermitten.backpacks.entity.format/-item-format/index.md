[Backpacks](../../index.md) / [me.bristermitten.backpacks.entity.format](../index.md) / [ItemFormat](./index.md)

# ItemFormat

`data class ItemFormat`

Serializable data class representing the simple format of an [ItemStack](#).
This is deserialized from config.yml and has placeholders applied in [SimpleBackpackFormatter](#)
to make a Backpack item.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Serializable data class representing the simple format of an [ItemStack](#). This is deserialized from config.yml and has placeholders applied in [SimpleBackpackFormatter](#) to make a Backpack item.`ItemFormat(type: Material = Material.STONE, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, lore: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`> = emptyList())` |

### Properties

| Name | Summary |
|---|---|
| [lore](lore.md) | `val lore: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [type](type.md) | `val type: Material` |
