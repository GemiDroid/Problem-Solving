package com.gemidroid.problem_solving.codility

fun countSegments(s: String): Int {
    return if (s.isEmpty()) 0
    else if (s.isBlank()) s.trim().length
    else {
        var newSt = s
        s.trim().forEachIndexed { index, item ->
            if (item == ',' && s[index + 1] == ',' || item == ' ' && s[index + 1] == ' ') {
                newSt = s.removePrefix(item.toString())
            }
        }
        val commonPrefix = newSt.trim().commonPrefixWith(",")
        val splitter = if (commonPrefix == ",") "," else " "
        newSt.trim().split(Regex(splitter)).size
    }
}