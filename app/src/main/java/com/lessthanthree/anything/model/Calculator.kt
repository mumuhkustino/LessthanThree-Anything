package com.lessthanthree.anything.model

import net.objecthunter.exp4j.ExpressionBuilder

class Calculator {

    private var result: String? = ""
    var operation: String? = ""

    fun calculate(): String? {
        val text = this.operation

        if (text != null) {
            if(text.contains("/0")){
                this.operation = ""
                return "\u221E"
            }
        }
        val expression = ExpressionBuilder(text).build()
        val result =expression.evaluate()
        val longResult =result.toLong()

        if (result == longResult.toDouble()){
            this.operation = longResult.toString()
            this.result = longResult.toString()
        } else {
            this.operation = result.toString()
            this.result = result.toString()
        }

        return this.result
    }

    fun clear() {
        this.operation = ""
    }

    fun delete() {
        if (this.operation != null && this.operation != "")
            this.operation = this.operation?.dropLast(1)
    }

    fun createExpression (userInput: String){
        this.operation += userInput
    }

    fun getExpression (): String?{
        return this.operation
    }

}