package com.pattern.behavioral.observer

import com.pattern.behavioral.observer.weather.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldContainOnly

class ObserverTest : FunSpec({

    test("Observer pattern") {
        val subject: Subject<WeatherObserver, WeatherData> = Weather(mutableListOf(), WeatherData())
        val airportWeatherDisplay = AirportWeatherDisplay()
        val cityCenterWeatherDisplay = CityCenterWeatherDisplay()
        subject.registerObserver(airportWeatherDisplay)
        subject.registerObserver(cityCenterWeatherDisplay)
        subject.getObservers() shouldContainExactlyInAnyOrder mutableListOf(
            airportWeatherDisplay,
            cityCenterWeatherDisplay
        )
        subject.removeObserver(cityCenterWeatherDisplay)
        subject.getObservers() shouldContainOnly mutableListOf(airportWeatherDisplay)
//        subject.update(WeatherData(temperature = 32.7, humidity = 78.5, pressure = 30.25))
//        subject.removeObserver(cityCenterWeatherDisplay)
//        subject.update(WeatherData(temperature = 33.0, humidity = 78.3, pressure = 30.1))
    }
})
