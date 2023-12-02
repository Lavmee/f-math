/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core

/**
 * Represents a generic interface for fractions, with a numerator, denominator, and sign.
 *
 * @param Numerator The type of the numerator.
 * @param Denominator The type of the denominator.
 */
interface Fraction<Numerator, Denominator> {
    val numerator: Numerator
    val denominator: Denominator
    val sign: Byte // Sign of the fraction: 1 for positive, -1 for negative, 0 for zero.

    /**
     * Returns a string representation of the fraction.
     *
     * @return The string representation of the fraction.
     */
    override fun toString(): String
}