package com.pattern.creational.factory.simple


/**
 * Simple Factory pattern has an abstract interface for creating one product - pizza in this case. Each subclass
 * of the interface has its own factory and decides which concrete class (product) to instantiate.
 */
fun main() {
    var pizzaStore: PizzaStore = NyPizzaStore
    pizzaStore.create("cheese").prepare()
    pizzaStore.create("pepperoni").prepare()
    pizzaStore = ChicagoPizzaStore
    pizzaStore.create("cheese").prepare()
    pizzaStore.create("pepperoni").prepare()
}

sealed interface Pizza {
    fun prepare()
}

object NyCheesePizza : Pizza {
    override fun prepare() = println("Preparing New York Cheese Pizza")
}

object ChicagoCheesePizza : Pizza {
    override fun prepare() = println("Preparing Chicago Cheese Pizza")
}

object NyPepperoniPizza : Pizza {
    override fun prepare() = println("Preparing New York Pepperoni Pizza")
}

object ChicagoPepperoniPizza : Pizza {
    override fun prepare() = println("Preparing Chicago Pepperoni Pizza")
}

sealed interface PizzaStore {
    fun create(type: String): Pizza // factory method. each subclass has its own concrete factory
}

object NyPizzaStore : PizzaStore {
    override fun create(type: String): Pizza {
        return when (type) {
            "cheese" -> NyCheesePizza
            "pepperoni" -> NyPepperoniPizza
            else -> throw IllegalArgumentException("Not available!")
        }
    }
}

object ChicagoPizzaStore : PizzaStore {
    override fun create(type: String): Pizza {
        return when (type) {
            "cheese" -> ChicagoCheesePizza
            "pepperoni" -> ChicagoPepperoniPizza
            else -> throw IllegalArgumentException("Not available!")
        }
    }
}


