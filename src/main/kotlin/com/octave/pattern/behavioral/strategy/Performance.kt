package com.octave.pattern.behavioral.strategy

sealed interface Performance  {
    fun perform(artistName: String)
}

object Dancing : Performance {
    override fun perform(artistName: String) {
        println("I am $artistName. I am dancing")
    }
}

object Singing : Performance {
    override fun perform(artistName: String) {
        println("I am $artistName. I am singing")
    }
}