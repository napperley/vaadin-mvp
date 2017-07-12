package org.example.vaadinmvp

class CalculatorPresenter(val model: CalculatorModel, val view: CalculatorViewBase) {
    private var current = 0.0
    private var lastOperationRequested = 'C'

    init {
        view.changeDisplay(current)
        view.buttonClickHandlers += this::buttonClick
    }

    fun buttonClick(operation: Char) {
        // Handle digit input.
        if (operation in '0'..'9') {
            current = (current * 10) + "$operation".toDouble()
            view.changeDisplay(current)
        } else {
            // Execute the previously input operation.
            when (lastOperationRequested) {
                '+' -> model.add(current)
                '-' -> model.add(-current)
                '/' -> model.divide(current)
                '*' -> model.multiply(current)
                'C' -> model.clear()
            }

            lastOperationRequested = operation
            current = 0.0
            if (operation == 'C') model.clear()
            view.changeDisplay(model.value)
        }
    }
}