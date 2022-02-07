package dev.toxicaven.gonoun

import dev.toxicaven.gonoun.commands.GetCommand
import dev.toxicaven.gonoun.commands.HelpCommand
import dev.toxicaven.gonoun.commands.SetCommand
import org.javacord.api.DiscordApi
import org.javacord.api.DiscordApiBuilder
import kotlin.system.exitProcess

class Gonoun {
    companion object {
      @JvmStatic
      fun main(args: Array<String>) {
          val gonoun = Gonoun()
          gonoun.start(args[0])
        }
    }

    val prefix = ";"

    fun start(t: String) {
        val bot : DiscordApi

        if (t.isBlank()) {
            println("Please provide a token!")
            exitProcess(1)
        }

        try {
            bot = DiscordApiBuilder().setToken(t).login().join()
            println("Logged in as ${bot.yourself.name}#${bot.yourself.discriminator}")
        } catch (e: Exception) {
            e.printStackTrace()
            exitProcess(1)
        }

        val commands: List<Command> = listOf(SetCommand(), GetCommand(), HelpCommand())
        val cmdManager = CommandManager()

        commands.forEach {
            cmdManager.registerCommand(it)
            println("registered command '${it.name}'")
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