package com.pattern.behavioral.observer

sealed interface Observer {
    fun update(params: Map<String, String>)

    fun display(params: Map<String, String>) = params.keys.map { (println("$it: ${params[it]}")) }
}

object AirportWeatherDisplay : Observer {
    override fun update(params: Map<String, String>) {
        println("Airport")
        display(params)
    }

}

object CityCenterWeatherDisplay : Observer {
    override fun update(params: Map<String, String>) {
        println("City Center")
        display(params)
    }
}

object StadiumWeatherDisplay : Observer {
    override fun update(params: Map<String, String>) {
        println("Stadium")
        display(params)
    }
}
