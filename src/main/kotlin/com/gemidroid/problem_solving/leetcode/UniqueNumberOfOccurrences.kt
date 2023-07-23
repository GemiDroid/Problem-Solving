package com.gemidroid.problem_solving.leetcode

fun uniqueOccurrences(arr: IntArray): Boolean {
    val hash by lazy { hashMapOf<Int, Int>() }
    val counter = 1
    arr.forEach { i ->
        if (hash[i] != null)
            hash[i] = hash[i]!!.inc()
        else
            hash[i] = counter
    }
    val uniqueSet = hash.values.toSet()
    return uniqueSet.size == hash.entries.size
}

// print(uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))


