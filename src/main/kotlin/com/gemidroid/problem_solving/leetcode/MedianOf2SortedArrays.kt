package com.gemidroid.problem_solving.leetcode

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val mergedList = nums1.plus(nums2).sorted()
    val median = if (mergedList.size % 2 != 0)
        mergedList[mergedList.size / 2].toDouble()
    else {
        val beforeMid = ((mergedList.size - 1) / 2)
        ((mergedList[beforeMid] + mergedList[beforeMid + 1]).toDouble() / 2)
    }
    return median
}

/*
 ** findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))
 */
