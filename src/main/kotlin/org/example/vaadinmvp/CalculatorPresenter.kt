package org.example.vaadinmvp

class CalculatorPresenter(val model: CalculatorModel, val view: CalculatorViewBase) {
    private val calculationValues = arrayOf('+', '-', '*', '/')
    private var firstValueEntered = false
    private var firstValue = "0"
    private var secondValue = "0"
    private var lastOperationRequested = OperationType.CLEAR.value

    init {
        view.changeDisplay(firstValue.toDouble())
        view.buttonClickHandlers += this::buttonClick
    }

    fun buttonClick(operation: Char) {
        if (!firstValueEntered && operation in '0'..'9') {
            firstValue += "$operation"
            view.changeDisplay(firstValue.toDouble())
        } else if (firstValueEntered && operation in '0'..'9') {
            secondValue += "$operation"
            view.changeDisplay(secondValue.toDouble())
        } else if (operation in calculationValues) {
            lastOperationRequested = operation
            firstValueEntered = true
            model.value = firstValue.toDouble()
        } else if (operation == OperationType.EQUALS.value) {
            calculateResult()
        } else {
            clear()
        }
    }

    private fun clear() {
        lastOperationRequested = OperationType.CLEAR.value
        model.clear()
        firstValue = "0"
        secondValue = "0"
        firstValueEntered = false
        view.changeDisplay(model.value)
    }

    private fun calculateResult() {
        when (lastOperationRequested) {
            OperationType.ADD.value -> model.add(secondValue.toDouble())
            OperationType.SUBTRACT.value -> model.add(-secondValue.toDouble())
            OperationType.DIVIDE.value -> model.divide(secondValue.toDouble())
            OperationType.MULTIPLY.value -> model.multiply(secondValue.toDouble())
        }
        view.changeDisplay(model.value)
        lastOperationRequested = OperationType.EQUALS.value
        firstValueEntered = false
        firstValue = "0"
        secondValue = "0"
    }
}