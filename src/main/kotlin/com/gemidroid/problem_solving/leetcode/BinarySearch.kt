package com.gemidroid.problem_solving.leetcode

fun search(nums: IntArray, target: Int): Int {
    return if(nums.contains(target))
        nums.indexOf(target)
    else -1
}