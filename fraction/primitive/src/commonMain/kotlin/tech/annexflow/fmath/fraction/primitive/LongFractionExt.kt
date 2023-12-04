/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.fraction.primitive

import tech.annexflow.fmath.fraction.core.ArithmeticalFraction
import tech.annexflow.fmath.fraction.core.Fraction
import tech.annexflow.fmath.fraction.core.MutableArithmeticalFraction
import tech.annexflow.fmath.fraction.core.toImmutableFraction
import kotlin.math.pow

/**
 * Utility functions and extensions for working with mutable and immutable arithmetic fractions of type Long.
 * These functions provide convenient operations such as creation, exponentiation, negation, reduction, and conversion.
 */

/**
 * Creates a mutable arithmetical fraction with the specified numerator and denominator.
 *
 * @param numerator The numerator of the fraction.
 * @param denominator The denominator of the fraction (must not be zero).
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return A mutable arithmetical fraction.
 * @throws IllegalArgumentException if the denominator is zero.
 */
fun mutableFractionOf(
    numerator: Long,
    denominator: Long,
    isAutoReducing: Boolean = true,
): MutableArithmeticalFraction<Long, Long> {
    require(value = denominator != 0L) { "Denominator is zero!" }
    val mutableFraction = MutableLongFraction(numerator = numerator, denominator = denominator)
    return if (isAutoReducing) AutoReduceMutableLongFraction(mutableFraction = mutableFraction)
    else mutableFraction
}

/**
 * Creates an immutable arithmetical fraction with the specified numerator and denominator.
 *
 * @param numerator The numerator of the fraction.
 * @param denominator The denominator of the fraction (must not be zero).
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return An immutable arithmetical fraction.
 * @throws IllegalArgumentException if the denominator is zero.
 */
fun fractionOf(
    numerator: Long,
    denominator: Long,
    isAutoReducing: Boolean = true,
): ArithmeticalFraction<Long, Long> =
    mutableFractionOf(numerator = numerator, denominator = denominator, isAutoReducing = isAutoReducing)
        .toImmutableFraction()

/**
 * Exponentiates a mutable arithmetical fraction to the specified power.
 *
 * @receiver The mutable arithmetical fraction to exponentiate.
 * @param exp The exponent.
 */
infix fun MutableArithmeticalFraction<Long, Long>.exponentiate(exp: Int) {
    mutableNumerator = this.numerator.toDouble().pow(exp).toLong()
    mutableDenominator = this.denominator.toDouble().pow(exp).toLong()
}

/**
 * Exponentiates an immutable arithmetical fraction to the specified power.
 *
 * @receiver The immutable arithmetical fraction to exponentiate.
 * @param exp The exponent.
 * @return An immutable arithmetical fraction representing the result of the exponentiation.
 */
infix fun ArithmeticalFraction<Long, Long>.exponentiated(exp: Int): ArithmeticalFraction<Long, Long> {
    val mutableFraction = this.toMutableFraction()
    mutableFraction.exponentiate(exp)
    return mutableFraction.toImmutableFraction()
}

/**
 * Reduces an immutable arithmetical fraction.
 *
 * @receiver The immutable arithmetical fraction to reduce.
 * @return An immutable arithmetical fraction in reduced form.
 */
fun ArithmeticalFraction<Long, Long>.reduced(): ArithmeticalFraction<Long, Long> {
    val mutableFraction = this.toMutableFraction()
    mutableFraction.reduce()
    return mutableFraction.toImmutableFraction()
}

/**
 * Negates a mutable arithmetical fraction.
 *
 * @receiver The mutable arithmetical fraction to negate.
 */
fun MutableArithmeticalFraction<Long, Long>.negatory() {
    this.mutableDenominator *= -1
}

/**
 * Negates an immutable arithmetical fraction.
 *
 * @receiver The immutable arithmetical fraction to negate.
 * @return An immutable arithmetical fraction representing the negation.
 */
fun ArithmeticalFraction<Long, Long>.negatored(): ArithmeticalFraction<Long, Long> {
    val mutableFraction = this.toMutableFraction()
    mutableFraction.negatory()
    return mutableFraction.toImmutableFraction()
}

/**
 * Converts an immutable arithmetical fraction to a mutable arithmetical fraction.
 *
 * @receiver The immutable arithmetical fraction to convert.
 * @return A mutable arithmetical fraction.
 */
fun ArithmeticalFraction<Long, Long>.toMutableFraction(): MutableArithmeticalFraction<Long, Long> =
    this.copy() as MutableArithmeticalFraction<Long, Long>

/**
 * Converts an integer to an immutable arithmetical fraction.
 *
 * @receiver The integer to convert.
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return An immutable arithmetical fraction representing the integer.
 */
fun Long.toFraction(isAutoReducing: Boolean = true): ArithmeticalFraction<Long, Long> =
    this.toMutableFraction(isAutoReducing = isAutoReducing).toImmutableFraction()

/**
 * Converts an integer to a mutable arithmetical fraction.
 *
 * @receiver The integer to convert.
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return A mutable arithmetical fraction representing the integer.
 */
fun Long.toMutableFraction(isAutoReducing: Boolean = true): MutableArithmeticalFraction<Long, Long> =
    mutableFractionOf(numerator = this, denominator = 1L, isAutoReducing = isAutoReducing)

/**
 * Converts a pair of integers to an immutable arithmetical fraction.
 *
 * @receiver The pair of integers (numerator and denominator) to convert.
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return An immutable arithmetical fraction representing the pair.
 */
fun Pair<Long, Long>.toFraction(isAutoReducing: Boolean = true): ArithmeticalFraction<Long, Long> =
    fractionOf(numerator = this.first, denominator = this.second, isAutoReducing = isAutoReducing)

/**
 * Converts a pair of integers to a mutable arithmetical fraction.
 *
 * @receiver The pair of integers (numerator and denominator) to convert.
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return A mutable arithmetical fraction representing the pair.
 */
fun Pair<Long, Long>.toMutableFraction(isAutoReducing: Boolean = true): ArithmeticalFraction<Long, Long> =
    mutableFractionOf(numerator = this.first, denominator = this.second, isAutoReducing = isAutoReducing)

/**
 * Extension property that calculates and returns the float value of an immutable arithmetical fraction.
 * The value is obtained by dividing the numerator by the denominator.
 *
 * @receiver The immutable arithmetical fraction for which to calculate the float value.
 * @return The float value of the arithmetical fraction.
 */
val Fraction<Long, Long>.doubleValue: Double get() = this.numerator.toDouble() / this.denominator