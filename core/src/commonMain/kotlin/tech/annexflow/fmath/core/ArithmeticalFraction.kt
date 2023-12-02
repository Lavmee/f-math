/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core

/**
 * Represents an interface for fractions that support arithmetic operations, comparison, and copying.
 *
 * @param Numerator The type of the numerator.
 * @param Denominator The type of the denominator.
 */
interface ArithmeticalFraction<Numerator, Denominator> :
    CopyableFraction<Numerator, Denominator>,
    Arithmetical<ArithmeticalFraction<Numerator, Denominator>>,
    Comparable<ArithmeticalFraction<Numerator, Denominator>> {
    /**
     * Creates and returns a copy of the arithmetical fraction.
     *
     * @return A copy of the arithmetical fraction.
     */
    override fun copy(): ArithmeticalFraction<Numerator, Denominator>
}