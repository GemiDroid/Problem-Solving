package com.gemidroid.problem_solving.codility

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    println(sequence)
    println(array)
    if (sequence.size > array.size) return false
    val hashMap = mutableMapOf<Int, Int>()
    val seq = sequence.toMutableList()
    val arr = array.toMutableList()
    sequence.onEach {
        if (arr.contains(it)) {
            hashMap[sequence.indexOf(it)] = it
            seq.removeAt(seq.indexOf(it))
            arr.removeAt(arr.indexOf(it))
        }
    }
    val sortedMap = hashMap.keys.sorted()
    hashMap.values.forEach { item ->
        if (array.indexOf(item) < sequence.indexOf(item)) return false
    }
    return sortedMap == hashMap.keys.toList() && seq.isEmpty()
}