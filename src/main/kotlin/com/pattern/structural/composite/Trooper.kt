package com.pattern.structural.composite

typealias PointsOfDamage = Long
typealias Meters = Int

const val RIFLE_DAMAGE: PointsOfDamage = 3L
const val REGULAR_SPEED: Meters = 1

class Squad(private val units: List<Trooper>) : Trooper {
    constructor(vararg units: Trooper) : this(units.toList())

    override fun move(): Meters {
        var moved = 0
        for (u in units) {
            moved = maxOf(moved, u.move())
        }
        return moved
    }

    override fun attack(): PointsOfDamage {
        var attacked: PointsOfDamage = 0L
        for (u in units) {
            attacked += u.attack()
        }
        return attacked
    }
}

interface Weapon {
    fun attack(): PointsOfDamage
}

class Rifle : Weapon {
    override fun attack() = RIFLE_DAMAGE
}


interface Legs {
    fun move(): Meters
}

class RegularLegs : Legs {
    override fun move(): Meters = REGULAR_SPEED
}

class AthleticLegs : Legs {
    override fun move(): Meters = 2 * REGULAR_SPEED
}


interface Trooper {
    fun move(): Meters
    fun attack(): PointsOfDamage
}

data class StormTrooper(
    private val weapon: Weapon,
    private val legs: Legs
) : Trooper {
    override fun move() = legs.move()

    override fun attack() = weapon.attack()
}


