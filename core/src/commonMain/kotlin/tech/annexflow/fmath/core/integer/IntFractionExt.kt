/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core.integer

import tech.annexflow.fmath.core.ArithmeticalFraction
import tech.annexflow.fmath.core.Fraction
import tech.annexflow.fmath.core.MutableArithmeticalFraction
import tech.annexflow.fmath.core.toImmutableFraction
import kotlin.math.pow

/**
 * Utility functions and extensions for working with mutable and immutable arithmetic fractions of type Int.
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
    numerator: Int,
    denominator: Int,
    isAutoReducing: Boolean = true,
): MutableArithmeticalFraction<Int, Int> {
    require(value = denominator != 0) { "Denominator is zero!" }
    val mutableFraction = MutableIntFraction(numerator = numerator, denominator = denominator)
    return if (isAutoReducing) AutoReduceMutableIntFraction(mutableFraction = mutableFraction)
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
    numerator: Int,
    denominator: Int,
    isAutoReducing: Boolean = true,
): ArithmeticalFraction<Int, Int> =
    mutableFractionOf(numerator = numerator, denominator = denominator, isAutoReducing = isAutoReducing)
        .toImmutableFraction()

/**
 * Exponentiates a mutable arithmetical fraction to the specified power.
 *
 * @receiver The mutable arithmetical fraction to exponentiate.
 * @param exp The exponent.
 */
infix fun MutableArithmeticalFraction<Int, Int>.exponentiate(exp: Int) {
    mutableNumerator = this.numerator.toDouble().pow(exp).toInt()
    mutableDenominator = this.denominator.toDouble().pow(exp).toInt()
}

/**
 * Exponentiates an immutable arithmetical fraction to the specified power.
 *
 * @receiver The immutable arithmetical fraction to exponentiate.
 * @param exp The exponent.
 * @return An immutable arithmetical fraction representing the result of the exponentiation.
 */
infix fun ArithmeticalFraction<Int, Int>.exponentiated(exp: Int): ArithmeticalFraction<Int, Int> {
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
fun ArithmeticalFraction<Int, Int>.reduced(): ArithmeticalFraction<Int, Int> {
    val mutableFraction = this.toMutableFraction()
    mutableFraction.reduce()
    return mutableFraction.toImmutableFraction()
}

/**
 * Negates a mutable arithmetical fraction.
 *
 * @receiver The mutable arithmetical fraction to negate.
 */
fun MutableArithmeticalFraction<Int, Int>.negatory() {
    this.mutableDenominator *= -1
}

/**
 * Negates an immutable arithmetical fraction.
 *
 * @receiver The immutable arithmetical fraction to negate.
 * @return An immutable arithmetical fraction representing the negation.
 */
fun ArithmeticalFraction<Int, Int>.negatored(): ArithmeticalFraction<Int, Int> {
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
fun ArithmeticalFraction<Int, Int>.toMutableFraction(): MutableArithmeticalFraction<Int, Int> =
    this.copy() as MutableArithmeticalFraction<Int, Int>

/**
 * Converts an integer to an immutable arithmetical fraction.
 *
 * @receiver The integer to convert.
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return An immutable arithmetical fraction representing the integer.
 */
fun Int.toFraction(isAutoReducing: Boolean = true): ArithmeticalFraction<Int, Int> =
    this.toMutableFraction(isAutoReducing = isAutoReducing).toImmutableFraction()

/**
 * Converts an integer to a mutable arithmetical fraction.
 *
 * @receiver The integer to convert.
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return A mutable arithmetical fraction representing the integer.
 */
fun Int.toMutableFraction(isAutoReducing: Boolean = true): MutableArithmeticalFraction<Int, Int> =
    mutableFractionOf(numerator = this, denominator = 1, isAutoReducing = isAutoReducing)

/**
 * Converts a pair of integers to an immutable arithmetical fraction.
 *
 * @receiver The pair of integers (numerator and denominator) to convert.
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return An immutable arithmetical fraction representing the pair.
 */
fun Pair<Int, Int>.toFraction(isAutoReducing: Boolean = true): ArithmeticalFraction<Int, Int> =
    fractionOf(numerator = this.first, denominator = this.second, isAutoReducing = isAutoReducing)

/**
 * Converts a pair of integers to a mutable arithmetical fraction.
 *
 * @receiver The pair of integers (numerator and denominator) to convert.
 * @param isAutoReducing Flag indicating whether the fraction should auto-reduce.
 * @return A mutable arithmetical fraction representing the pair.
 */
fun Pair<Int, Int>.toMutableFraction(isAutoReducing: Boolean = true): ArithmeticalFraction<Int, Int> =
    mutableFractionOf(numerator = this.first, denominator = this.second, isAutoReducing = isAutoReducing)

/**
 * Extension property that calculates and returns the float value of an immutable arithmetical fraction.
 * The value is obtained by dividing the numerator by the denominator.
 *
 * @receiver The immutable arithmetical fraction for which to calculate the float value.
 * @return The float value of the arithmetical fraction.
 */
val Fraction<Int, Int>.floatValue: Float get() = this.numerator.toFloat() / this.denominator