package me.bristermitten.backpacks.persistence

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.bukkit.Material

/**
 * KotlinX Serializer for [Material].
 *
 * (JetBrains, default enum serializers when?)
 */
object MaterialSerializer : KSerializer<Material>
{
    override val descriptor = PrimitiveSerialDescriptor("Material", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Material
    {
        val name = decoder.decodeString()
        return Material.matchMaterial(name) ?: throw IllegalArgumentException("No such Material $name")
    }

    override fun serialize(encoder: Encoder, value: Material)
    {
        encoder.encodeString(value.name)
    }
}
