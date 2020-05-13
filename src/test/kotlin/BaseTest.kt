package me.bristermitten.backpacks

import be.seeseemelk.mockbukkit.MockBukkit
import me.bristermitten.backpacks.api.Backpacks
import me.bristermitten.backpacks.entity.BackpackEntity
import me.bristermitten.backpacks.entity.BackpackStore
import me.bristermitten.backpacks.persistence.BackpacksLoader
import me.bristermitten.backpacks.persistence.FileBasedBackpacksLoader
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.hamcrest.Matchers.*
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File

class BaseTest
{
    @Before
    fun setUp()
    {
        MockBukkit.mock()
    }

    @After
    fun tearDown()
    {
        MockBukkit.unload()
    }

    @Test
    fun assertBasicBackpacksFunctionality()
    {
        val backpacks: Backpacks = BackpackStore()
        val backpack = backpacks.createBackpack(30)
        val item = ItemStack(Material.STONE, 30)

        backpack.addItems(item)

        assertThat(item, isIn(backpack.items))
        assertThat(backpack, isIn(backpacks.all))
        assertThat(BackpackEntity(10), not(isIn(backpacks.all)))
        assertThat(backpack, equalTo(backpacks.getBackpackById(backpack.uuid)))
        assertThat(backpack, equalTo(backpacks[backpack.uuid]))
    }

    @Test
    fun assertLoadingAndSavingFromJson()
    {
        val backpacks: Backpacks = BackpackStore()
        val backpack = backpacks.createBackpack(30)
        val item = ItemStack(Material.STONE, 30)
        backpack.addItems(item)

        val backpacksDirectory = File("backpacks/")
        backpacksDirectory.mkdir()
        val loader: BackpacksLoader = FileBasedBackpacksLoader(backpacks, backpacksDirectory)

        loader.save()

        loader.load()

        assertThat(backpack, isIn(backpacks.all))

    }
}
