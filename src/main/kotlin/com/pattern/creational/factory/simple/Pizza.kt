package com.pattern.creational.factory.simple


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


