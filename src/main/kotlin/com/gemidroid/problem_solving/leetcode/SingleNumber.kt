package com.gemidroid.problem_solving.leetcode

fun singleNumber(nums: IntArray): Int {
    nums.forEach { item ->
        val counter = nums.count { it == item }
        if (counter == 1)
            return item
    }
    return -1
}
//  println(singleNumber(intArrayOf(1, 2, 3, 4, 4, 3, 1)))
