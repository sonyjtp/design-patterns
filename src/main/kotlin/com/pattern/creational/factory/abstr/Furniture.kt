package com.pattern.creational.factory.abstr


/**
 * Abstract Factory pattern has an abstract interface for creating a family of products - chairs and sofas.
 * It has a set of factory methods, one for each product.
 */

sealed interface Furniture {
    fun roll()
    fun pushback()
}

sealed interface FurnitureFactory {
    fun create(type: String): Furniture
}

object FurnitureTypeFactory {

    fun getFurnitureType(type: String) = when (type) {
        "chair" -> ChairFactory
        "sofa" -> SofaFactory
        else -> throw IllegalArgumentException("Furniture Type not available!")
    }
}


sealed interface Chair : Furniture

object VictorianChair : Chair {
    override fun roll() = println("Rolling Victorian chair")
    override fun pushback() = println("Pushing back Victorian chair")
}

object ModernChair : Chair {
    override fun roll() = println("Rolling Modern chair")
    override fun pushback() = println("Pushing back Modern chair")
}

object ChairFactory : FurnitureFactory {
    override fun create(type: String): Chair {
        return when (type) {
            "victorian" -> VictorianChair
            "modern" -> ModernChair
            else -> throw IllegalArgumentException("Chair Type not available!")
        }
    }
}

sealed interface Sofa : Furniture


object VenetianSofa : Sofa {
    override fun roll() = println("Rolling Venetian sofa")
    override fun pushback() = println("Pushing back Venetian sofa")
}

object MinimalistSofa : Sofa {
    override fun roll() = println("Rolling Minimalist sofa")
    override fun pushback() = println("Pushing back Minimalist sofa")
}

object SofaFactory : FurnitureFactory {
    override fun create(type: String): Sofa {
        return when (type) {
            "venetian" -> VenetianSofa
            "minimalist" -> MinimalistSofa
            else -> throw IllegalArgumentException("Sofa Type not available!")
        }
    }
}
