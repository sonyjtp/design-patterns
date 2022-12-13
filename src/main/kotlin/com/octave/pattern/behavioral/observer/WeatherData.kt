package com.octave.pattern.behavioral.observer

class WeatherData: Subject {
    private var temperature: Double = 0.0
    private var humidity: Double = 0.0
    private var pressure: Double = 0.0
    private val observers = mutableListOf<Observer>()


    override fun registerObserver(observer: Observer) = observers.add(observer)

    override fun removeObserver(observer: Observer) = observers.remove(observer)

    override fun notifyObservers() {
        for(observer in observers) {
            observer.update(temperature, humidity, pressure)
        }
    }

    override fun updateState(temperature: Double, humidity: Double, pressure: Double) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        notifyObservers()
    }


}
