/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core

/**
 * Represents an interface for a copyable fraction, extending the Fraction interface and the Copyable interface.
 *
 * @param Numerator The type of the numerator.
 * @param Denominator The type of the denominator.
 */
interface CopyableFraction<Numerator, Denominator> : Fraction<Numerator, Denominator>, Copyable