package com.pattern.behavioral.command


/**
 * Command pattern to encapsulate invocations. It has a caller, a set of commands classes that implement a Command
 * interface and an invoker that has the command invocation method with a setter method that takes the command.
 * Command command
 */
fun main() {
    val remote = Remote() //invoker
    remote.command = ToggleLightButton(Light)
    remote.invoke()
    remote.invoke()
    remote.command = ToggleGarageDoor(GarageDoor)
    remote.invoke()
    remote.invoke()
}

sealed interface Command {
    fun execute()
}

object Light {
    var on = false
}

object GarageDoor {
    var open = false
}

class ToggleLightButton(private val light: Light) : Command {

    override fun execute() {
        light.on = !light.on
        println("Light is now ${if (light.on) "off" else "on"}")
    }
}

class ToggleGarageDoor(private val garageDoor: GarageDoor) : Command {

    override fun execute() {
        garageDoor.open = !garageDoor.open
        println("Garage door is now ${if (garageDoor.open) "open" else "closed"}")
    }
}

class Remote {
    lateinit var command: Command
    fun invoke()  = command.execute()

}

