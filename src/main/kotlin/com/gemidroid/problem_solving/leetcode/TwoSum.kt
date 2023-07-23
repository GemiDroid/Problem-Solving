package com.gemidroid.problem_solving.leetcode

fun twoSum(nums: IntArray, target: Int): IntArray {
    val complement = hashMapOf<Int, Int>()
    nums.forEachIndexed { k, i ->
        val compIndex = complement[i]
        if (compIndex != null) {
            return intArrayOf(compIndex, k)
        }
        complement[target - i] = k
    }
    return intArrayOf(0, 0)
}

/**
 ** twoSum(intArrayOf(4, 2, 8, -2), 6).map { println(it)}
 */