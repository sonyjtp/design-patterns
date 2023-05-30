package com.pattern.behavioral.observer.weather2

import com.google.gson.annotations.SerializedName

data class Hourly(
    @SerializedName("relativehumidity_2m")
    val relativeHumidity: List<Int>,
    @SerializedName("temperature_2m")
    val temperature: List<Double>,
    val time: List<String>,
    @SerializedName("windspeed_10m")
    val windSpeed: List<Double>
)
