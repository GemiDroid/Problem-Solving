package com.gemidroid.LeetCodeExamples

fun main() {
    BadVersionExample.firstBadVersion(4)
}

object BadVersionExample {
    fun firstBadVersion(n: Int): Int {
        if (n <= 1 && isBadVersion(n)) return n
        val start = 1
        var mid = 0
        while (start <= n) {
            mid = (start + n) / 2
             if (isBadVersion(mid)) {
                 return mid
            } else
               mid ++
        }
    return -1
}

fun isBadVersion(item: Int): Boolean {
    return false
}

}