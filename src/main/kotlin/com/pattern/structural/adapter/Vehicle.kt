package com.pattern.structural.adapter


interface Vehicle

class Bus : Vehicle {
    fun drive(source: String, destination: String) {
        println("Travelling by bus from $source to $destination")
    }
}

class Boat : Vehicle {
    fun sail(source: String, destination: String) {
        println("Travelling by boat from $source to $destination")
    }
}

interface VehicleAdapter {
    fun travel(source: String, destination: String)
}

class BoatAdapter(private val boat: Boat) : VehicleAdapter {
    override fun travel(source: String, destination: String) {
        boat.sail(source, destination)
    }
}

class BusAdapter(private val bus: Bus) : VehicleAdapter {
    override fun travel(source: String, destination: String) {
        bus.drive(source, destination)
    }
}



