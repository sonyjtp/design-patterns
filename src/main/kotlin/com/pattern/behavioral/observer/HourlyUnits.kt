package com.pattern.behavioral.observer

import com.google.gson.annotations.SerializedName

data class HourlyUnits(
    @SerializedName("relativehumidity_2m")
    val relativeHumidity: String,
    @SerializedName("temperature_2m")
    val temperature: String,
    val time: String,
    @SerializedName("windspeed_10m")
    val windspeed: String
)
