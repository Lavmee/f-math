package tech.annexflow.fmath.sample

import tech.annexflow.fmath.fraction.primitive.exponentiated
import tech.annexflow.fmath.fraction.primitive.floatValue
import tech.annexflow.fmath.fraction.primitive.fractionOf
import tech.annexflow.fmath.fraction.primitive.mutableFractionOf
import tech.annexflow.fmath.fraction.primitive.negatored
import tech.annexflow.fmath.fraction.primitive.toFraction
import tech.annexflow.fmath.fraction.primitive.toMutableFraction

/**
 * Copyright 2023, @lavmee and the project contributors
 **/

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
}