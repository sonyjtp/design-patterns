package com.pattern.behavioral.strategy

import io.kotest.core.spec.style.FunSpec

class StrategyTest : FunSpec({
    /**
     * Strategy Pattern - (1) define a family of algorithms, (2) encapsulate each one
     *  and (3) make them interchangeable. Strategy pattern lets the algorithm vary independently
     *  from clients that use it
     *  1 - Family of algorithms - Artist can sing or dance
     *  2 - Performance isn't tied to the Artist and performance behaviour is encapsulated
     *      Singer is-a Artist
     *      Dancer is-a Artist
     *  3 - Make them interchangeable - Make Yesudas dance.
     * Artist has a perform() method that is overridden by Singer and Dancer
     * Singing and Dancing have perform() methods
     */
    test("Strategy pattern") {
        var artist1: Artist = Singer("Yesudas")
        val artist2: Artist = Dancer("Shobhana")
        artist1.perform()
        artist2.perform()
        artist1 = Dancer("Yesudas")
        artist1.perform()
    }
})
