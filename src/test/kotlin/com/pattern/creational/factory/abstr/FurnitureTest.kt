package com.pattern.creational.factory.abstr


import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.types.shouldBeSameInstanceAs

class FurnitureTest : FunSpec({

    test("abstract factory") {
        var furniture: Furniture = FurnitureTypeFactory.getFurnitureType("chair").create("modern")
        furniture shouldBeSameInstanceAs ModernChair
        furniture = FurnitureTypeFactory.getFurnitureType("chair").create("victorian")
        furniture shouldBeSameInstanceAs VictorianChair
        furniture = FurnitureTypeFactory.getFurnitureType("sofa").create("venetian")
        furniture shouldBeSameInstanceAs VenetianSofa
        furniture = FurnitureTypeFactory.getFurnitureType("sofa").create("minimalist")
        furniture shouldBeSameInstanceAs MinimalistSofa
    }
})
