package com.pattern.behavioral.template

fun main() {
    var worker: Worker = Actor()
    worker.doWork()
    worker = Programmer()
    worker.doWork()
}

abstract class Worker {

    fun doWork() {
        goToWork()
        work()
        goHome()
    }

    private fun goToWork() {
        println("Going to work")
    }

    private fun goHome() {
        println("Back home")
    }

    abstract fun work()
}

class Actor : Worker() {
    override fun work() {
        println("Acting")
    }
}

class Programmer : Worker() {
    override fun work() {
        println("Coding")
    }
}



