package com.gemidroid.problem_solving.leetcode

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val mutList = mutableListOf<List<Int>>()
    val num1 = nums1.toMutableSet()
    val num2 = nums2.toMutableSet()
    for (i in nums1) {
        if (nums2.contains(i)) {
            num1.remove(i)
            num2.remove(i)
            mutList.add(num1.toMutableList())
            mutList.add(num2.toMutableList())
        }
    }
    val uniqueList = mutList.ifEmpty {
        mutList.apply {
            add(num1.toMutableList())
            add(num2.toMutableList())
        }
    }
    println(uniqueList.takeLast(2))
    return uniqueList.takeLast(2)
}

// findDifference(intArrayOf(1, 2, 3, 3), intArrayOf(1, 1, 2, 2))
