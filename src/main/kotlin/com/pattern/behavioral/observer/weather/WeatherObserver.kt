package com.pattern.behavioral.observer.weather

import com.pattern.behavioral.observer.Observer

interface WeatherObserver : Observer<WeatherData> {

    fun update(currState: WeatherData, newState: WeatherData) {
        currState.temperature = newState.temperature
        currState.pressure = newState.pressure
        currState.humidity = newState.humidity
    }
}

