package com.pattern.behavioral.observer

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldContainOnly

class ObserverTest : FunSpec({

    test("Observer pattern") {
        val subject: Subject = WeatherData()
        subject.register(AirportWeatherDisplay)
        subject.register(CityCenterWeatherDisplay)
        val weatherData = subject as WeatherData
        weatherData.observers shouldContainExactlyInAnyOrder mutableListOf(
            CityCenterWeatherDisplay,
            AirportWeatherDisplay
        )
        subject.remove(CityCenterWeatherDisplay)
        weatherData.observers shouldContainOnly mutableListOf(AirportWeatherDisplay)
    }
})
