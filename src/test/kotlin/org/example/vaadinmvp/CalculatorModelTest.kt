package org.example.vaadinmvp

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class CalculatorModelTest : TestCase() {
    val model = CalculatorModel()

    @Before
    fun beforeTest() {
        model.value = 0.0
    }

    @Test
    fun testClear() {
        val actual = model.run {
            value = 5.0
            clear()
            value
        }
        val expected = 0.0

        assertEquals("Value isn't cleared", expected, actual)
    }

    @Test
    fun testAdd() {
        val actual = model.run {
            value = 7.5
            add(8.8)
            value
        }
        val expected = 16.3

        assertEquals("Result of add is incorrect", expected, actual)
    }

    @Test
    fun testMultiply() {
        val actual = model.run {
            value = 4.6
            multiply(36.89)
            value
        }
        val expected = 169.694

        assertEquals("Result of multiply is incorrect", expected, actual)
    }

    @Test
    fun testDivide() {
        val actual = model.run {
            value = 10.0
            divide(4.0)
            value
        }
        val expected = 2.5

        assertEquals("Result of divide is incorrect", expected, actual)
    }
}