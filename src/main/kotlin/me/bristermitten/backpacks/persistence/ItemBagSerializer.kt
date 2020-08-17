package me.bristermitten.backpacks.persistence

import com.google.common.collect.Multimaps
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import me.bristermitten.backpacks.entity.ItemBag

/**
 * KotlinX serializer for an [ItemBag].
 *
 * This serializes an [ItemBag] as a Map<Material, List<ItemStack>>
 */
object ItemBagSerializer : KSerializer<ItemBag>
{
	override val descriptor = PrimitiveSerialDescriptor("BlockSet", PrimitiveKind.STRING)
    private val multimapSerializer = MapSerializer(MaterialSerializer, ListSerializer(ItemStackSerializer))

	override fun deserialize(decoder: Decoder): ItemBag
	{
		val data = decoder.decodeSerializableValue(multimapSerializer)

		val blockSet = ItemBag()
		data.forEach {
			blockSet.data.putAll(it.key, it.value)
		}
		return blockSet
	}


	override fun serialize(encoder: Encoder, value: ItemBag)
	{
		encoder.encodeSerializableValue(
                multimapSerializer,
                Multimaps.asMap(value.data).mapValues { it.value.toList() }
        )
	}
}
