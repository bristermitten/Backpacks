

### All Types

| Name | Summary |
|---|---|
|

##### [me.bristermitten.backpacks.api.Backpack](../me.bristermitten.backpacks.api/-backpack/index.md)

Represents a Backpack.


|

##### [me.bristermitten.backpacks.api.BackpackFormatter](../me.bristermitten.backpacks.api/-backpack-formatter/index.md)

A BackpackFormatter is responsible for converting a [Backpack](../me.bristermitten.backpacks.api/-backpack/index.md) to an [ItemStack](#).


|

##### [me.bristermitten.backpacks.event.BackpackPlaceListener](../me.bristermitten.backpacks.event/-backpack-place-listener/index.md)

Ensures that Backpack items are not placed.


|

##### [me.bristermitten.backpacks.api.Backpacks](../me.bristermitten.backpacks.api/-backpacks/index.md)

Represents the global storage of all Backpacks.


|

##### [me.bristermitten.backpacks.commands.BackpacksCommand](../me.bristermitten.backpacks.commands/-backpacks-command/index.md)

Main Command handler for Backpacks.


|

##### [me.bristermitten.backpacks.persistence.BackpacksConfig](../me.bristermitten.backpacks.persistence/-backpacks-config/index.md)

The serializable wrapper class of config.yml


|

##### [me.bristermitten.backpacks.persistence.BackpacksLoader](../me.bristermitten.backpacks.persistence/-backpacks-loader/index.md)

Defines load and save functions for [Backpacks](../me.bristermitten.backpacks.api/-backpacks/index.md).
It is implied that the implementation of this class will hold a reference to the effective singleton of [Backpacks](../me.bristermitten.backpacks.api/-backpacks/index.md).


|

##### [me.bristermitten.backpacks.BackpacksPlugin](../me.bristermitten.backpacks/-backpacks-plugin/index.md)

The Main class of Backpacks.


| (extensions in package me.bristermitten.backpacks.utils)

##### [kotlin.Double](../me.bristermitten.backpacks.utils/kotlin.-double/index.md)


|

##### [me.bristermitten.backpacks.persistence.FileBasedBackpacksLoader](../me.bristermitten.backpacks.persistence/-file-based-backpacks-loader/index.md)

Main implementation of [BackpacksLoader](../me.bristermitten.backpacks.persistence/-backpacks-loader/index.md).


| (extensions in package me.bristermitten.backpacks.utils)

##### [org.bukkit.inventory.Inventory](../me.bristermitten.backpacks.utils/org.bukkit.inventory.-inventory/index.md)


|

##### [me.bristermitten.backpacks.entity.ItemBag](../me.bristermitten.backpacks.entity/-item-bag/index.md)

The internal data structure used for storing items in a Backpack.


|

##### [me.bristermitten.backpacks.persistence.ItemBagSerializer](../me.bristermitten.backpacks.persistence/-item-bag-serializer/index.md)

KotlinX serializer for an [ItemBag](../me.bristermitten.backpacks.entity/-item-bag/index.md).


|

##### [me.bristermitten.backpacks.entity.format.ItemFormat](../me.bristermitten.backpacks.entity.format/-item-format/index.md)

Serializable data class representing the simple format of an [ItemStack](#).
This is deserialized from config.yml and has placeholders applied in [SimpleBackpackFormatter](#)
to make a Backpack item.


|

##### [me.bristermitten.backpacks.event.ItemGainListener](../me.bristermitten.backpacks.event/-item-gain-listener/index.md)

Updates players' Backpacks if they mine a block and their inventory is full.


| (extensions in package me.bristermitten.backpacks.utils)

##### [org.bukkit.inventory.ItemStack](../me.bristermitten.backpacks.utils/org.bukkit.inventory.-item-stack/index.md)


|

##### [me.bristermitten.backpacks.persistence.ItemStackSerializer](../me.bristermitten.backpacks.persistence/-item-stack-serializer/index.md)

KotlinX Serializer for an [ItemStack](#).


|

##### [me.bristermitten.backpacks.persistence.MaterialSerializer](../me.bristermitten.backpacks.persistence/-material-serializer/index.md)

KotlinX Serializer for [Material](#).


| (extensions in package me.bristermitten.backpacks.utils)

##### [kotlin.String](../me.bristermitten.backpacks.utils/kotlin.-string/index.md)


|

##### [me.bristermitten.backpacks.persistence.UUIDSerializer](../me.bristermitten.backpacks.persistence/-u-u-i-d-serializer/index.md)

KotlinX Serializer for [UUID](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)


