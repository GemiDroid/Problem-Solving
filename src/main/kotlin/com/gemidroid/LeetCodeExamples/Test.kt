package com.gemidroid.LeetCodeExamples

import java.util.Arrays


fun main() {
    /* val items = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
     getData(7, items)
     */
    // print(getWrongAnswers(3, "AAAAA"))
    val nestedArr = Array(2) { IntArray(3)}
    nestedArr.apply {
        this[0] = intArrayOf(0,0,1)
        this[1] = intArrayOf(1, 0, 1)
    }
    print(getHitProbability(2, 3, nestedArr))
}

/*.........................Facebook Puzzles...............................*/
//#Puzzle2
fun getWrongAnswers(N: Int, C: String): String {
    // Write your code here
    return if (N in 1..100) {
        C.flipChars()
    } else {
        return C
    }
}

fun String.flipChars(): String {
    val arr = arrayOf("A", "B")
    val newString = StringBuilder()
    for (i in 0 until this.length) {
        newString.append(arr[if (this[i].toString() == arr[0]) 1 else 0])
    }
    return newString.toString()
}

//#Puzzle3
fun getHitProbability(R: Int, C: Int, G: Array<IntArray>): Double {
    // Write your code here
    var counter = 0
    for (i in 0 until R) {
        for (J in 0 until  C) {
            if(G[i][J] == 1){
                counter++
            }
        }
    }
    return counter/(R*C).toDouble()
}

//#Puzzle4
/*Todo("To be solved later...Level1 :)")*/
fun getMaxAdditionalDinersCount(N: Long, K: Long, M: Int, S: Array<Long>): Long {
    // Write your code here
    return 0
}

//____________________________________-----------------------_________________________//


fun getData(k: Int, items: IntArray) {
    val tempItems = mutableListOf<Int>()
    var index = 0
    val item = items[index]

    for (i in 1 until items.size) {
        if (item + items[i] == k) {
            tempItems.add(item)
            tempItems.add(items[i])
        } else index++
    }

    /*for (i in items.indices) {
        for (j in 1 until items.size - 1) {
            if (items[i] + items[j] == k) {
                tempItems.add(items[i])
                tempItems.add(items[j])
            }
        }
    }*/

    print(tempItems.joinToString(","))// 1,5, 3,4
}

