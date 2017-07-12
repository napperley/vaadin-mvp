package org.example.vaadinmvp

import com.vaadin.ui.Button
import com.vaadin.ui.CustomComponent
import com.vaadin.ui.GridLayout
import com.vaadin.ui.Label

class CalculatorView :
    CustomComponent(),
    CalculatorViewBase,
    Button.ClickListener {
    override val buttonClickHandlers: MutableList<(operation: Char) -> Unit> = mutableListOf()
    private var display = Label("0.0")

    init {
        // Create a GridLayout containing a result label that spans over all the 4 columns in the first row.
        val layout = GridLayout(4, 5).apply { addComponent(display, 0, 0, 3, 0) }
        val operations = arrayOf("7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "=", "C",
            "+")

        operations.forEach { layout.addComponent(Button(it, this)) }
        compositionRoot = layout
    }

    override fun changeDisplay(value: Double) {
        display.value = "$value"
    }

    override fun buttonClick(event: Button.ClickEvent?) {
        buttonClickHandlers.forEach { if (event != null) it(event.button.caption[0]) }
    }
}