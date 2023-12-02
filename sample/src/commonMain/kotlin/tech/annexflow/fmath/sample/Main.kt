package tech.annexflow.fmath.sample

import tech.annexflow.fmath.core.ExperimentalFMathApi
import tech.annexflow.fmath.core.integer.floatValue
import tech.annexflow.fmath.core.integer.exponentiated
import tech.annexflow.fmath.core.integer.fractionOf
import tech.annexflow.fmath.core.integer.mutableFractionOf
import tech.annexflow.fmath.core.integer.negatored
import tech.annexflow.fmath.core.integer.reduced
import tech.annexflow.fmath.core.integer.toFraction
import tech.annexflow.fmath.core.integer.toMutableFraction

/**
 * Copyright 2023, @lavmee and the project contributors
 **/

@OptIn(ExperimentalFMathApi::class)
fun main() {
    val firstFraction = mutableFractionOf(2, 3)
    firstFraction+=(3 to 18).toFraction()
    println(firstFraction)
    val firstFractionNegatored = fractionOf(2, 3).negatored()
    val fromPairFraction = (2 to 3).toFraction()
    val fromPairMutableFraction = (2 to 3).toMutableFraction()

    val secondFraction = fractionOf(5, 2)
    val plusFractionResult = firstFraction + secondFraction
    val minusFractionResult = firstFraction - secondFraction
    val multiplyFractionResult = firstFraction * secondFraction
    val divideFractionResult = firstFraction / secondFraction
    val powedFractionResult = firstFraction exponentiated  3
    val powedFractionResultDoubleValue = powedFractionResult.floatValue

    println("$firstFraction + $secondFraction = $plusFractionResult")
    println("$firstFraction - $secondFraction = $minusFractionResult")
    println("$firstFraction * $secondFraction = $multiplyFractionResult")
    println("$firstFraction / $secondFraction = $divideFractionResult")
    println("$firstFraction^3 = $powedFractionResult")
    println(listOf(plusFractionResult, minusFractionResult, multiplyFractionResult, divideFractionResult).sorted())
    println()

    val fractionFromDoubleOne = 1.0f.toFraction()
    val fractionFromDoubleHalf = 0.000005f.toFraction()
    println("1.0 = $fractionFromDoubleOne")
    println("0.5 = $fractionFromDoubleHalf")
    println("0.5 = ${fractionFromDoubleHalf.reduced()}")
}
