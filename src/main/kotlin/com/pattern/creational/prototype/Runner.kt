package com.pattern.creational.prototype

/**
 * Prototype pattern
 */
data class Runner(
    val name: String,
    var level: Level = Level.NEWBIE,
    var totalPoints: Int = 0,
    var badgesEarned: MutableList<Badge> = mutableListOf(Badge.FIRST_LOGIN)
) {
    fun updateLevel(newLevel: Level) = apply { level = newLevel }
    fun addPoints(points: Int) = apply { totalPoints += points }
    fun addBadge(badge: Badge) = apply { badgesEarned += badge }
}

enum class Level {
    NEWBIE,
    PRO,
    VETERAN
}

enum class Badge {
    FIRST_LOGIN,
    FIRST_FIVE_MILE_RUN,
    THREE_DAY_GOALS_ACHIEVED

}
