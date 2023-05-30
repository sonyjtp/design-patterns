package com.pattern.structural.decorator.beverage

import com.pattern.structural.decorator.Decorated
import com.pattern.structural.decorator.Decorator


fun main() {
    val beverage1: Beverage = Espresso
    println("Beverage 1: ${beverage1.getDescription()}\t\t\t\t\t\t\t\t: $${beverage1.cost()}")
    var beverage2: Beverage = HouseBlend
    beverage2 = Mocha(beverage2)
    println("Beverage 2: ${beverage2.getDescription()}\t\t\t\t\t\t: $${beverage2.cost()}")
    println("I need more decorations...")
    beverage2 = Milk(Soy(Whip(beverage2)))
    println("Beverage 2: ${beverage2.getDescription()}\t\t: $${beverage2.cost()}")
}


interface Beverage : Decorated {
    fun getDescription(): String
    fun cost(): Double
}

object Espresso : Beverage {
    private const val description: String = "Espresso"
    override fun getDescription(): String = description

    override fun cost() = 1.99
}

object HouseBlend : Beverage {
    private const val description: String = "HouseBlend"
    override fun getDescription(): String = description
    override fun cost() = .89
}

sealed interface CondimentDecorator : Beverage, Decorator

class Milk(private val beverage: Beverage) : CondimentDecorator {
    override fun getDescription() = beverage.getDescription() + ", Milk"
    override fun cost() = beverage.cost() + .25
}

class Mocha(private val beverage: Beverage) : CondimentDecorator {
    override fun getDescription() = beverage.getDescription() + ", Mocha"
    override fun cost() = beverage.cost() + .2
}

class Soy(private val beverage: Beverage) : CondimentDecorator {
    override fun getDescription() = beverage.getDescription() + ", Soy"
    override fun cost() = beverage.cost() + .15
}

class Whip(private val beverage: Beverage) : CondimentDecorator {
    override fun getDescription() = beverage.getDescription() + ", Whip"
    override fun cost() = beverage.cost() + .18
}
