package com.gemidroid.problem_solving.leetcode

fun isPalindrome(x: Int): Boolean {
    var reversedVar = ""
    val formattedVar = x.toString()
    for (i in formattedVar.length - 1 downTo 0) {
        reversedVar += formattedVar[i]
    }
    println(reversedVar)
    return reversedVar.equals(formattedVar, true)
}
