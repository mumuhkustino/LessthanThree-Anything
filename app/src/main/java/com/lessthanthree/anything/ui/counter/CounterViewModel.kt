package com.lessthanthree.anything.ui.counter

import androidx.lifecycle.ViewModel
import com.lessthanthree.anything.model.Counter

class CounterViewModel : ViewModel() {
    private val counter = Counter()

    fun increase(): Int {
        return counter.increase()
    }

    fun decrease(): Int {
        return counter.decrease()
    }

    fun reset(): Int {
        return counter.reset()
    }

}