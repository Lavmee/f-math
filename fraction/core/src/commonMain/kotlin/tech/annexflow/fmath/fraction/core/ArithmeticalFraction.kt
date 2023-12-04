/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.fraction.core

import tech.annexflow.fmath.core.Arithmetical

/**
 * Represents an interface for fractions that support arithmetic operations, comparison, and copying.
 *
 * @param Numerator The type of the numerator.
 * @param Denominator The type of the denominator.
 */
interface ArithmeticalFraction<Numerator, Denominator> :
    Fraction<Numerator, Denominator>,
    Arithmetical<Fraction<Numerator, Denominator>>,
    Comparable<Fraction<Numerator, Denominator>> {
    /**
     * Creates and returns a copy of the arithmetical fraction.
     *
     * @return A copy of the arithmetical fraction.
     */
    override fun copy(): ArithmeticalFraction<Numerator, Denominator>
}