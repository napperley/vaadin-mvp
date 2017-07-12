package org.example.vaadinmvp

interface CalculatorViewBase {
    val buttonClickHandlers: MutableList<(operation: Char) -> Unit>

    fun changeDisplay(value: Double)
}