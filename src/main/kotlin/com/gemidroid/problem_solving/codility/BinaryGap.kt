package com.gemidroid.problem_solving.codility

fun solution(N: Int): Int {
    val mutableN = Integer.toBinaryString(N)
    val trimmedItems = mutableN.trimEnd { it == '0' } // Remove left zeros as not needed....

    val onesCount = trimmedItems.count { it == '1' } // count if you have only 1 as value ...
    val splitter = trimmedItems.split("1").map { item ->
        item.filter { it != ' ' }
    } // split the list with delimiter 1 and filter the empty strings from the result...
    if (onesCount == 1 || splitter.isEmpty()) return 0

    // Alternative way for Max comparison...
    /* var max = splitter[0]
     splitter.onEach {
         if (it > max)
             max = it
     }
         return max.length
     */
    return splitter.max().length
}