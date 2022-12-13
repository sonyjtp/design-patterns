package com

import com.pattern.behavioral.decorator.*
import com.pattern.behavioral.observer.AirportWeatherDisplay
import com.pattern.behavioral.observer.CityCenterWeatherDisplay
import com.pattern.behavioral.observer.Subject
import com.pattern.behavioral.observer.WeatherData
import com.pattern.behavioral.strategy.Artist
import com.pattern.behavioral.strategy.Dancer
import com.pattern.behavioral.strategy.Singer
import java.lang.Thread.sleep

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        callStrategy()
        callObserver()
        callDecorator()
    }

    /**
     * Strategy Pattern - (1) define a family of algorithms, (2) encapsulate each one
     *  and (3) make them interchangeable. Strategy pattern lets the algorithm vary independently
     *  from clients that use it
     *  1 - Family of algorithms - Artist can sing or dance
     *  2 - Performance isn't tied to the Artist and performance behaviour is encapsulated
     *      Singer is-a Artist
     *      Dancer is-a Artist
     *      3 - Make them interchangeable - Make Yesudas dance.
     * Artist has a perform() method that is overridden by Singer and Dancer
     * Singing and Dancing have perform() methods
     */
    private fun callStrategy() {
        var artist1: Artist = Singer("Yesudas")
        val artist2: Artist = Dancer("Shobhana")
        artist1.perform()
        artist2.perform()
        artist1 = Dancer("Yesudas")
        artist1.perform()
    }

    /**
     * Observer Pattern - defines a one-to-many dependency between objects so that
     * when one object's stage changes, all of its dependents are notified and
     * updated automatically.
     * -    Subject is only aware of an Observer Interface. Doesn't know about its
     *      implementation.
     * -    Add/remove observers any time without modifying subject's code.
     * -    Reuse/change subjects/observers independently of each other.
     */
    private fun callObserver() {
        val subject: Subject = WeatherData()
        val observer2 = CityCenterWeatherDisplay
        subject.registerObserver(AirportWeatherDisplay)
        subject.registerObserver(observer2)
        subject.updateState(32.7, 78.5, 30.25)
        sleep(1000)
        println()
        subject.removeObserver(observer2)
        subject.updateState(33.7, 78.1, 30.18)
    }

    /**
     * Decorators have the same type as the objects they decorate. Decorators add their own behavior to the object
     * that it decorates. Decorators use inheritance for type-matching and composition to get behaviour.
     */
    private fun callDecorator() {
        val beverage1: Beverage = Espresso
        println("Beverage 1: ${beverage1.getDescription()}\tCost: ${beverage1.cost()}")
        var beverage2: Beverage = HouseBlend
        beverage2 = Mocha(beverage2)
        println("Beverage 2: ${beverage2.getDescription()}\tCost: ${beverage2.cost()}")
        println("I need more decorations...")
        beverage2 = Milk(Soy(Whip(beverage2)))
        println("Beverage 2: ${beverage2.getDescription()}\tCost: ${beverage2.cost()}")



    }
}