/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core.util

/**
 * Calculates the greatest common divisor (GCD) of two integers using Euclid's algorithm.
 *
 * @param a The first integer.
 * @param b The second integer.
 * @return The greatest common divisor of the two integers.
 */
tailrec fun greatestCommonDivisor(a: Int, b: Int): Int {
    if (b == 0) return a
    return greatestCommonDivisor(a = b, b = a % b)
}

/**
 * Calculates the least common multiple (LCM) of two integers using their greatest common divisor (GCD).
 *
 * @param a The first integer.
 * @param b The second integer.
 * @return The least common multiple of the two integers.
 */
fun leastCommonMultiple(a: Int, b: Int): Int {
    return a / greatestCommonDivisor(a = a, b =b) * b
}