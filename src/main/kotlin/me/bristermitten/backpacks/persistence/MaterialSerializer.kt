package me.bristermitten.backpacks.persistence

import kotlinx.serialization.*
import org.bukkit.Material

/**
 * KotlinX Serializer for [Material].
 *
 * (JetBrains, default enum serializers when?)
 */
object MaterialSerializer : KSerializer<Material>
{
    override val descriptor: SerialDescriptor = PrimitiveDescriptor("Material", PrimitiveKind.STRING)

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
