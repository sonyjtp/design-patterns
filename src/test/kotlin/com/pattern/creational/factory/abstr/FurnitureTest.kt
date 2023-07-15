package com.pattern.creational.factory.abstr


import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.types.shouldBeSameInstanceAs

class FurnitureTest : FunSpec({

    test("abstract factory") {
        FurnitureTypeFactory.getFurnitureType("chair").create("modern") shouldBeSameInstanceAs ModernChair
        FurnitureTypeFactory.getFurnitureType("chair").create("victorian") shouldBeSameInstanceAs VictorianChair
        FurnitureTypeFactory.getFurnitureType("sofa").create("venetian") shouldBeSameInstanceAs VenetianSofa
        FurnitureTypeFactory.getFurnitureType("sofa").create("minimalist") shouldBeSameInstanceAs MinimalistSofa
    }
})
