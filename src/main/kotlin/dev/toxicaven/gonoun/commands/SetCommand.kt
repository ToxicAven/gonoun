package dev.toxicaven.gonoun.commands

import dev.toxicaven.gonoun.Command
import dev.toxicaven.gonoun.util.PastelColor
import org.javacord.api.entity.message.embed.EmbedBuilder
import org.javacord.api.event.Event
import org.javacord.api.event.message.MessageCreateEvent
import java.awt.Color
import kotlin.random.Random


class SetCommand: Command("set") {
    override fun execute(event: Event, args: Array<String>) {
        val inEvent = event as MessageCreateEvent
        val colors = listOf<Color>(Color.pink, Color.blue, Color.white)

        val embed = EmbedBuilder()
            .setTitle("Click here to register your pronouns!")
            .setUrl("https://pronoundb.org/register")
            .setColor(PastelColor().get())
            .setDescription("Select the `Connect with Discord` button so I can see them!")
        inEvent.channel.sendMessage(embed)
    }
}
