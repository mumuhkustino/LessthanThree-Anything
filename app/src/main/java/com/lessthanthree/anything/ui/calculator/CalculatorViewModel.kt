package com.lessthanthree.anything.ui.calculator

import android.util.Log
import androidx.lifecycle.ViewModel
import com.lessthanthree.anything.model.Calculator

class CalculatorViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var calculator = Calculator()

    fun calculate(): String? {
        return calculator.calculate()
    }

    fun addition() {
        if (calculator.operandFirst != null
            && calculator.operandFirst != "")
            calculator.addition()
    }

    fun subtraction() {
        if (calculator.operandFirst != null
            && calculator.operandFirst != "")
            calculator.subtraction()
    }

    fun multiply() {
        if (calculator.operandFirst != null
            && calculator.operandFirst != "")
            calculator.multiply()
    }

    fun divide() {
        if (calculator.operandFirst != null
            && calculator.operandFirst != "")
            calculator.divide()
    }

    fun clear() {
        if (calculator.operandFirst != null
            && calculator.operandFirst != "")
            calculator.clear()
    }

    fun delete() {
        if (calculator.operandFirst != null
            && calculator.operandFirst != "")
            calculator.delete()
    }

    fun setOperand(value: String?) {
        if (calculator.operandFirst != null
            && calculator.operandFirst != ""
            && calculator.operator != null
            && calculator.operator != "") {
                calculator.operandSecond = value
                Log.d("C", value + " OS " + calculator.operandSecond)
                Log.d("C", value + " O " + calculator.operator)
        } else {
            calculator.operandFirst = value
            Log.d("C", value + " OF " + calculator.operandFirst)
        }
    }

}
