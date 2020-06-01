package com.lessthanthree.anything.ui.counter

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CounterViewModelTest {

    private lateinit var counterViewModel: CounterViewModel

    @Before
    fun init() {
        counterViewModel = CounterViewModel()
    }

    @Test
    fun increase() {
        val expected = 5
        var result: Int
        result = counterViewModel.increase()
        result = counterViewModel.increase()
        result = counterViewModel.increase()
        result = counterViewModel.increase()
        result = counterViewModel.increase()
        Assert.assertEquals(expected, result)
    }

    @Test
    fun decrease() {
        val expected = 0
        val result: Int
        result = counterViewModel.decrease()
        Assert.assertEquals(expected, result)
    }

    @Test
    fun reset() {
        val expected = 0
        val result = counterViewModel.reset()
        Assert.assertEquals(expected, result)
    }
}