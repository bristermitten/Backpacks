[Backpacks](../../index.md) / [me.bristermitten.backpacks.api](../index.md) / [BackpackFormatter](./index.md)

# BackpackFormatter

`interface BackpackFormatter`

A BackpackFormatter is responsible for converting a [Backpack](../-backpack/index.md) to an [ItemStack](#).

This [ItemStack](#) should represent all of the current Backpack data that is viewable.
This Interface should create [ItemStack](#)s that correctly trigger [ItemStack.isBackpack](../../me.bristermitten.backpacks.utils/org.bukkit.inventory.-item-stack/is-backpack.md).

### Functions

| Name | Summary |
|---|---|
| [createItem](create-item.md) | Create a new [ItemStack](#) based on a given [Backpack](../-backpack/index.md)`abstract fun createItem(backpack: `[`Backpack`](../-backpack/index.md)`): ItemStack` |
| [updateItem](update-item.md) | Update a given [ItemStack](#) to format a given [Backpack](../-backpack/index.md)`abstract fun updateItem(backpack: `[`Backpack`](../-backpack/index.md)`, toUpdate: ItemStack): ItemStack` |
