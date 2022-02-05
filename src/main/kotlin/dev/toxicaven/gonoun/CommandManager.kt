package dev.toxicaven.gonoun

class CommandManager {
    private val commands = mutableMapOf<String, Command>()

    fun registerCommand(command: Command) {
        commands[command.name] = command
    }

    fun getCommand(name: String): Command? {
        return commands[name]
    }
}