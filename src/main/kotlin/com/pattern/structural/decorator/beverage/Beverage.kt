package com.pattern.structural.decorator.beverage

import com.pattern.structural.decorator.Decorated
import com.pattern.structural.decorator.Decorator


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
