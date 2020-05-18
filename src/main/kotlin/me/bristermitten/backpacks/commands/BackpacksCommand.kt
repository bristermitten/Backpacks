package me.bristermitten.backpacks.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.CommandHelp
import co.aikar.commands.annotation.*
import co.aikar.commands.bukkit.contexts.OnlinePlayer
import me.bristermitten.backpacks.api.BackpackFormatter
import me.bristermitten.backpacks.api.Backpacks
import me.bristermitten.backpacks.utils.color
import me.bristermitten.backpacks.utils.getBackpackUUID
import me.bristermitten.backpacks.utils.isBackpack
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Main Command handler for Backpacks.
 */
@CommandAlias("backpacks|backpack")
class BackpacksCommand(
        private val backpacks: Backpacks,
        private val backpackFormatter: BackpackFormatter
) : BaseCommand()
{

    @Default
    @HelpCommand
    fun showHelp(help: CommandHelp)
    {
        help.showHelp()
    }

    @Subcommand("give")
    @Description("Give a player a backpack")
    @CommandPermission("backpacks.give")
    @CommandCompletion("@players")
    fun giveBackpack(sender: CommandSender, target: OnlinePlayer, @Optional @Conditions("unsigned") size: Int?)
    {
        val backpack = if (size == null)
        {
            backpacks.createBackpack()
        } else
        {
            backpacks.createBackpack(size)
        }

        val backpackItem = backpackFormatter.createItem(backpack)
        target.player.inventory.addItem(backpackItem)
        sender.sendMessage("&aBackpack Given!".color())
    }

    @Subcommand("set")
    @Description("Set a backpack's size")
    @CommandPermission("backpacks.set")
    fun setBackpackSize(sender: Player, @Conditions("unsigned") size: Int)
    {
        val hand = sender.inventory.itemInMainHand
        if (!hand.isBackpack())
        {
            sender.sendMessage("&cThis item is not a backpack!".color())
            return
        }

        val backpack = backpacks[hand.getBackpackUUID()] ?: return
        backpack.size = size
        sender.inventory.setItemInMainHand(backpackFormatter.updateItem(backpack, hand))
        sender.sendMessage("&aSize set!".color())
    }
}
