/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.fraction.primitive

import tech.annexflow.fmath.fraction.core.Fraction
import tech.annexflow.fmath.fraction.core.MutableArithmeticalFraction
import tech.annexflow.fmath.core.util.greatestCommonDivisor
import kotlin.math.abs

/**
 * An open class representing a mutable arithmetical fraction of integers.
 *
 * @param numerator The initial numerator of the fraction.
 * @param denominator The initial denominator of the fraction (must not be zero).
 */
internal class MutableIntFraction(numerator: Int, denominator: Int) : MutableArithmeticalFraction<Int, Int> {
    /**
     * The mutable numerator of the fraction.
     */
    override var mutableNumerator: Int = numerator

    /**
     * The mutable denominator of the fraction.
     */
    override var mutableDenominator: Int = denominator

    /**
     * Subtracts another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to subtract.
     */
    override fun minusAssign(other: Fraction<Int, Int>) {
        if (this.denominator == other.denominator)
            this.mutableNumerator -= other.numerator
        else {
            this.mutableNumerator = this.numerator * other.denominator - other.numerator * this.denominator
            this.mutableDenominator *= other.denominator
        }
    }

    /**
     * Divides by another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to divide by.
     */
    override fun divAssign(other: Fraction<Int, Int>) {
        this.mutableNumerator *= other.denominator
        this.mutableDenominator *= other.numerator
    }

    /**
     * Multiplies by another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to multiply by.
     */
    override fun timesAssign(other: Fraction<Int, Int>) {
        this.mutableNumerator *= other.numerator
        this.mutableDenominator *= other.denominator
    }

    /**
     * Adds another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to add.
     */
    override fun plusAssign(other: Fraction<Int, Int>) {
        if (this.denominator == other.denominator)
            this.mutableNumerator += other.numerator
        else {
            this.mutableNumerator = this.numerator * other.denominator + other.numerator * this.denominator
            this.mutableDenominator *= other.denominator
        }
    }

    /**
     * Reduces the fraction to its simplest form by dividing both numerator and denominator by their greatest common divisor.
     */
    override fun reduce() {
        val gcd: Int = greatestCommonDivisor(this.numerator, this.denominator)
        if (gcd != 1) {
            this.mutableNumerator /= gcd
            this.mutableDenominator /= gcd
        }
        if (this.numerator < 0 && this.denominator < 0) {
            this.mutableNumerator = abs(this.numerator)
            this.mutableDenominator = abs(this.denominator)
        }
    }

    /**
     * Returns a string representation of the fraction in the form "numerator/denominator".
     *
     * @return The string representation of the fraction.
     */
    override fun toString(): String = "$numerator/$denominator"

    /**
     * Compares this fraction with another.
     *
     * @param other The other fraction to compare.
     * @return An integer representing the comparison result.
     */
    override fun compareTo(other: Fraction<Int, Int>): Int = when {
        this === other -> 0
        else -> (numerator * other.denominator).compareTo(other.numerator * denominator)
    }

    /**
     * Creates and returns a copy of the mutableIntFraction.
     *
     * @return A copy of the mutableIntFraction.
     */
    override fun copy(): MutableArithmeticalFraction<Int, Int> = MutableIntFraction(
        numerator = this.numerator,
        denominator = this.denominator
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is Fraction<*, *>) return false
        if (numerator != other.numerator) return false
        if (denominator != other.denominator) return false

        return true
    }

    /**
     * Generates a hash code for this mutableIntFraction
     *
     * @return The generated hash code based on the values of mutableNumerator and mutableDenominator.
     */
    override fun hashCode(): Int {
        var result = numerator
        result = 31 * result + denominator
        return result
    }
}