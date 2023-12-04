/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.fraction.primitive

import tech.annexflow.fmath.fraction.core.AutoReduceMutableFraction
import tech.annexflow.fmath.fraction.core.MutableArithmeticalFraction

/**
 * A class representing a mutable arithmetical fraction of integers that automatically reduces itself after each operation.
 */
internal class AutoReduceMutableIntFraction(
    mutableFraction: MutableArithmeticalFraction<Int, Int>
) : AutoReduceMutableFraction<Int, Int>(mutableFraction = mutableFraction) {
    /**
     * Creates and returns a copy of the mutable arithmetical fraction, automatically reducing it.
     *
     * @return A copy of the mutable arithmetical fraction in reduced form.
     */
    override fun copy(): MutableArithmeticalFraction<Int, Int> = AutoReduceMutableIntFraction(
        mutableFraction = this.mutableFraction.copy()
    )
}