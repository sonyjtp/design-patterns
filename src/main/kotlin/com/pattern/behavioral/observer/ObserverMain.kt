package com.pattern.behavioral.observer

import com.pattern.behavioral.observer.weather.*
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    val subject: Subject<WeatherObserver, WeatherData> = Weather(mutableListOf(), WeatherData())
    val airportWeatherDisplay = AirportWeatherDisplay()
    val cityCenterWeatherDisplay = CityCenterWeatherDisplay()
    subject.registerObserver(airportWeatherDisplay)
    subject.registerObserver(cityCenterWeatherDisplay)
    subject.update(WeatherData(temperature = 32.7, humidity = 78.5, pressure = 30.25))
    subject.removeObserver(cityCenterWeatherDisplay)
    subject.update(WeatherData(temperature = 33.0, humidity = 78.3, pressure = 30.1))
}
