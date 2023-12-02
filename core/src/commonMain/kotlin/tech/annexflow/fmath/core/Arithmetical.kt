/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core

/**
 * Represents an interface for objects that support basic arithmetic operations.
 *
 * @param T The type of the operands and results for arithmetic operations.
 */
interface Arithmetical <T> {
    /**
     * Multiplies this object by another.
     *
     * @param other The other object to multiply by.
     * @return The result of the multiplication.
     */
    operator fun times(other: T): T

    /**
     * Divides this object by another.
     *
     * @param other The other object to divide by.
     * @return The result of the division.
     */
    operator fun div(other: T): T

    /**
     * Adds another object to this one.
     *
     * @param other The other object to add.
     * @return The result of the addition.
     */
    operator fun plus(other: T): T

    /**
     * Subtracts another object from this one.
     *
     * @param other The other object to subtract.
     * @return The result of the subtraction.
     */
    operator fun minus(other: T): T
}