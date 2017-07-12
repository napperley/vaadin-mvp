package org.example.vaadinmvp

import com.vaadin.server.VaadinRequest
import com.vaadin.ui.UI
import com.vaadin.annotations.Theme
import com.vaadin.annotations.Title

@Suppress("unused")
@Theme("VaadinMvp")
@Title("Calculator")
class VaadinMvpUI : UI() {
    private val presenter = CalculatorPresenter(view = CalculatorView(), model = CalculatorModel())

    override fun init(request: VaadinRequest) {
        content = presenter.view as CalculatorView
    }
}
