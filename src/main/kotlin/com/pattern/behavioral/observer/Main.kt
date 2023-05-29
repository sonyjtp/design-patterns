package com.pattern.behavioral.observer

import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

private const val DISPLAY_DELAY_MILLIS = 5000L
private const val BASE_URL = "https://api.open-meteo.com/v1/forecast?"
private const val REQ_LAT = "latitude"
private const val REQ_LONG = "longitude"
private const val REQ_DEF_CONDITIONS = "&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m"
private val weatherClient = HttpClient.newBuilder().build()
private val gson = Gson()


/**
 * Observer Pattern - defines a one-to-many dependency between objects so that
 * when one object's stage changes, all of its dependents (observers) are notified and
 * updated automatically.
 * -    Subject is only aware of an Observer Interface. Doesn't know about its
 *      implementation.
 * -    Add/remove observers any time without modifying subject's code.
 * -    Reuse/change subjects/observers independently of each other.
 */
fun main() {
    val subject: Subject = WeatherData()
    registerObservers(subject)
    runBlocking {
        updateWeather(subject)
    }
}

fun registerObservers(subject: Subject) {
    subject.register(AirportWeatherDisplay)
    subject.register(CityCenterWeatherDisplay)
    subject.register(StadiumWeatherDisplay)
}

private suspend fun updateWeather(subject: Subject) {
    var weather: Weather
    val cities = City.values()
    cities.shuffle()
    for (city in cities) {
        delay(DISPLAY_DELAY_MILLIS)
        val weatherUrl = "$BASE_URL$REQ_LAT=" +
                "${city.getCoordinates().first}&$REQ_LONG=${city.getCoordinates().second}$REQ_DEF_CONDITIONS"
        weather = gson.fromJson(getWeather(weatherUrl), Weather::class.java)
        subject.updateState(
            mapOf(
                "city" to city.toString(),
                "weather" to weather.toString()
            )
        )
    }
}

private fun getWeather(url: String): String {
    val request = HttpRequest.newBuilder().uri((URI.create(url))).build()
    return weatherClient.send(request, HttpResponse.BodyHandlers.ofString()).body()
}
