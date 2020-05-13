[Backpacks](../index.md) / [me.bristermitten.backpacks.persistence](./index.md)

## Package me.bristermitten.backpacks.persistence

### Types

| Name | Summary |
|---|---|
| [BackpacksConfig](-backpacks-config/index.md) | The serializable wrapper class of config.yml`data class BackpacksConfig` |
| [BackpacksLoader](-backpacks-loader/index.md) | Defines load and save functions for [Backpacks](../me.bristermitten.backpacks.api/-backpacks/index.md). It is implied that the implementation of this class will hold a reference to the effective singleton of [Backpacks](../me.bristermitten.backpacks.api/-backpacks/index.md).`interface BackpacksLoader` |
| [FileBasedBackpacksLoader](-file-based-backpacks-loader/index.md) | Main implementation of [BackpacksLoader](-backpacks-loader/index.md).`class FileBasedBackpacksLoader : `[`BackpacksLoader`](-backpacks-loader/index.md) |
| [ItemBagSerializer](-item-bag-serializer/index.md) | KotlinX serializer for an [ItemBag](../me.bristermitten.backpacks.entity/-item-bag/index.md).`object ItemBagSerializer : KSerializer<`[`ItemBag`](../me.bristermitten.backpacks.entity/-item-bag/index.md)`>` |
| [ItemStackSerializer](-item-stack-serializer/index.md) | KotlinX Serializer for an [ItemStack](#).`object ItemStackSerializer : KSerializer<ItemStack>` |
| [MaterialSerializer](-material-serializer/index.md) | KotlinX Serializer for [Material](#).`object MaterialSerializer : KSerializer<Material>` |
| [UUIDSerializer](-u-u-i-d-serializer/index.md) | KotlinX Serializer for [UUID](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`object UUIDSerializer : KSerializer<`[`UUID`](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`>` |
