package com.gemidroid.problem_solving.leetcode

import java.util.*

fun isValid(s: String): Boolean {
    val items = Stack<Char>()
    if (s.contains(Regex("[\\{\\}\\(\\)\\[\\]]"))) {
        s.onEach {
            if (it == '(' || it == '{' || it == '[')
                items.push(it)
            else {
                if (items.isEmpty()) return false
                else {
                    val top = items.lastElement()
                    if (top == '(' && it != ')'
                        || top == '{' && it != '}'
                        || top == '[' && it != ']'
                    )
                        return false
                    else items.pop()
                }
            }
        }
    } else {
        return false
    }
    return items.isEmpty()
}

/**
 ** println(isValid("(]"))
 */