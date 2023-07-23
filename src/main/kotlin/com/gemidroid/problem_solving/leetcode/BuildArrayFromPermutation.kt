package com.gemidroid.problem_solving.leetcode

fun buildArray(nums: IntArray): IntArray {
    val arr = mutableListOf<Int>()
    for (i in nums.indices) {
        arr.add(nums[nums[i]])
    }
    return arr.toIntArray()
}