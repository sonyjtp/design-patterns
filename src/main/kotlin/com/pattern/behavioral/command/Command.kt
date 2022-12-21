package com.pattern.behavioral.command

sealed interface Command {
    fun execute()
}

class Light {
    var on = false
}
class GarageDoor {
    var open = false
}


class ToggleLightButton: Command {

    private var light = Light()
    override fun execute() {
        light.on = !light.on
        println("Light is now ${if(light.on) "off" else "on"}")
    }
}

class ToggleGarageDoor: Command {

    private var garageDoor = GarageDoor()
    override fun execute() {
        garageDoor.open = !garageDoor.open
        println("Garage door is now ${if(garageDoor.open) "open" else "closed"}")
    }
}

class Remote {

    lateinit var command: Command
    fun invoke()  = command.execute()

}

