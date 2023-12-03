/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core.long

import tech.annexflow.fmath.core.Fraction
import tech.annexflow.fmath.core.MutableArithmeticalFraction

/**
 * A class representing a mutable arithmetical fraction of long-values that automatically reduces itself after each operation.
 *
 * @param numerator The initial numerator of the fraction.
 * @param denominator The initial denominator of the fraction (must not be zero).
 */
internal class AutoReduceMutableLongFraction(numerator: Long, denominator: Long) : MutableLongFraction(
    numerator = numerator,
    denominator = denominator
) {
    /**
     * Initializes the fraction by reducing it to its simplest form.
     */
    init {
        reduce()
    }

    /**
     * Overrides the addition assignment operation and reduces the fraction afterward.
     *
     * @param other The fraction to add.
     */
    override fun plusAssign(other: Fraction<Long, Long>): Unit = super.plusAssign(other).also { reduce() }

    /**
     * Overrides the subtraction assignment operation and reduces the fraction afterward.
     *
     * @param other The fraction to subtract.
     */
    override fun minusAssign(other: Fraction<Long, Long>): Unit = super.minusAssign(other).also { reduce() }

    /**
     * Overrides the multiplication assignment operation and reduces the fraction afterward.
     *
     * @param other The fraction to multiply by.
     */
    override fun timesAssign(other: Fraction<Long, Long>): Unit = super.timesAssign(other).also { reduce() }

    /**
     * Overrides the division assignment operation and reduces the fraction afterward.
     *
     * @param other The fraction to divide by.
     */
    override fun divAssign(other: Fraction<Long, Long>): Unit = super.divAssign(other).also { reduce() }

    /**
     * Creates and returns a copy of the mutable arithmetical fraction, automatically reducing it.
     *
     * @return A copy of the mutable arithmetical fraction in reduced form.
     */
    override fun copy(): MutableArithmeticalFraction<Long, Long> = AutoReduceMutableLongFraction(
        numerator = this.numerator,
        denominator = this.denominator
    )
}