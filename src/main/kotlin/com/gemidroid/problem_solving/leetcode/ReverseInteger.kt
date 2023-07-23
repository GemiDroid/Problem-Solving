package com.gemidroid.problem_solving.leetcode

fun reverse(x: Int): Int {
    var newX = x.toString()
    if (newX.startsWith("-")) {
        newX = newX.replace("-", "")
        return (newX.reversed().toIntOrNull() ?: 0) * -1
    }
    return newX.reversed().toIntOrNull() ?: 0
}
/**
 ** println(reverse(-2147483648))
 */

