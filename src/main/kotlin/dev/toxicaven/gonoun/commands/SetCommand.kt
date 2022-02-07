package dev.toxicaven.gonoun.commands

import dev.toxicaven.gonoun.Command
import dev.toxicaven.gonoun.util.RandomColor
import org.javacord.api.entity.message.embed.EmbedBuilder
import org.javacord.api.event.Event
import org.javacord.api.event.message.MessageCreateEvent


class SetCommand: Command("set") {
    override fun execute(event: Event, args: Array<String>) {
        val inEvent = event as MessageCreateEvent

        val embed = EmbedBuilder()
            .setTitle("Click here to register your pronouns!")
            .setUrl("https://pronoundb.org/register")
            .setColor(RandomColor().get())
            .setDescription("Select the `Connect with Discord` button so I can see them!")
        inEvent.channel.sendMessage(embed)
    }
}
