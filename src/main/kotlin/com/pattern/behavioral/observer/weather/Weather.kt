package com.pattern.behavioral.observer.weather

import com.pattern.behavioral.observer.Subject

class Weather(
    private val observers: MutableList<WeatherObserver>,
    private var state: WeatherData
) : Subject<WeatherObserver, WeatherData> {

    override fun registerObserver(observer: WeatherObserver): Boolean {
        return observers.add(observer).also { println("Registered observer $observer") }
    }

    override fun removeObserver(observer: WeatherObserver): Boolean {
        return observers.remove(observer).also { println("Removed observer: $observer") }
    }

    override fun update(newState: WeatherData) {
        println("State changed: $newState")
        this.state.temperature = newState.temperature
        this.state.humidity = newState.humidity
        this.state.pressure = newState.pressure
        notifyObservers()
    }

    override fun getObservers(): List<WeatherObserver> = this.observers

    private fun notifyObservers() {
        println("Notifying WeatherObservers")
        for (observer in observers) {
            observer.update(state)
        }
    }
}
