package me.bristermitten.backpacks.utils

import java.text.DecimalFormat

private val TRUNCATING_FORMAT = DecimalFormat("#.##")

/**
 * Truncate a [Double] to 2 decimal places.
 */
fun Double.truncated(): String = TRUNCATING_FORMAT.format(this)
