package com.gemidroid.LeetCodeExamples

fun main() {
    val list = listOf("A", "B", "C", "F", "J", "Z")
    println("IndexedItem is: ${SearchForItemExample.findItem(list,"A")}")
}

object SearchForItemExample {
    // search for items
    fun <T> findItem(list: List<T>, itemNeeded: T): Int {
        var start = 0
        var end: Int = list.size - 1
        var center: Int = end / 2
        while (start <= end) {
            val itemIndex = list.indexOf(itemNeeded)
            if (itemIndex == center) {
                return center
            } else if (itemIndex < center) {
                end = center--
            } else if (itemIndex > center) {
                start = center++
            } else
                return -1
        }
        return -1
    }

}