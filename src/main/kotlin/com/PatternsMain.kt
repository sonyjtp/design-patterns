package com

import com.pattern.behavioral.strategy.Artist
import com.pattern.behavioral.strategy.Dancer
import com.pattern.behavioral.strategy.Singer
import com.pattern.creational.singleton.Logger

object PatternsMain {

    @JvmStatic
    fun main(args: Array<String>) = when (readlnOrNull()) {
        "strategy" -> callStrategy()
        "singleton" -> callSingleton()
        "command" -> callCommand()
        else -> throw IllegalArgumentException("invalid!")
    }

    /**
     * Strategy Pattern - (1) define a family of algorithms, (2) encapsulate each one
     *  and (3) make them interchangeable. Strategy pattern lets the algorithm vary independently
     *  from clients that use it
     *  1 - Family of algorithms - Artist can sing or dance
     *  2 - Performance isn't tied to the Artist and performance behaviour is encapsulated
     *      Singer is-a Artist
     *      Dancer is-a Artist
     *  3 - Make them interchangeable - Make Yesudas dance.
     * Artist has a perform() method that is overridden by Singer and Dancer
     * Singing and Dancing have perform() methods
     */
    private fun callStrategy() {
        var artist1: Artist = Singer("Yesudas")
        val artist2: Artist = Dancer("Shobhana")
        artist1.perform()
        artist2.perform()


        artist1 = Dancer("Yesudas")
        artist1.perform()
    }


    /**
     * Contrary to how we have it in Java, in Kotlin we do not need a private constructor and a static `getInstance()`
     * method to create a singleton object. We can just declare an `object` in place of a `class`
     */
    private fun callSingleton() {
        Logger.print("Calling singleton instance $Logger")
        Logger.print("Calling singleton instance $Logger again")
    }

    /**
     * Command pattern to encapsulate invocations. It has a caller, a set of commands classes that implement a Command
     * interface and an invoker that has the command invocation method with a setter method that takes the command.
     * Command command
     */
    private fun callCommand() {
//       val remote = Remote() //invoker
//        remote.command = ToggleLightButton() //first command
//        remote.invoke()
//        remote.invoke()
//        remote.command = ToggleGarageDoor() //second command t
//        remote.invoke()
//        remote.invoke()
    }
}
