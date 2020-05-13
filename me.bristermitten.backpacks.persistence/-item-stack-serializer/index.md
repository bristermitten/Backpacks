[Backpacks](../../index.md) / [me.bristermitten.backpacks.persistence](../index.md) / [ItemStackSerializer](./index.md)

# ItemStackSerializer

`object ItemStackSerializer : KSerializer<ItemStack>`

KotlinX Serializer for an [ItemStack](#).

This serializes an ItemStack using [BukkitObjectOutputStream](#) and encodes the data to Base64.

### Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | `val descriptor: SerialDescriptor` |

### Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | `fun deserialize(decoder: Decoder): ItemStack` |
| [serialize](serialize.md) | `fun serialize(encoder: Encoder, value: ItemStack): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
