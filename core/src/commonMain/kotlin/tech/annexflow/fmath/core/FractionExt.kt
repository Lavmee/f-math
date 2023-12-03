/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core

/**
 * Provides destructuring components for a generic Fraction, allowing easy access to its numerator and denominator.
 *
 * @param Numerator The type of the numerator.
 * @param Denominator The type of the denominator.
 * @return The numerator and denominator as components.
 */
operator fun <Numerator, Denominator> Fraction<Numerator, Denominator>.component1(): Numerator = numerator
operator fun <Numerator, Denominator> Fraction<Numerator, Denominator>.component2(): Denominator = denominator

/**
 * Extension function to convert a mutable arithmetical fraction to an immutable (read-only) arithmetical fraction.
 *
 * @receiver The mutable arithmetical fraction to convert.
 * @return An immutable (read-only) arithmetical fraction.
 */
fun <Numerator, Denominator> MutableArithmeticalFraction<Numerator, Denominator>.toImmutableFraction():
        ArithmeticalFraction<Numerator, Denominator> = ReadOnlyFraction(mutableFraction = this.copy())