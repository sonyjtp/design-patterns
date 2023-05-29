package com.pattern.behavioral.observer.weather

class AirportWeatherDisplay : WeatherObserver {
    private val currState = WeatherData()

    override fun update(t: WeatherData) {
        update(currState, t)
    }
}
