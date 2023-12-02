package tech.annexflow.fmath.core.integer

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Copyright 2023, @lavmee and the project contributors
 **/

class IntFractionArithmetic {

    @Test
    fun divideFraction() {
        val mutableFraction = mutableFractionOf(1, 2)
        mutableFraction /= fractionOf(4, 2)

        assertEquals(actual = mutableFraction, expected = mutableFractionOf(1, 4))
    }

    @Test
    fun multiplyFraction() {
        val mutableFraction = mutableFractionOf(1, 2)
        mutableFraction *= fractionOf(4, 2)

        assertEquals(actual = mutableFraction, expected = mutableFractionOf(1, 1))
    }

    @Test
    fun subtractFraction() {
        val mutableFraction = mutableFractionOf(1, 2)
        mutableFraction -= fractionOf(4, 2)

        assertEquals(actual = mutableFraction, expected = mutableFractionOf(-3, 2))
    }

    @Test
    fun additionFraction() {
        val mutableFraction = mutableFractionOf(1, 2)
        mutableFraction += fractionOf(4, 2)

        assertEquals(actual = mutableFraction, expected = mutableFractionOf(5, 2))
    }
}