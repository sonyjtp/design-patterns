package com.pattern.structural.adapter

import io.kotest.core.spec.style.FunSpec


import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.Runs
import io.mockk.verify

class VehicleTest : FunSpec({
    lateinit var bus: Bus
    lateinit var boat: Boat

    beforeTest {
        bus = mockk()
        boat = mockk()
    }

    test("test travel") {
        var vehicleAdapter: VehicleAdapter = BusAdapter(bus)
        every {
            bus.drive(any(), any())
            boat.sail(any(), any())
        } just Runs
        vehicleAdapter.travel("Minneapolis", "St. Paul")
        vehicleAdapter = BoatAdapter(boat)
        vehicleAdapter.travel("St. Paul", "Minneapolis")
        verify(exactly = 1) {
            bus.drive("Minneapolis", "St. Paul")
            boat.sail("St. Paul", "Minneapolis")
        }
    }

})
