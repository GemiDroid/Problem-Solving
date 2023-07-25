package com.gemidroid.problem_solving.leetcode

/**
 ** Todo("Still 1 TC remaining, to be continued....")
 */
fun myPow(x: Double, n: Int): Double {
    var sum = 0.0
    if (n == 0) return 1.0 // special case if n == 0
    if (n == 1) return x
    if (n >= recurPow(2.0, 31) - 1 || n <= (recurPow(2.0, 31) - 1) * -1)
        return if (x < 0 && n < 0) -x
        else if (n > 0 && x < 0 || x == 1.0) x
        else if(x == 1.0 || (x > 1 && x.toString().contains("."))) 0.0
        else if (n < 0 ) (1.0 / x)
        else 0.0
    val multi = recurPow(x, n)
    if (n < 0) {
        val ni = n * -1
        val xi = 1 / x
        if (ni == 1)
            return xi
        if (ni < 0)
            return 0.0
        return recurPow(xi, ni)
    }
    sum += multi

    return sum
}

private fun recurPow(x: Double, n: Int): Double {
    var multi = (x * x)
    if (n >= 3) {
        for (i in 0 until n - 2) {
            multi *= x
        }
    }
    return multi
}

fun main() {
    println(
        myPow(
            1.0000000000001
            , -2147483648
        )
    )
}