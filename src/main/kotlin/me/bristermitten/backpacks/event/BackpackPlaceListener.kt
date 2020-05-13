package me.bristermitten.backpacks.event

import me.bristermitten.backpacks.utils.isBackpack
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class BackpackPlaceListener : Listener
{
    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    fun BlockPlaceEvent.onPlace()
    {
        if (itemInHand.isBackpack())
        {
            isCancelled = true
        }
    }
}
