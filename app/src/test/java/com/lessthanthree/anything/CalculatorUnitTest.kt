package com.lessthanthree.anything

import com.lessthanthree.anything.model.Calculator
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalculatorUnitTest {

    lateinit var calculator: Calculator

    @Before
    fun init() {
        calculator = Calculator()
    }

//    @Test
//    fun additionTest() {
//        calculator.addition()
//        calculator.operandFirst = "6"
//        calculator.operandSecond = "6"
//        assertEquals("12.0", calculator.calculate())
//    }
//
//    @Test
//    fun subtractionTest() {
//        calculator.subtraction()
//        calculator.operandFirst = "6"
//        calculator.operandSecond = "6"
//        assertEquals("0.0", calculator.calculate())
//    }
//
//    @Test
//    fun multiplicationTest() {
//        calculator.multiply()
//        calculator.operandFirst = "6"
//        calculator.operandSecond = "6"
//        assertEquals("36.0", calculator.calculate())
//    }
//
//    @Test
//    fun divisionTest() {
//        calculator.divide()
//        calculator.operandFirst = "6"
//        calculator.operandSecond = "6"
//        assertEquals("1.0", calculator.calculate())
//    }
//
//    @Test
//    fun clearTest() {
//        calculator.clear()
//        assertEquals("", calculator.result)
//        assertEquals("", calculator.operandFirst)
//        assertEquals("", calculator.operandSecond)
//        assertEquals("", calculator.operator)
//    }
//
//    @Test
//    fun deleteOperatorTest() {
//        calculator.addition()
//        calculator.delete()
//        assertEquals("", calculator.operator)
//    }
//
//    @Test
//    fun deleteOperandFirstTest() {
//        calculator.operandFirst = "10"
//        calculator.delete()
//        assertEquals("1", calculator.operandFirst)
//    }
//
//    @Test
//    fun deleteOperandSecondTest() {
//        calculator.operandSecond = "10"
//        calculator.delete()
//        assertEquals("1", calculator.operandSecond)
//    }
}
