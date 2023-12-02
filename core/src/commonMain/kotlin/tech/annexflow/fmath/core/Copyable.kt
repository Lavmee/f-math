/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core

/**
 * Represents an interface for objects that can be copied.
 * Implementing classes must provide a method to create a copy of the object.
 */
interface Copyable {
    /**
     * Creates and returns a copy of the object.
     *
     * @return A copy of the object.
     */
    fun copy(): Copyable
}