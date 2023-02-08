package com.pattern.behavioral.observer

enum class City(private val latitude: Double, private val longitude: Double) {
    NEW_DELHI(latitude = 28.64, longitude = 77.22),
    BEIJING(latitude = 39.91, longitude = 116.40),
    TOKYO(latitude = 35.69, longitude = 139.69),
    ABU_DHABI(latitude = 24.45, longitude = 54.40),
    ISTANBUL(latitude = 41.01, longitude = 28.95),
    MOSCOW(latitude = 55.75, longitude = 37.62),
    LONDON(latitude = 51.51, longitude = -0.13),
    ROME(latitude = 41.89, longitude = 12.51),
    PARIS(latitude = 48.85, longitude = 2.35),
    MADRID(latitude = 40.42, longitude = -3.70),
    CAIRO(latitude = 30.06, longitude = 31.25),
    PRETORIA(latitude = -25.74, longitude = 28.19),
    KINSHASA(latitude = -4.33, longitude = 15.31),
    OUGADOUGOU(latitude = 5.85, longitude = 21.56),
    ACCRA(latitude = 5.56, longitude = -0.20),
    NEW_YORK(latitude = 40.71, longitude = -74.01),
    OTTAWA(latitude = 45.41, longitude = -75.70),
    MEXICO_CITY(latitude = 19.43, longitude = -99.13),
    LIMA(latitude = -12.04, longitude = -77.03),
    BUENOS_AIRES(latitude = -34.61, longitude = -58.38);

    fun getCoordinates() = Pair(this.latitude, this.longitude)
}
