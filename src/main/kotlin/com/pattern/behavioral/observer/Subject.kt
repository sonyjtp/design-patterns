package com.pattern.behavioral.observer

sealed interface Subject {
    fun register(observer: Observer): Boolean
    fun remove(observer: Observer): Boolean
    fun notifyObservers()
    fun updateState(params: Map<String, String>)
}

class WeatherData : Subject {
    private var weatherParams: Map<String, String> = mapOf()
    val observers = mutableListOf<Observer>()


    override fun register(observer: Observer) = observers.add(observer)

    override fun remove(observer: Observer) = observers.remove(observer)

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(this.weatherParams)
        }
    }

    override fun updateState(params: Map<String, String>) {
        this.weatherParams = params
        notifyObservers()
    }
}
