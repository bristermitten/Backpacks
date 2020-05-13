package me.bristermitten.backpacks.persistence

import com.google.common.collect.Multimaps
import kotlinx.serialization.*
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.list
import me.bristermitten.backpacks.entity.ItemBag

/**
 * KotlinX serializer for an [ItemBag].
 *
 * This serializes an [ItemBag] as a Map<Material, List<ItemStack>>
 */
@Serializer(forClass = ItemBag::class)
object ItemBagSerializer : KSerializer<ItemBag>
{
    override val descriptor = PrimitiveDescriptor("BlockSet", PrimitiveKind.STRING)

    @Suppress("UnstableApiUsage")
    @ImplicitReflectionSerializer
    override fun deserialize(decoder: Decoder): ItemBag
    {
        val data = decoder.decode(MapSerializer(MaterialSerializer, ItemStackSerializer.list))

        val blockSet = ItemBag()
        data.forEach {
            blockSet.data.putAll(it.key, it.value)
        }
        return blockSet
    }

    @Suppress("UnstableApiUsage")
    @ImplicitReflectionSerializer
    override fun serialize(encoder: Encoder, value: ItemBag)
    {
        encoder.encode(
                MapSerializer(MaterialSerializer, ItemStackSerializer.list),
                Multimaps.asMap(value.data)
        )
    }
}
