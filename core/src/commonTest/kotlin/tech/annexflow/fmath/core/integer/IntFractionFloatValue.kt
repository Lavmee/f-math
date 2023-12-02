package tech.annexflow.fmath.core.integer

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Copyright 2023, @lavmee and the project contributors
 **/

class IntFractionFloatValue {

    @Test
    fun basic() {
        val fraction = fractionOf(1, 2)
        assertEquals(expected = 0.5f, actual = fraction.floatValue)
    }

    @Test
    fun zeroValue() {
        val fraction = fractionOf(0, 1)
        assertEquals(expected = 0f, actual = fraction.floatValue)
    }
}