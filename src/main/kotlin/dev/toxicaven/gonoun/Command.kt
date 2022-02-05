package dev.toxicaven.gonoun

import org.javacord.api.event.Event

abstract class Command(var name: String) {
    abstract fun execute(event: Event, args: Array<String>)
}