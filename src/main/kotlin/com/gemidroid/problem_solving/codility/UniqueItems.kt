package com.gemidroid.problem_solving.codility

import kotlin.math.pow


fun findUniqueItems(A: IntArray): Int {
    val tempList = mutableListOf<Int>()
    for (i in A.indices) {
        for (j in i + 1 until A.size) {
            if (A[i] == A[j]) {
                tempList.add(A[i])
            }
        }
    }
    return (A.subtract(tempList.toSet())).firstOrNull() ?: -1
}

fun solution1(A: IntArray): Int {
    if (A.isEmpty() && A.size <= (10.0.pow(6.0))) {
        val distinctItems = A.toSet()
        return distinctItems.size
    }
    return 0
}