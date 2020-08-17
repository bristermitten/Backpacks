package me.bristermitten.backpacks.persistence

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.cbor.Cbor
import me.bristermitten.backpacks.api.Backpack
import me.bristermitten.backpacks.api.Backpacks
import me.bristermitten.backpacks.entity.BackpackEntity
import java.io.File
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

/**
 * Main implementation of [BackpacksLoader].
 *
 * This uses [Cbor] combined with GZIP for concise data storage.
 */
@ExperimentalSerializationApi
class FileBasedBackpacksLoader(
		private val backpacks: Backpacks,
		private val backpacksDirectory: File
) : BackpacksLoader
{
	private val cbor = Cbor


	override fun load()
	{
		val files = backpacksDirectory.listFiles() ?: return

		val backpackSet = files
				.map {
					loadBackpack(it)
				}.toSet()

		backpacks.load(backpackSet)
	}


	override fun save()
	{
		backpacks.all.filterIsInstance<BackpackEntity>().forEach {
			val file = backpacksDirectory.resolve(it.uuid.toString())
			file.createNewFile()
			saveBackpack(file, it)
		}
	}

	private fun loadBackpack(file: File): Backpack
	{
		val input = GZIPInputStream(file.inputStream())
		val cborContent = input.use(GZIPInputStream::readBytes)
		return cbor.decodeFromByteArray(BackpackEntity.serializer(), cborContent)
	}

	private fun saveBackpack(file: File, backpack: BackpackEntity)
	{
		val output = GZIPOutputStream(file.outputStream())
		output.use {
			val bytes = cbor.encodeToByteArray(BackpackEntity.serializer(), backpack)
			it.write(bytes)
		}
	}

}
