package com.pattern.behavioral.observer

interface Subject {
    fun registerObserver(observer: Observer): Boolean
    fun removeObserver(observer: Observer): Boolean
    fun notifyObservers()
    fun updateState(temperature: Double, humidity: Double, pressure: Double)
}