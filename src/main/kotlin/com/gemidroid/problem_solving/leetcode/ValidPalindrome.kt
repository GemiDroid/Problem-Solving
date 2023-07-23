package com.gemidroid.problem_solving.leetcode

fun isPalindrome(s: String): Boolean {
    var reversedVar = ""
    // Alternative way for reversing the String..as s.reversed()
    for (i in s.length - 1 downTo 0) {
        reversedVar += s[i]
    }
    return reversedVar.equals(s, true)
}

/**
 **  print(isPalindrome("`l;`` 1o1 ??;l`"))
 **/