package com.pattern.behavioral.strategy

sealed interface Performance {
    fun perform(artistName: String)
}

object Dancing : Performance {
    override fun perform(artistName: String) {
        println("$artistName is dancing")
    }
}

object Singing : Performance {
    override fun perform(artistName: String) {
        println("$artistName is singing")
    }
}