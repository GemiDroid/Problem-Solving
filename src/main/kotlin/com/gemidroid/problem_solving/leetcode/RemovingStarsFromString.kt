package com.gemidroid.problem_solving.leetcode

import java.util.*

fun removeStars(s: String): String {
    val stackBuilder by lazy { Stack<Char>() }
    s.forEach { c ->
        if (c == '*' && stackBuilder.isNotEmpty())
            stackBuilder.pop()
        else
            stackBuilder.add(c)
    }
    return stackBuilder.joinToString("")
}
//print(removeStars("erase*****"))


