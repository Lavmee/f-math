package tech.annexflow.fmath.core.integer

import tech.annexflow.fmath.core.ExperimentalFMathApi
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Copyright 2023, @lavmee and the project contributors
 **/

@OptIn(ExperimentalFMathApi::class)
internal class FloatToFraction {

    @Test
    fun basic() {
        val actualFraction = 1.0f.toFraction()
        assertEquals(expected = fractionOf(1, 1), actual = actualFraction)
    }

    @Test
    fun check1_10() {
        assertEquals(expected = fractionOf(1, 10), 0.1f.toFraction())
    }

    @Test
    fun maxFractionalPart() {
        val actualFraction = 9.000001f.toFraction()
        assertEquals(expected = fractionOf(9000001, 1000000), actualFraction)
    }

    @Test
    fun maxIntegerPart() {
        val actualFraction = 9999999f.toFraction()
        assertEquals(expected = fractionOf(9999999, 1), actualFraction)
    }

    @Test
    fun maxFractionalPartWithZeroIntegerPart() {
        val actualFraction = 0.000001f.toFraction()
        assertEquals(expected = fractionOf(1, 1000000), actualFraction)
    }

    @Test
    fun maxFractionalPartWithRandomNumbers() {
        val actualFraction = 0.123456f.toFraction()
        assertEquals(expected = fractionOf(123456, 1000000), actualFraction)
    }
}