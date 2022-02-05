package dev.toxicaven.gonoun.commands

import dev.toxicaven.gonoun.Command
import dev.toxicaven.gonoun.util.PDBCaller
import dev.toxicaven.gonoun.util.PastelColor
import dev.toxicaven.gonoun.util.Pronouns
import org.javacord.api.entity.message.embed.EmbedBuilder
import org.javacord.api.event.Event
import org.javacord.api.event.message.MessageCreateEvent

class GetCommand : Command("get") {
    override fun execute(event: Event, args: Array<String>) {
        val ev = event as MessageCreateEvent
        val userName: String
        val user: String = if (ev.message.mentionedUsers.isNotEmpty()) {
            userName = ev.message.mentionedUsers[0].name
            println("called API for a mentioned user")
            ev.message.mentionedUsers[0].id.toString()
        } else if (args.isNotEmpty()) {
            println("called API for a UserID")
            try {
                userName = ev.api.getUserById(args[0]).get().name
            } catch (unused: Exception) {
                ev.channel.sendMessage("I don't think that user exists in this server, try using their ID instead!")
                return
            }
            args[0]
        } else {
            userName = ev.messageAuthor.name
            println("called API with no args, using message author")
            ev.messageAuthor.id.toString()
        }

        when (PDBCaller().run(user)) {
            Pronouns.ANY.response -> makeAndSendEmbed(ev, userName, Pronouns.ANY, user)
            Pronouns.ASK.response -> makeAndSendEmbed(ev, userName, Pronouns.ASK, user)
            Pronouns.HH.response -> makeAndSendEmbed(ev, userName, Pronouns.HH, user)
            Pronouns.HI.response -> makeAndSendEmbed(ev, userName, Pronouns.HI, user)
            Pronouns.HS.response -> makeAndSendEmbed(ev, userName, Pronouns.HS, user)
            Pronouns.HT.response -> makeAndSendEmbed(ev, userName, Pronouns.HT, user)
            Pronouns.IH.response -> makeAndSendEmbed(ev, userName, Pronouns.IH, user)
            Pronouns.II.response -> makeAndSendEmbed(ev, userName, Pronouns.II, user)
            Pronouns.IS.response -> makeAndSendEmbed(ev, userName, Pronouns.IS, user)
            Pronouns.IT.response -> makeAndSendEmbed(ev, userName, Pronouns.IT, user)
            Pronouns.SHH.response -> makeAndSendEmbed(ev, userName, Pronouns.SHH, user)
            Pronouns.SH.response -> makeAndSendEmbed(ev, userName, Pronouns.SH, user)
            Pronouns.SI.response -> makeAndSendEmbed(ev, userName, Pronouns.SI, user)
            Pronouns.ST.response -> makeAndSendEmbed(ev, userName, Pronouns.ST, user)
            Pronouns.TH.response -> makeAndSendEmbed(ev, userName, Pronouns.TH, user)
            Pronouns.TI.response -> makeAndSendEmbed(ev, userName, Pronouns.TI, user)
            Pronouns.TS.response -> makeAndSendEmbed(ev, userName, Pronouns.TS, user)
            Pronouns.TT.response -> makeAndSendEmbed(ev, userName, Pronouns.TT, user)
            Pronouns.OTHER.response -> makeAndSendEmbed(ev, userName, Pronouns.OTHER, user)
            Pronouns.AVOID.response -> makeAndSendEmbed(ev, userName, Pronouns.AVOID, user)
            else -> makeAndSendEmbed(ev, null, Pronouns.UNSPECIFIED, null)
        }
    }

    private fun makeAndSendEmbed(e: Event, username: String?, pronouns: Pronouns, uid: String?) {
        println("$username, ${pronouns.name}, $uid")
        val embed = EmbedBuilder()
            .setTitle(if (username != null) "$username's pronouns" else "")
            .setDescription((username ?: "") + pronouns.embed)
            .setColor(PastelColor().get())
            .setThumbnail(if (uid != null) e.api.getUserById(uid).get().avatar else null)
        (e as MessageCreateEvent).channel.sendMessage(embed)
    }
}