[Backpacks](../../index.md) / [me.bristermitten.backpacks.api](../index.md) / [BackpackFormatter](index.md) / [updateItem](./update-item.md)

# updateItem

`abstract fun updateItem(backpack: `[`Backpack`](../-backpack/index.md)`, toUpdate: ItemStack): ItemStack`

Update a given [ItemStack](#) to format a given [Backpack](../-backpack/index.md)

Typically, the returned [ItemStack](#) will be similar to the provided [ItemStack](#),
but there is no defined contract for the return value apart from that it represents the [Backpack](../-backpack/index.md).

