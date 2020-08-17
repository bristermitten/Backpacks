package me.bristermitten.backpacks.persistence

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.bukkit.inventory.ItemStack
import org.bukkit.util.io.BukkitObjectInputStream
import org.bukkit.util.io.BukkitObjectOutputStream
import java.io.ByteArrayOutputStream
import java.util.*

/**
 * KotlinX Serializer for an [ItemStack].
 *
 * This serializes an ItemStack using [BukkitObjectOutputStream] and encodes the data to Base64.
 */
object ItemStackSerializer : KSerializer<ItemStack>
{
	override val descriptor = PrimitiveSerialDescriptor("ItemStack", PrimitiveKind.STRING)

	override fun deserialize(decoder: Decoder): ItemStack
	{
		val base64 = Base64.getDecoder().decode(decoder.decodeString())
		val bytes = base64.inputStream()
		bytes.use {
			val input = BukkitObjectInputStream(it)
			return input.readObject() as ItemStack
		}
	}

	override fun serialize(encoder: Encoder, value: ItemStack)
	{
		val bytesOut = ByteArrayOutputStream()
		BukkitObjectOutputStream(bytesOut).use {
			it.writeObject(value)
		}
		val base64 = Base64.getEncoder().encodeToString(bytesOut.toByteArray())
		encoder.encodeString(base64)
	}
}
