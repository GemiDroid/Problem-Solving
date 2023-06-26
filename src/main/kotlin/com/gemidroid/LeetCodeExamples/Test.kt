package com.gemidroid.LeetCodeExamples

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.util.StringJoiner

@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    val flow1 = flowOf("A", "B", "C")
    val flow2 = flowOf(1, 2, 3, 4, 5)

    runBlocking {
        merge(flow1, flow2).collect {
             println(it) // A, B, C, 1, 2, 3, 4, 5
        }
    }
    runBlocking {
        flow1.combine(flow2) { f1, f2 -> "${f1}_${f2}" }
            .collect {
                println(it)// A_1, B_2, C_3, C_4, C_5
            }
    }
    runBlocking {
        flow1.zip(flow2) { f1, f2 -> "$f1 : $f2" }
            .collect { println(it) // A:1, B:2, C:3
            }
    }

    print(isPalindrome("`l;`` 1o1 ??;l`"))
}

fun isPalindrome(s: String): Boolean{
    // That's special rule...
    val formattedString = s.replace(Regex( "[ `;?',:.@#%^&*(){}_\\- \"\\[\\]]"), "")
    var reversedVar = ""
    println(formattedString)
    // Alternative way for reversing the String..as s.reversed()
    for (i in formattedString.length-1 downTo  0){
        reversedVar+= formattedString[i]
    }
    println(reversedVar)
    return reversedVar.equals(formattedString, true)
}