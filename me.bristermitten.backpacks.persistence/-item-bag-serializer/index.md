[Backpacks](../../index.md) / [me.bristermitten.backpacks.persistence](../index.md) / [ItemBagSerializer](./index.md)

# ItemBagSerializer

`object ItemBagSerializer : KSerializer<`[`ItemBag`](../../me.bristermitten.backpacks.entity/-item-bag/index.md)`>`

KotlinX serializer for an [ItemBag](../../me.bristermitten.backpacks.entity/-item-bag/index.md).

This serializes an [ItemBag](../../me.bristermitten.backpacks.entity/-item-bag/index.md) as a Map&lt;Material, List&gt;

### Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | `val descriptor: SerialDescriptor` |

### Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | `fun deserialize(decoder: Decoder): `[`ItemBag`](../../me.bristermitten.backpacks.entity/-item-bag/index.md) |
| [serialize](serialize.md) | `fun serialize(encoder: Encoder, value: `[`ItemBag`](../../me.bristermitten.backpacks.entity/-item-bag/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
