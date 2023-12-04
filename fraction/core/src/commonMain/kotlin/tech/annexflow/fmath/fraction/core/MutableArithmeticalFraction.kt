package tech.annexflow.fmath.fraction.core

import tech.annexflow.fmath.core.Reducible

/**
 * Represents an interface for mutable fractions that support arithmetic operations, comparison, copying, and reduction.
 *
 * @param Numerator The type of the numerator.
 * @param Denominator The type of the denominator.
 */
interface MutableArithmeticalFraction<Numerator, Denominator> : MutableFraction<Numerator, Denominator>,
    ArithmeticalFraction<Numerator, Denominator>, Reducible {

    /**
     * Subtracts another arithmetical fraction and returns a mutable result.
     *
     * @param other The arithmetical fraction to subtract.
     * @return A mutable arithmetical fraction representing the result of the subtraction.
     */
    override operator fun minus(other: Fraction<Numerator, Denominator>): MutableArithmeticalFraction<Numerator, Denominator> =
        copy().apply { this -= other }

    /**
     * Subtracts another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to subtract.
     */
    operator fun minusAssign(other: Fraction<Numerator, Denominator>)

    /**
     * Adds another arithmetical fraction and returns a mutable result.
     *
     * @param other The arithmetical fraction to add.
     * @return A mutable arithmetical fraction representing the result of the addition.
     */
    override operator fun plus(other: Fraction<Numerator, Denominator>): MutableArithmeticalFraction<Numerator, Denominator> =
        copy().apply { this += other }

    /**
     * Adds another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to add.
     */
    operator fun plusAssign(other: Fraction<Numerator, Denominator>)

    /**
     * Multiplies by another arithmetical fraction and returns a mutable result.
     *
     * @param other The arithmetical fraction to multiply by.
     * @return A mutable arithmetical fraction representing the result of the multiplication.
     */
    override operator fun times(other: Fraction<Numerator, Denominator>): MutableArithmeticalFraction<Numerator, Denominator> =
        copy().apply { this *= other }

    /**
     * Multiplies by another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to multiply by.
     */
    operator fun timesAssign(other: Fraction<Numerator, Denominator>)

    /**
     * Divides by another arithmetical fraction and returns a mutable result.
     *
     * @param other The arithmetical fraction to divide by.
     * @return A mutable arithmetical fraction representing the result of the division.
     */
    override operator fun div(other: Fraction<Numerator, Denominator>): MutableArithmeticalFraction<Numerator, Denominator> =
        copy().apply { this /= other }

    /**
     * Divides by another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to divide by.
     */
    operator fun divAssign(other: Fraction<Numerator, Denominator>)

    /**
     * Creates and returns a copy of the mutable arithmetical fraction.
     *
     * @return A copy of the mutable arithmetical fraction.
     */
    override fun copy(): MutableArithmeticalFraction<Numerator, Denominator>
}