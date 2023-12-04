/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.fraction.core

/**
 * Represents a generic interface for mutable fractions, with a numerator, denominator.
 *
 * @param Numerator The type of the numerator.
 * @param Denominator The type of the denominator.
 */
interface MutableFraction<Numerator, Denominator> : Fraction<Numerator, Denominator> {
    /**
     * The mutable numerator of the fraction.
     */
    var mutableNumerator: Numerator

    /**
     * The mutable denominator of the fraction.
     */
    var mutableDenominator: Denominator

    /**
     * The current numerator of the fraction.
     */
    override val numerator: Numerator get() = mutableNumerator

    /**
     * The current denominator of the fraction.
     */
    override val denominator: Denominator get() = mutableDenominator

    /**
     * Creates and returns a copy of the mutable fraction.
     *
     * @return A copy of the mutable fraction.
     */
    override fun copy(): MutableFraction<Numerator, Denominator>
}