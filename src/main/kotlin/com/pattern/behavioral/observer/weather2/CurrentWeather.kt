package com.pattern.behavioral.observer.weather2

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    val temperature: Double,
    val time: String,
    @SerializedName("weathercode")
    val weatherCode: Int,
    @SerializedName("winddirection")
    val windDirection: Double,
    @SerializedName("windspeed")
    val windSpeed: Double
) {
    override fun toString(): String {
        return "Temperature: $temperature °C, Time: '$time', Wind Direction: $windDirection, Wind Speed: $windSpeed)"
    }
}
