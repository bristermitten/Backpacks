package me.bristermitten.backpacks.event

import me.bristermitten.backpacks.api.BackpackFormatter
import me.bristermitten.backpacks.api.Backpacks
import me.bristermitten.backpacks.utils.firstNotFullBackpackSlot
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class ItemGainListener(
        private val backpackFormatter: BackpackFormatter,
        private val backpacks: Backpacks
) : Listener
{

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    fun BlockBreakEvent.onPickup()
    {
        val inventory = player.inventory
        val firstEmpty = inventory.firstEmpty()
        if (firstEmpty != -1)
        {
            return
        } //Items only added to a backpack if the inv is full
        val backpackSlot = inventory.firstNotFullBackpackSlot()
        if (backpackSlot == -1) return //ie all backpacks are full

        val backpackItem = inventory.getItem(backpackSlot) ?: return
        val backpack = backpacks.getBackpackByItem(backpackItem) ?: return //Should never be null

        val drops = block.getDrops(player.inventory.itemInMainHand, player)
        if (drops.isEmpty()) return

        backpack.addItems(*drops.toTypedArray())
        inventory.setItem(backpackSlot, backpackFormatter.updateItem(backpack, backpackItem))

        isCancelled = true
        block.type = Material.AIR
        player.giveExp(this.expToDrop)

    }
}
