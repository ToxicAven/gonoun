package dev.toxicaven.gonoun

import dev.toxicaven.gonoun.commands.GetCommand
import dev.toxicaven.gonoun.commands.HelpCommand
import dev.toxicaven.gonoun.commands.SetCommand
import org.javacord.api.DiscordApi
import org.javacord.api.DiscordApiBuilder
import java.io.File
import kotlin.system.exitProcess

class Gonoun() {
    val prefix = "]"

    fun start(t: String) {
        val bot : DiscordApi

        try {
            bot = DiscordApiBuilder().setToken(t).login().join()
        } catch (e: Exception) {
            println("Could not read token.txt")
            exitProcess(1)
        }

        val commands: List<Command> = listOf(SetCommand(), GetCommand(), HelpCommand())
        val cmdManager = CommandManager()

        commands.forEach {
            cmdManager.registerCommand(it)
        }

        bot.addMessageCreateListener {
            if (it.message.content.startsWith(prefix)) {
                val message = it.message.content.substring(prefix.length)
                val split = message.split(" ")
                val command = split[0]
                val args = split.drop(1)
                cmdManager.getCommand(command)?.execute(it, args.toTypedArray()) ?: return@addMessageCreateListener
            }
        }
    }
}