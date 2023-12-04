/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.fraction.core

/**
 * A class representing a read-only view of a mutable arithmetical fraction.
 *
 * @param Numerator The type of the numerator.
 * @param Denominator The type of the denominator.
 * @property mutableFraction The underlying mutable arithmetical fraction.
 */
class ReadOnlyArithmeticalFraction<Numerator, Denominator>(
    internal val mutableFraction: MutableArithmeticalFraction<Numerator, Denominator>
) : ArithmeticalFraction<Numerator, Denominator> by mutableFraction {

    /**
     * Checks whether this read-only fraction is equal to another object.
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
     * Generates a hash code for this read-only fraction.
     *
     * @return The hash code of the underlying mutable fraction.
     */
    override fun hashCode(): Int = mutableFraction.hashCode()
}