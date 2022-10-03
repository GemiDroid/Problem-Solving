package com.gemidroid.LeetCodeExamples

fun main() {
    val list = mutableListOf(-1, 0, 10, 3, 20, 11)
    println("Sorted Items are: ${SortItemsExample.sortItems(list)}")
}

object SortItemsExample {
    // sorting items
    fun sortItems(list: MutableList<Int>): List<Int> {
        var tempItem: Int
        for (i in list.indices) {
            for (j in i + 1 until list.size) {
                if(list[i] > list[j]){
                    tempItem = list[j]
                    list[j] = list[i]
                    list[i] = tempItem
                }
            }
        }
        return list
    }
}