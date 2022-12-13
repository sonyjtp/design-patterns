package com.pattern.behavioral.observer

sealed interface Observer {
    fun update(temperature: Double, humidity: Double, pressure: Double)

}

object AirportWeatherDisplay : Observer {
    override fun update(temperature: Double, humidity: Double, pressure: Double) {
        println("Airport\t\tTemperature: $temperature C\t\tHumidity: $humidity%\tPressure: $pressure in")
    }
}

object CityCenterWeatherDisplay : Observer {
    override fun update(temperature: Double, humidity: Double, pressure: Double) {
        println("City Center\tTemperature: ${(temperature * 9 / 5 + 32)} F\tHumidity: $humidity%\tPressure: ${1000 + pressure} mb")
    }
}