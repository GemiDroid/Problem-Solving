package com.gemidroid.LeetCodeExamples

fun main(){
    println(SearchInsertExample.searchInsert(intArrayOf(1,2,4,5), 3))
}

object SearchInsertExample {
    fun searchInsert(nums: IntArray, target: Int): Int {
        val list = nums.toMutableList()
        val index = nums.indexOf(target)
        if(index==-1)
            list.add(target)
        list.sort()
        return list.indexOf(target)
    }
}