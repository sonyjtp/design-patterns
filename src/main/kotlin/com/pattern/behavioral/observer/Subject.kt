package com.pattern.behavioral.observer

interface Subject<T, U> {
    fun registerObserver(observer: T): Boolean
    fun removeObserver(observer: T): Boolean
    fun update(newState: U)
}

