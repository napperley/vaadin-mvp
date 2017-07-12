package org.example.vaadinmvp

data class CalculatorModel(var value: Double = 0.0) {
    fun clear() {
        value = 0.0
    }

    fun add(num: Double) {
        value += num
    }

    fun multiply(num: Double) {
        value *= num
    }

    fun divide(num: Double) {
        value /= num
    }
}