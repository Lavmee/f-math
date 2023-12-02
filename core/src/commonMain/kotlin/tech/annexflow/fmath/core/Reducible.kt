/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core

/**
 * Represents an interface for objects that can be reduced.
 * Implementing classes must provide a method to perform reduction.
 */
interface Reducible {
    /**
     * Reduces the object, modifying its state to a simplified form.
     */
    fun reduce()
}