package com.pattern.structural.composite

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly

class SquadTest : FunSpec({

    test("test squad") {
        val bobaFett = StormTrooper(Rifle(), RegularLegs())
        val squad1 = Squad(listOf(bobaFett.copy(), bobaFett.copy(), bobaFett.copy()))
        squad1.move() shouldBeExactly 1
        squad1.attack() shouldBeExactly 9L
        val squad2 = Squad(bobaFett, StormTrooper(Rifle(), AthleticLegs()))
        squad2.move() shouldBeExactly 2
        squad2.attack() shouldBeExactly 6L
    }
})
