package com.pattern.creational.singleton

/**
 * Contrary to how we have it in Java, in Kotlin we do not need a private constructor and a static `getInstance()`
 * method to create a singleton object. We can just declare an `object` in place of a `class`
 */
fun main() {
    Logger.print("Calling singleton instance $Logger")
    Logger.print("Calling singleton instance $Logger again")
}


object Logger {

    fun print(line: String) = println(line)
}
