package com.pattern.behavioral.strategy

/**
 * Composition: Artist HAS-A Skill
 * */
sealed interface Artist {
    fun perform()
}

class Dancer(private val name: String) : Artist {

    override fun perform() {
        Dancing.perform(name)
    }
}

class Singer(private val name: String) : Artist {

    override fun perform() {
        Singing.perform(name)
    }
}