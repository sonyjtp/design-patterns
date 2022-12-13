package com.octave.pattern.behavioral.strategy

/**
 * Composition: Artist HAS-A Skill
 * */
sealed interface Artist {
    fun perform()
}

class Dancer(private val name: String) : Artist {

    private val performance = Dancing

    override fun perform() {
        performance.perform(name)
    }
}

class Singer(private val name: String) : Artist {

    private val performance = Singing

    override fun perform() {
        performance.perform(name)
    }
}