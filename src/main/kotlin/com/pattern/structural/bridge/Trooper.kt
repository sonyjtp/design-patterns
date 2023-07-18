package com.pattern.structural.bridge

typealias PointsOfDamage = Long
typealias Meters = Int

const val RIFLE_DAMAGE: PointsOfDamage = 3L
const val REGULAR_SPEED: Meters = 1

interface Weapon {
    fun attack(): PointsOfDamage
}

class Rifle : Weapon {
    override fun attack() = RIFLE_DAMAGE
}

class FlameThrower : Weapon {
    override fun attack() = 2 * RIFLE_DAMAGE
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


