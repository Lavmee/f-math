/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.fraction.core

/**
 * A class representing a mutable arithmetical fraction that automatically reduces itself after each operation.
 */
abstract class AutoReduceMutableFraction<Numerator, Denominator>(
    protected val mutableFraction: MutableArithmeticalFraction<Numerator, Denominator>
) : MutableArithmeticalFraction<Numerator, Denominator> by mutableFraction {

    /**
     * Initializes the fraction by reducing it to its simplest form.
     */
    init {
        this.reduce()
    }

    /**
     * Overrides the addition assignment operation and reduces the fraction afterward.
     *
     * @param other The fraction to add.
     */
    override fun plusAssign(other: Fraction<Numerator, Denominator>): Unit =
        mutableFraction.plusAssign(other).also { reduce() }

    /**
     * Overrides the subtraction assignment operation and reduces the fraction afterward.
     *
     * @param other The fraction to subtract.
     */
    override fun minusAssign(other: Fraction<Numerator, Denominator>): Unit =
        mutableFraction.minusAssign(other).also { reduce() }

    /**
     * Overrides the multiplication assignment operation and reduces the fraction afterward.
     *
     * @param other The fraction to multiply by.
     */
    override fun timesAssign(other: Fraction<Numerator, Denominator>): Unit =
        mutableFraction.timesAssign(other).also { reduce() }

    /**
     * Overrides the division assignment operation and reduces the fraction afterward.
     *
     * @param other The fraction to divide by.
     */
    override fun divAssign(other: Fraction<Numerator, Denominator>): Unit =
        mutableFraction.divAssign(other).also { reduce() }

    /**
     * Checks whether this auto-reduce fraction is equal to another object.
     *
     * @param other The object to compare.
     * @return `true` if the objects are equal, `false` otherwise.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is Fraction<*, *>) return false
        if (numerator != other.numerator) return false
        if (denominator != other.denominator) return false

        return true
    }

    /**
     * Generates a hash code for this auto-reduce fraction.
     *
     * @return The hash code of the underlying mutable fraction.
     */
    override fun hashCode(): Int = mutableFraction.hashCode()
}