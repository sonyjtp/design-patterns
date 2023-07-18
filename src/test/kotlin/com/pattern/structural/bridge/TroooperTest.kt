package com.pattern.structural.bridge

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TroooperTest : FunSpec({

    test("troopers") {
        val stormTrooper = StormTrooper(Rifle(), RegularLegs())
        val flameTrooper = StormTrooper(FlameThrower(), RegularLegs())
        val scoutTrooper = StormTrooper(Rifle(), AthleticLegs())
        stormTrooper.attack() shouldBe 3
        stormTrooper.move() shouldBe 1
        flameTrooper.attack() shouldBe 6
        flameTrooper.move() shouldBe 1
        scoutTrooper.attack() shouldBe 3
        scoutTrooper.move() shouldBe 2
    }
})
