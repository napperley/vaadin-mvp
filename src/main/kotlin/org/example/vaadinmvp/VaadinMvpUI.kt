package org.example.vaadinmvp

import com.vaadin.server.VaadinRequest
import com.vaadin.ui.UI
import com.vaadin.ui.Label
import com.vaadin.annotations.Theme
import com.vaadin.annotations.Title

@Suppress("unused")
@Theme("VaadinMvp")
@Title("Calculator")
class VaadinMvpUI : UI() {

    override fun init(request: VaadinRequest) {
        val lbl = Label("Hello vaadin")
        content = lbl
    }
}
