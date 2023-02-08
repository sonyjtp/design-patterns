package com.pattern.behavioral.observer

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
    val elevation: Double,
    @SerializedName("generationtime_ms")
    val generationTimeMs: Double,
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timeZoneAbbr: String,
    @SerializedName("utc_offset_seconds")
    val utcOffset: Int
) {
    override fun toString(): String {
        return StringBuilder("Elevation: ${elevation}m Time: ${currentWeather.time.substringAfter("T")}\n")
            .append("Latitude: $latitude Longitude: $longitude\n")
            .append("Temperature: ${hourly.temperature[0]}°C\n")
            .append("Humidity: ${hourly.relativeHumidity[0]}%").toString()
    }
}
