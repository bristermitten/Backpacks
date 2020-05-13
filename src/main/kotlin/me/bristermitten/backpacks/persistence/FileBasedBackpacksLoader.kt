package me.bristermitten.backpacks.persistence

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.cbor.Cbor
import me.bristermitten.backpacks.api.Backpack
import me.bristermitten.backpacks.api.Backpacks
import me.bristermitten.backpacks.entity.BackpackEntity
import java.io.File
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

class FileBasedBackpacksLoader(
        private val backpacks: Backpacks,
        private val backpacksDirectory: File
) : BackpacksLoader
{
    private val cbor = Cbor

    @ImplicitReflectionSerializer
    override fun load()
    {
        val files = backpacksDirectory.listFiles() ?: return

        val backpackSet = files
                .map {
                    loadBackpack(it)
                }.toSet()

        backpacks.load(backpackSet)
    }

    @ImplicitReflectionSerializer
    override fun save()
    {
        backpacks.all.mapNotNull {
            it as? BackpackEntity?
        }.forEach {
            val file = backpacksDirectory.resolve(it.uuid.toString())
            file.createNewFile()
            saveBackpack(file, it)
        }
    }

    @ImplicitReflectionSerializer
    private fun loadBackpack(file: File): Backpack
    {
        val input = GZIPInputStream(file.inputStream())
        val cborContent = input.use { it.readBytes() }
        return cbor.load(BackpackEntity.serializer(), cborContent)
    }

    @ImplicitReflectionSerializer
    private fun saveBackpack(file: File, backpack: BackpackEntity)
    {
        val output = GZIPOutputStream(file.outputStream())
        output.use {
            val bytes = cbor.dump(BackpackEntity.serializer(), backpack)
            it.write(bytes)
        }
    }
}
