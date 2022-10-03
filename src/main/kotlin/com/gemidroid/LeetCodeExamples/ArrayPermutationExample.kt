package com.gemidroid.LeetCodeExamples

import java.util.Arrays
import java.util.Collections

fun main(){
    println(ArrayPermutationExample.buildArray(intArrayOf(0,2,1,5,3,4)))
}
object ArrayPermutationExample {
    fun buildArray(nums: IntArray): IntArray {
        val arr = mutableListOf<Int>()
        for(i in nums.indices){
            arr.add(nums[nums[i]])
        }
        return arr.toIntArray()
    }
}