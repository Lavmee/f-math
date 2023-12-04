@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package tech.annexflow.fmath.fraction.primitive

import tech.annexflow.fmath.fraction.core.MutableArithmeticalFraction
import tech.annexflow.fmath.fraction.core.ReadOnlyArithmeticalFraction
import tech.annexflow.fmath.fraction.core.toImmutableFraction
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * Copyright 2023, @lavmee and the project contributors
 **/

class IntFractionEquality {

    @Test
    fun basic() {
        assertEquals(expected = fractionOf(1, 1), actual = fractionOf(1, 1))
    }

    @Test
    fun defaultAndReduce() {
        assertEquals(
            expected = fractionOf(1, 1, isAutoReducing = true),
            actual = fractionOf(1, 1, isAutoReducing = false)
        )
    }

    @Test
    fun mutableAndImmutable() {
        assertEquals(
            expected = fractionOf(1, 1),
            actual = mutableFractionOf(1, 1)
        )
    }

    @Test
    fun checkMutableToImmutableEquality() {
        val mutableFraction = mutableFractionOf(1, 1)
        val immutableFraction = mutableFraction.toImmutableFraction()
        assertEquals(mutableFraction, immutableFraction)

        immutableFraction as ReadOnlyArithmeticalFraction
        assertFalse { mutableFraction === immutableFraction.mutableFraction }
        assertFalse { immutableFraction is MutableArithmeticalFraction<Int, Int> }
    }
}