package com.gemidroid.problem_solving.leetcode

fun longestCommonPrefix(strs: Array<String>): String {
    var prefix = strs[0]
    strs.forEach {
        while (it.indexOf(prefix) != 0)
            prefix = prefix.substring(0, prefix.length - 1)
    }
    return prefix
}

/**
 ** println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
 **/
