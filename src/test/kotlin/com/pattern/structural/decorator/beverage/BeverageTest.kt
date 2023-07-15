package com.pattern.structural.decorator.beverage

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BeverageTest : FunSpec({

    test("beverage decorator") {
        val houseBlend: Beverage = HouseBlend
        var decorated: CondimentDecorator = Soy(houseBlend)
        decorated.getDescription() shouldBe "HouseBlend, Soy"
        decorated.cost() shouldBe 1.04
        decorated = Milk(decorated)
        decorated.getDescription() shouldBe "HouseBlend, Soy, Milk"
        decorated.cost() shouldBe 1.04 + .25
    }
})
