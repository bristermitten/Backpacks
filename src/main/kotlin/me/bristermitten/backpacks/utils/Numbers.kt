package me.bristermitten.backpacks.utils

import java.text.DecimalFormat

private val format = DecimalFormat("#.##")
fun Double.truncated() = format.format(this)
