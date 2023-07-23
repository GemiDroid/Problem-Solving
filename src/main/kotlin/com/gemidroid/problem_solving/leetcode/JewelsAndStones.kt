package com.gemidroid.problem_solving.leetcode

fun numJewelsInStones(jewels: String, stones: String): Int {
    var numMatching = 0
    stones.onEach { stone ->
        jewels.onEach { jewel ->
            if (stone == jewel)
                numMatching++
        }
    }
    return numMatching
}
/***
 ** println(numJewelsInStones("aA", "Aasdabbbb"))
 */
