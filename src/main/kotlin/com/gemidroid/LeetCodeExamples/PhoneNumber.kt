package com.gemidroid.LeetCodeExamples

import java.util.ListResourceBundle

fun main() {

    print(solution(intArrayOf(12,18,19)))

}


fun solution(A: IntArray): Boolean {
    A.sort()
   return A.find { it.minus(it+1) == 1 }!=null

}