/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core.util

/**
 * Calculates the greatest common divisor (GCD) of two long-values using Euclid's algorithm.
 *
 * @param a The first long-value.
 * @param b The second long-value.
 * @return The greatest common divisor of the two long-values.
 */
internal tailrec fun greatestCommonDivisor(a: Long, b: Long): Long {
    if (b == 0L) return a
    return greatestCommonDivisor(a = b, b = a % b)
}