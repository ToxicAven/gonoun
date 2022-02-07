package dev.toxicaven.gonoun.commands

import dev.toxicaven.gonoun.Command
import dev.toxicaven.gonoun.util.RandomColor
import org.javacord.api.entity.message.embed.EmbedBuilder
import org.javacord.api.event.Event
import org.javacord.api.event.message.MessageCreateEvent

class HelpCommand: Command("help") {
    override fun execute(event: Event, args: Array<String>) {
        val embed = EmbedBuilder()
            .setTitle("Gonoun Help")
            .setDescription("`]get` - get a users preferred pronouns\n" +
                "`]set` - get the link to set your preferred pronouns\n" +
                "`]help` - get this message")
            .setColor(RandomColor().get())
        (event as MessageCreateEvent).channel.sendMessage(embed)
    }
}