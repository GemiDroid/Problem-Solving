package com.gemidroid.problem_solving.codility

import kotlin.math.pow

fun addBinary(a: String, b: String): String {
    if ((a.isEmpty()) && (b.length > 10.0.pow(4.0).toInt())) return ""
    val num1 = a.toBigInteger(2)
    val num2 = b.toBigInteger(2)
    return Integer.toBinaryString(num1.plus(num2).toInt())
}