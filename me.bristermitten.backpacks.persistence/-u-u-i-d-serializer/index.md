[Backpacks](../../index.md) / [me.bristermitten.backpacks.persistence](../index.md) / [UUIDSerializer](./index.md)

# UUIDSerializer

`object UUIDSerializer : KSerializer<`[`UUID`](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`>`

KotlinX Serializer for [UUID](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)

The [UUID](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html) is encoded as its String representation.

### Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | `val descriptor: SerialDescriptor` |

### Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | `fun deserialize(decoder: Decoder): `[`UUID`](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html) |
| [serialize](serialize.md) | `fun serialize(encoder: Encoder, value: `[`UUID`](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
