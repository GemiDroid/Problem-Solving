package com.gemidroid.problem_solving.leetcode

fun checkIfPangram(sentence: String): Boolean {
    val sentenceSet = sentence.toSet()
    return 26 == sentenceSet.size
}
/**
 **  print(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
 */
