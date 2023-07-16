package com.pattern.creational.prototype

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainOnly
import io.kotest.matchers.shouldBe

class RunnerTest : FunSpec({

    test("test prototypes") {
        val runner1 = Runner("runner1")
        runner1.level shouldBe Level.NEWBIE
        val runner2 = runner1.copy(name = "runner2")
        runner2.badgesEarned.shouldContainOnly(Badge.FIRST_LOGIN)
        runner2.addBadge(Badge.FIRST_FIVE_MILE_RUN)
        runner2.addBadge(Badge.THREE_DAY_GOALS_ACHIEVED)
        runner2.totalPoints = 300
        runner2.updateLevel(Level.PRO)
        val runner3 = runner2.copy("runner3")
        runner3.name shouldBe "runner3"
        runner3.badgesEarned.shouldContainOnly(
            Badge.FIRST_LOGIN,
            Badge.FIRST_FIVE_MILE_RUN,
            Badge.THREE_DAY_GOALS_ACHIEVED
        )
        runner3.addPoints(200)
        runner3.totalPoints shouldBe 500
        runner3.updateLevel(Level.VETERAN)
        runner3.level shouldBe Level.VETERAN
    }
})
