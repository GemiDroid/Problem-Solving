package com.gemidroid.problem_solving.leetcode

fun searchInsert(nums: IntArray, target: Int): Int {
    val list = nums.toMutableList()
    val index = nums.indexOf(target)
    if (index == -1)
        list.add(target)
    list.sort()
    return list.indexOf(target)
}
/**
 * print("index:${searchInsert(intArrayOf(1,3,4,5), 2)}")//index 1
 **/