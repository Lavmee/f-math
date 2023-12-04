/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.fraction.core

import tech.annexflow.fmath.core.Copyable

/**
 * Represents a generic interface for fractions, with a numerator, denominator.
 *
 * @param Numerator The type of the numerator.
 * @param Denominator The type of the denominator.
 */
interface Fraction<Numerator, Denominator> : Copyable {
    val numerator: Numerator
    val denominator: Denominator

    /**
     * Returns a string representation of the fraction.
     *
     * @return The string representation of the fraction.
     */
    override fun toString(): String

    /**
     * Creates and returns a copy of the fraction.
     *
     * @return A copy of the fraction.
     */
    override fun copy(): Fraction<Numerator, Denominator>
}