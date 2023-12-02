/**
 * Copyright 2023, @lavmee and the project contributors
 **/

package tech.annexflow.fmath.core.util

/**
 * Data class representing the structure of a Float value, decomposed into its integer and fractional parts.
 *
 * @param integerPart The integer part of the Float.
 * @param fractionalPart The fractional part of the Float.
 * @param fractionalPartLength The length of the fractional part.
 */
internal data class FloatStructure(val integerPart: Int, val fractionalPart: Int, val fractionalPartLength: Int)

/**
 * Unpacks the values of a Float into its integer part, fractional part, and the length of the fractional part.
 * Handles scientific notation (e.g., "e-") in the string representation of the Float.
 *
 * @receiver The Float value to be unpacked.
 * @return The FloatStructure containing the decomposed parts of the Float.
 */
internal fun Float.unpackValues(): FloatStructure {
    val valueString = this.toFixedMaxString()
    val integerPart: Int
    val fractionalPart: Int
    val fractionalPartLength: Int

    // Check if the string representation contains scientific notation (e.g., "e-")
    if (valueString.contains(char = 'e', ignoreCase = true)) {
        // Split the string into fractional part and fractional part length
        val (fractionalPartString, fractionalPartLengthString) = valueString.split("e-", ignoreCase = true)

        // Set the integer part to 0 (scientific notation with negative exponent)
        integerPart = 0
        // Convert the fractional part and fractional part length to integers
        fractionalPart = fractionalPartString.toFloat().toInt()
        fractionalPartLength = fractionalPartLengthString.toInt()
    } else {
        // Split the string into integer part and fractional part
        val (integerPartString, fractionalPartString) = valueString.split(".")

        // Convert the integer part and fractional part to integers
        integerPart = integerPartString.toInt()
        fractionalPart = fractionalPartString.toInt()
        // Set the fractional part length to the length of the fractional part
        fractionalPartLength = fractionalPartString.length
    }

    // Return a FloatStructure containing the decomposed parts of the Float
    return FloatStructure(
        integerPart = integerPart,
        fractionalPart = fractionalPart,
        fractionalPartLength = fractionalPartLength
    )
}

/**
 * Rounds and formats a Float to a fixed maximum number of decimal places (6 by default).
 * Returns the formatted string representation of the Float.
 *
 * @receiver The Float value to be formatted.
 * @return The formatted string representation with a maximum of 6 decimal places.
 */
internal fun Float.toFixedMaxString(): String = this.toFixedString(count = 6)

/**
 * Rounds and formats a Float to a fixed number of decimal places.
 * Returns the formatted string representation of the Float.
 *
 * @receiver The Float value to be formatted.
 * @param count The number of decimal places to round to.
 * @return The formatted string representation with the specified number of decimal places.
 */
internal fun Float.toFixedString(count: Int): String {
    val valueString = this.toString()

    // If the string contains non-digit or non-dot characters, return the original string
    if (!valueString.all { it.isDigit() || it == '.' }) return valueString

    // Split the string into integer and fractional parts
    val (integerPartString, fractionalPartString) = valueString.split(".")

    // If the fractional part has fewer or equal decimal places than the specified count, return the original string
    if (fractionalPartString.length <= count) return valueString

    // Truncate the fractional part to the specified count + 1 decimal places
    val truncatedFractionalPart = fractionalPartString.substring(0, count + 1)

    // Build the formatted string with rounding
    return buildString {
        append(integerPartString)
        append('.')
        append(truncatedFractionalPart.dropLast(2))

        // Round the last digit based on the digit before it
        val lastDigit = truncatedFractionalPart.last().digitToInt()
        val preLastDigit = truncatedFractionalPart[count - 1].digitToInt()
        append(if (lastDigit >= 5) preLastDigit + 1 else preLastDigit)
    }
}