/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core.long

import tech.annexflow.fmath.core.AutoReduceMutableFraction
import tech.annexflow.fmath.core.MutableArithmeticalFraction

/**
 * A class representing a mutable arithmetical fraction of long-values that automatically reduces itself after each operation.
 */
internal class AutoReduceMutableLongFraction(
    mutableFraction: MutableArithmeticalFraction<Long, Long>
) : AutoReduceMutableFraction<Long, Long>(mutableFraction = mutableFraction) {
    /**
     * Creates and returns a copy of the mutable arithmetical fraction, automatically reducing it.
     *
     * @return A copy of the mutable arithmetical fraction in reduced form.
     */
    override fun copy(): MutableArithmeticalFraction<Long, Long> = AutoReduceMutableLongFraction(
        mutableFraction = this.mutableFraction.copy()
    )
}