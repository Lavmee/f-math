/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core.long

import tech.annexflow.fmath.core.ArithmeticalFraction
import tech.annexflow.fmath.core.Fraction
import tech.annexflow.fmath.core.MutableArithmeticalFraction
import tech.annexflow.fmath.core.util.greatestCommonDivisor

/**
 * An open class representing a mutable arithmetical fraction of long-values.
 *
 * @param numerator The initial numerator of the fraction.
 * @param denominator The initial denominator of the fraction (must not be zero).
 */
internal class MutableLongFraction(numerator: Long, denominator: Long) : MutableArithmeticalFraction<Long, Long> {
    /**
     * The mutable numerator of the fraction.
     */
    override var mutableNumerator: Long = numerator

    /**
     * The mutable denominator of the fraction.
     */
    override var mutableDenominator: Long = denominator

    /**
     * The current numerator of the fraction.
     */
    override val numerator: Long get() = mutableNumerator

    /**
     * The current denominator of the fraction.
     */
    override val denominator: Long get() = mutableDenominator

    /**
     * The sign of the fraction: 0 for zero, 1 for positive, -1 for negative.
     */
    override val sign: Byte get() = if (numerator == 0L) 0 else if (numerator * denominator > 0) 1 else -1

    /**
     * Subtracts another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to subtract.
     */
    override fun minusAssign(other: Fraction<Long, Long>) {
        if (this.denominator == other.denominator)
            this.mutableNumerator -= other.numerator
        else {
            this.mutableNumerator = this.numerator * other.denominator - other.numerator * this.denominator
            this.mutableDenominator *= other.denominator
        }
    }

    /**
     * Subtracts another arithmetical fraction and returns a mutable result.
     *
     * @param other The arithmetical fraction to subtract.
     * @return A mutable arithmetical fraction representing the result of the subtraction.
     */
    override fun minus(other: ArithmeticalFraction<Long, Long>): MutableArithmeticalFraction<Long, Long> =
        copy().apply { this -= other }

    /**
     * Divides by another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to divide by.
     */
    override fun divAssign(other: Fraction<Long, Long>) {
        this.mutableNumerator *= other.denominator
        this.mutableDenominator *= other.numerator
    }

    /**
     * Divides by another arithmetical fraction and returns a mutable result.
     *
     * @param other The arithmetical fraction to divide by.
     * @return A mutable arithmetical fraction representing the result of the division.
     */
    override fun div(other: ArithmeticalFraction<Long, Long>): MutableArithmeticalFraction<Long, Long> =
        copy().apply { this /= other }

    /**
     * Multiplies by another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to multiply by.
     */
    override fun timesAssign(other: Fraction<Long, Long>) {
        this.mutableNumerator *= other.numerator
        this.mutableDenominator *= other.denominator
    }

    /**
     * Multiplies by another arithmetical fraction and returns a mutable result.
     *
     * @param other The arithmetical fraction to multiply by.
     * @return A mutable arithmetical fraction representing the result of the multiplication.
     */
    override fun times(other: ArithmeticalFraction<Long, Long>): MutableArithmeticalFraction<Long, Long> =
        copy().apply { this *= other }

    /**
     * Adds another fraction in place, modifying the current mutable fraction.
     *
     * @param other The fraction to add.
     */
    override fun plusAssign(other: Fraction<Long, Long>) {
        if (this.denominator == other.denominator)
            this.mutableNumerator += other.numerator
        else {
            this.mutableNumerator = this.numerator * other.denominator + other.numerator * this.denominator
            this.mutableDenominator *= other.denominator
        }
    }

    /**
     * Adds another arithmetical fraction and returns a mutable result.
     *
     * @param other The arithmetical fraction to add.
     * @return A mutable arithmetical fraction representing the result of the addition.
     */
    override fun plus(other: ArithmeticalFraction<Long, Long>): MutableArithmeticalFraction<Long, Long> =
        copy().apply { this += other }

    /**
     * Reduces the fraction to its simplest form by dividing both numerator and denominator by their greatest common divisor.
     */
    override fun reduce() {
        val gcd: Long = greatestCommonDivisor(this.numerator, this.denominator)
        if (gcd != 1L) {
            this.mutableNumerator /= gcd
            this.mutableDenominator /= gcd
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
    override fun compareTo(other: ArithmeticalFraction<Long, Long>): Int = when {
        this === other -> 0
        else -> (numerator * other.denominator).compareTo(other.numerator * denominator)
    }

    /**
     * Creates and returns a copy of the mutableLongFraction.
     *
     * @return A copy of the mutableLongFraction.
     */
    override fun copy(): MutableArithmeticalFraction<Long, Long> = MutableLongFraction(
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
     * Generates a hash code for this mutableLongFraction
     *
     * @return The generated hash code based on the values of mutableNumerator and mutableDenominator.
     */
    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }
}