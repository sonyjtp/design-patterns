package com.pattern.creational.factory.abstract


/**
 * Abstract Factory pattern has an abstract interface for creating a family of products - chairs and sofas.
 * It has a set of factory methods, one for each product.
 */
fun main() {
    var chair = FurnitureFactory.createChair("victorian")
    chair.roll()
    chair.pushback()
    chair = FurnitureFactory.createChair("modern")
    chair.roll()
    chair.pushback()
    var sofa = FurnitureFactory.createSofa("victorian")
    sofa.roll()
    sofa.pushback()
    sofa = FurnitureFactory.createSofa("minimalist")
    sofa.roll()
    sofa.pushback()
}

object FurnitureFactory {
    fun createChair(type: String) = ChairFactory.create(type)
    fun createSofa(type: String) = SofaFactory.create(type)
}

sealed interface Chair {
    fun roll()
    fun pushback()
}

object VictorianChair : Chair {
    override fun roll() = println("Rolling Victorian chair")
    override fun pushback() = println("Pushing back Victorian chair")
}

object ModernChair : Chair {
    override fun roll() = println("Rolling Modern chair")
    override fun pushback() = println("Pushing back Modern chair")
}

object ChairFactory {
    fun create(type: String): Chair {
        return when (type) {
            "victorian" -> VictorianChair
            "modern" -> ModernChair
            else -> throw IllegalArgumentException("Chair Type not available!")
        }
    }
}

sealed interface Sofa {
    fun roll()
    fun pushback()
}

object VictorianSofa : Sofa {
    override fun roll() = println("Rolling Victorian sofa")
    override fun pushback() = println("Pushing back Victorian sofa")
}

object MinimalistSofa : Sofa {
    override fun roll() = println("Rolling Minimalist sofa")
    override fun pushback() = println("Pushing back Minimalist sofa")
}

object SofaFactory {
    fun create(type: String): Sofa {
        return when (type) {
            "victorian" -> VictorianSofa
            "minimalist" -> MinimalistSofa
            else -> throw IllegalArgumentException("Sofa Type not available!")
        }
    }
}




