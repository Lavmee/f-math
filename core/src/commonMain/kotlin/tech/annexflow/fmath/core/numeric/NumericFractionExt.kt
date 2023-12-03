/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core.numeric

import tech.annexflow.fmath.core.Fraction

/**
 * Property extension for the sign of a Fraction, represented as a Byte.
 * The sign is determined based on the sign of the numerator and denominator of the Fraction.
 * Returns 0 if the numerator is zero, 1 if both numerator and denominator have the same sign, and -1 otherwise.
 *
 * @receiver The Fraction for which the sign is calculated.
 * @return The sign of the Fraction as a Byte.
 */
val <Numerator : Number, Denominator : Number> Fraction<Numerator, Denominator>.sign: Byte
    get() {
        val numeratorDouble = this.numerator.toDouble()
        val denominatorDouble = this.denominator.toDouble()
        if (numeratorDouble == 0.0) return 0
        if ((numeratorDouble > 0 && denominatorDouble > 0) || (numeratorDouble < 0 && denominatorDouble < 0)) return 1
        return -1
    }