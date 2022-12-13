package com.octave.pattern.behavioral.decorator

interface Beverage{
    fun getDescription(): String  = "Basic"
    fun cost(): Double
}

object Espresso: Beverage {
    private const val description: String = "Espresso"
    override fun getDescription(): String  = this.description

    override fun cost()  = 1.99
}

object HouseBlend: Beverage {
    private const val description: String = "HouseBlend"
    override fun getDescription(): String  = this.description
    override fun cost()  = .89
}

sealed class CondimentDecorator(private val beverage: Beverage): Beverage {
    abstract override fun getDescription(): String

}

class Milk(private val beverage: Beverage): CondimentDecorator(beverage) {
    override fun getDescription()  = beverage.getDescription() + ", Milk"
    override fun cost() = beverage.cost() + .25
}

class Mocha(private val beverage: Beverage): CondimentDecorator(beverage) {
    override fun getDescription()  = beverage.getDescription() + ", Mocha"
    override fun cost() = beverage.cost() + .2
}

class Soy(private val beverage: Beverage): CondimentDecorator(beverage) {
    override fun getDescription()  = beverage.getDescription() + ", Soy"
    override fun cost() = beverage.cost() + .15
}

class Whip(private val beverage: Beverage): CondimentDecorator(beverage) {
    override fun getDescription()  = beverage.getDescription() + ", Whip"
    override fun cost() = beverage.cost() + .18
}