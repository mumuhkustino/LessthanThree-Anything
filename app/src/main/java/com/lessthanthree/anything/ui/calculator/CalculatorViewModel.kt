package com.lessthanthree.anything.ui.calculator

import androidx.lifecycle.ViewModel
import com.lessthanthree.anything.model.Calculator

class CalculatorViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var calculator = Calculator()

    fun calculate(): String? {
        return calculator.calculate()
    }

    fun clear() {
        if (calculator.operation != null
            && calculator.operation != ""){
            calculator.clear()
        }
    }

    fun delete() {
        if (calculator.operation != null
            && calculator.operation != "")
            calculator.delete()
    }

    fun evaluateExpression (userInput: String){
        /*IF USER PRESSED +, *, OR / WHEN THERE IS NO EXPRESSION*/
        val operator = listOf("+", "*", "/")
        var findOperator = operator.find { it == userInput }
        if((calculator.operation == null || calculator.operation == "")
            && findOperator != null){
            return
        }

        /*IF USER PRESSED OPERATOR MORE THAN ONCE*/
        val operator2 = listOf("+", "*", "/", "-", ".")
        findOperator = operator2.find { it == userInput }
        if (calculator.operation != null
            && calculator.operation != ""){
            val last = calculator.operation?.last().toString()
            val findLast =operator2.find { it == last }
            if (findOperator != null && findLast != null){
                return
            }
        }

        calculator.createExpression(userInput)
    }

    fun getExpression() :String? {
        return calculator.getExpression()
    }
}
