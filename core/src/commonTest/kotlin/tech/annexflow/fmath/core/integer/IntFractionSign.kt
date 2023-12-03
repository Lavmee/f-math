package tech.annexflow.fmath.core.integer

import tech.annexflow.fmath.core.numeric.sign
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Copyright 2023, @lavmee and the project contributors
 **/

class IntFractionSign {

    @Test
    fun zero() {
        assertEquals(expected = 0, actual = fractionOf(0, 1).sign)
    }

    @Test
    fun negative() {
        val expected: Byte = -1
        assertEquals(expected = expected, fractionOf(-1, 1).sign)
        assertEquals(expected = expected, fractionOf(1, -1).sign)
    }

    @Test
    fun positive() {
        val expected: Byte = 1
        assertEquals(expected = expected, fractionOf(1, 1).sign)
        assertEquals(expected = expected, fractionOf(-1, -1).sign)
    }

    @Test
    fun bigValues() {
        assertEquals(expected = 1, fractionOf(2147483647, 2).sign)
        assertEquals(expected = 1, fractionOf(2, 2147483647).sign)
    }
}