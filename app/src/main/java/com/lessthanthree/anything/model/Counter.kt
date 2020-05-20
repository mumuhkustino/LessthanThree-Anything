package com.lessthanthree.anything.model

class Counter {
    private var num: Int = 0

    fun increase(): Int {
        num += 1
        return num
    }

    fun decrease(): Int {
        num -= 1
        return num
    }

    fun reset(): Int {
        num = 0
        return num
    }
}