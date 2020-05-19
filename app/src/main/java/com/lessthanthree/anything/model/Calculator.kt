package com.lessthanthree.anything.model

class Calculator {

    var result: String? = ""
    var operator: String? = ""
    var operandFirst: String? = ""
    var operandSecond: String? = ""

    fun calculate(): String? {
        var result: String? = ""

        when(this.operator) {
            "÷" -> {
                result = (this.operandSecond?.toDouble()?.let {
                    this.operandFirst?.toDouble()?.div(
                        it
                    )
                }).toString()
            }
            "x" -> {
                result = (this.operandSecond?.toDouble()?.let {
                    this.operandFirst?.toDouble()?.times(
                        it
                    )
                }).toString()
            }
            "-" -> {
                result = (this.operandSecond?.toDouble()?.let {
                    this.operandFirst?.toDouble()?.minus(
                        it
                    )
                }).toString()
            }
            "+" -> {
                result = (this.operandSecond?.toDouble()?.let {
                    this.operandFirst?.toDouble()?.plus(
                        it
                    )
                }).toString()
            }
        }

        if (result != null && result != "")
            this.result = result

        return this.result
    }

    fun addition() {
        this.operator = "+"
    }

    fun subtraction() {
        this.operator = "-"
    }

    fun multiply() {
        this.operator = "x"
    }

    fun divide() {
        this.operator = "÷"
    }

    fun clear() {
        this.result = ""
        this.operator = ""
        this.operandFirst = ""
        this.operandSecond = ""
    }

    fun delete() {
        if (this.operandSecond != null && this.operandSecond != "")
            this.operandSecond = this.operandSecond?.dropLast(1)
        else if (this.operator != null && this.operator != "")
            this.operator = ""
        else if (this.operandFirst != null && this.operandFirst != "")
            this.operandFirst = this.operandFirst?.dropLast(1)
    }

}