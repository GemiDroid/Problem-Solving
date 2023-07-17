package com.gemidroid.LeetCodeExamples

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.Serializable
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.math.pow

fun main() {
    testX()
    val flow1 = flowOf("A", "B", "C")
    val flow2 = flowOf(1, 2, 3, 4, 5)
    runBlocking {
        merge(flow1, flow2).collect {
            // println(it) // A, B, C, 1, 2, 3, 4, 5
        }
    }
    runBlocking(Dispatchers.Default) {
        flow1.combine(flow2) { f1, f2 -> "${f1}_${f2}" }.collect {
            // println(it)// A_1, B_2, C_3, C_4, C_5
        }
    }
    runBlocking {
        flow1.zip(flow2) { f1, f2 -> "$f1 : $f2" }.collect {
            // println(it) // A:1, B:2, C:3
        }
    }

    // print(isPalindrome("`l;`` 1o1 ??;l`"))

    // print("index:${searchInsert(intArrayOf(1,3,4,5), 2)}")//index 1

    //println(numJewelsInStones("aA", "Aasdabbbb"))
    // println(isValid("(]"))
    /* println(
         addBinary(
             "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
             ""
         )
     )*/
    // println(romanToInt("MCDLXXVI"))

    // println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    // println(countSegments("foo    bar"))

    // testArrVsVector()

    // println(fibonacci(0))

    // println(findDuplicatedItems(listOf("Ahmed", "Ali", "Mona", "Ali", "Ahmed", "Mo")))

    // print(solution(6))

    // println(findUniqueItems(intArrayOf(6, 4, 4, 6, 5)))

    //print(solution3(mutableListOf(2, 4, 3, 5, 1)))
    // print(solution2("abacabad"))

    // println(nearestBuilding())
    // println(isValidSubsequence(arrayListOf(1, 1, 6, 1), arrayListOf(1, 1, 1, 6, 5)))

    // println(solution4(intArrayOf(9, 3, 9, 3, 9, 7, 9)))

    // val n = readLine()!!.trim().toInt()

    // fizzBuzz(n)

    // println(isAnagram("ABBA", "ABBB"))
    // println(assumeSum(listOf(9, 0, -1, 7), 8))

    val predicate2: IntPredicate2 = { i -> i % 2 == 0 }
    print(test(predicate2))
}

fun isPalindrome(s: String): Boolean {
    // That's special rule...
    val formattedString = s.replace(Regex("[ `;?',:.@#%^&*(){}_\\- \"\\[\\]]}"), "")
    var reversedVar = ""
    println(formattedString)
    // Alternative way for reversing the String..as s.reversed()
    for (i in formattedString.length - 1 downTo 0) {
        reversedVar += formattedString[i]
    }
    println(reversedVar)
    return reversedVar.equals(formattedString, true)
}

// Search for item index...
fun searchInsert(nums: IntArray, target: Int): Int {
    val list = nums.toMutableList()
    val index = nums.indexOf(target)
    if (index == -1) list.add(target)
    list.sort() // to sort list after element insertion....
    println(list)
    return list.indexOf(target)
}

// Count number of stones inside jewels...
fun numJewelsInStones(jewels: String, stones: String): Int { // ("aA"),("aAAbbbb")
    if (!stones.contains(Regex("[$jewels]"))) return 0
    // Way#1
    val stoneList = listOf(stones)
    val jewelList = listOf(jewels)
    val differ = stoneList.minus(jewelList.toSet())
    stoneList.minus(differ.toSet()).apply {
        println(this.toString().plus(", Size-> ${this.size}"))
    }
    // Way#2
    var numMatching = 0
    stones.onEach { stone ->
        jewels.onEach { jewel ->
            if (stone == jewel) numMatching++
        }
    }
    return numMatching
}

fun isValid(s: String): Boolean {
    val items = Stack<Char>()
    if (s.contains(Regex("[\\{\\}\\(\\)\\[\\]]"))) {
        s.onEach {
            if (it == '(' || it == '{' || it == '[') items.push(it)
            else {
                if (items.isEmpty()) return false
                else {
                    val top = items.lastElement()
                    if (top == '(' && it != ')' || top == '{' && it != '}' || top == '[' && it != ']') return false
                    else items.pop()
                }
            }
        }
    } else {
        return false
    }
    return items.isEmpty()
}

fun addBinary(a: String, b: String): String {
    if ((a.isEmpty()) && (b.length > 10.0.pow(4.0).toInt())) return ""
    val num1 = a.toBigInteger(2)
    val num2 = b.toBigInteger(2)
    return Integer.toBinaryString(num1.plus(num2).toInt())
}

// Palindrome example for int values
fun isPalindrome(x: Int): Boolean {
    var reversedVar = ""
    val formattedVar = x.toString()
    for (i in formattedVar.length - 1 downTo 0) {
        reversedVar += formattedVar[i]
    }
    println(reversedVar)
    return reversedVar.equals(formattedVar, true)
}

fun romanToInt(s: String): Int {
    val romanItems = hashMapOf(
        'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
    )
    var sum = 0
    s.forEachIndexed { index, it ->
        sum += if (it == 'M' && s.getOrNull(index - 1) == 'C') 900.minus(romanItems['C']!!)
        else if (it == 'C' && s.getOrNull(index - 1) == 'X') 90.minus(romanItems['X']!!)
        else if (it == 'X' && s.getOrNull(index - 1) == 'I') 9.minus(romanItems['I']!!)
        else if (it == 'V' && s.getOrNull(index - 1) == 'I') 4.minus(romanItems['I']!!)
        else romanItems[it] ?: 0
    }
    return sum
}

fun longestCommonPrefix(strs: Array<String>): String {
    var prefix = strs[0]
    strs.forEach {
        while (it.indexOf(prefix) != 0) prefix = prefix.substring(0, prefix.length - 1)
    }
    return prefix
}

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

fun testArrVsVector() {
    val vector: Vector<Int> by lazy { Vector<Int>() }
    vector.add(9)
    vector.add(19)
    vector.onEach { println(it) }
    val name = "Ahmed Gamal Yousef"

    // println(name)
    var newName = name.replace("A", "#", true)
    // println(newName)

    newName = name
    // println(newName)

}
    fun fibonacci(n: Int): Long {
        val cache = LongArray(n + 1)
        if (n == 1 || n == 0) return n.toLong()
        if (cache[n] != 0L)
            return cache[n]
        val nthFibonacci: Long = fibonacci(n - 1) + fibonacci(n - 2)
        cache[n] = nthFibonacci
        return nthFibonacci
    }

fun factorial(element: Int): Long {
    var newItem = element.toLong()
    return if (element == 1 || element == 0) element.toLong()
    else {
        for (i in element downTo 0) { // Another way as Recursion call...
            newItem += element * (element - 1)
        }
        newItem
    }
    /*
        else  element * fibonacci(element - 1) // Recursion call to execute the same logic, but element decremented...
    */
}

fun findDuplicatedItems(items: List<String>): Int {
    var dupItemsCount = 0
    for (i in items.indices) {
        for (j in i + 1 until items.size) {
            if (items[i] == items[j]) {
                dupItemsCount++
                println("index: $i, item: ${items[i]}")
            }
        }
    }

    // items.reduce{x,y-> x+y }.apply { println(this)}

    return dupItemsCount
}

//-----------------Codility------------------------------.....
/**
 * #1-Binary Gap
 **/
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

/**
 * Distinct items...
 **/
fun solution1(A: IntArray): Int {
    if (A.isEmpty() && A.size <= (10.0.pow(6.0))) {
        val distinctItems = A.toSet()
        return distinctItems.size
    }
    return 0
}

fun findUniqueItems(A: IntArray): Int {
    val tempList = mutableListOf<Int>()
    for (i in A.indices) {
        for (j in i + 1 until A.size) {
            if (A[i] == A[j]) {
                tempList.add(A[i])
            }
        }
    }
    return (A.subtract(tempList.toSet())).firstOrNull() ?: -1
}

fun solution3(a: MutableList<Int>): Int {
    val tempList = mutableSetOf<Int>()
    for (i in a) {
        if (tempList.contains(i)) return i
        else tempList.add(i)
    }
    return -1
}

fun solution2(s: String): Char {
    if (s.isEmpty() && s.length > 10.0.pow(5.0)) return '_'
    val uniqueItems = mutableSetOf<Char>()
    println(s)
    s.onEach { uniqueItems.add(it) }
    uniqueItems.onEach { item ->
        if (s.count { it == item } == 1) return item
    }
    return '_'
}

data class Building(val gym: Boolean, val school: Boolean, val store: Boolean)

fun buildingItems(): List<Building> = listOf(
    Building(gym = false, school = true, false),
    Building(gym = true, school = false, false),
    Building(gym = true, school = true, false),
    Building(gym = false, school = true, false),
    Building(gym = false, school = true, true),
)

fun nearestBuilding(): Int {
    val buildings = buildingItems()
    buildings.onEach {
        if (it.gym && it.school && it.store) return buildings.indexOf(it)
        else if (it.gym || it.school || it.store) {

        }

    }
    return -1
}

open class Test : Serializable

class shape(val radius: Int) : Test()

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

fun maxProfitWithKTransactions(prices: List<Int>, k: Int): Int {
    // Write your code here.
    return -1
}


fun solution4(A: IntArray): Int { // Need to optimize complexity...as it's O(N) or O(N*log(N))
    val mapper = ConcurrentHashMap<Int, Int>()
    A.forEach { item ->
        if (mapper.containsKey(item)) {
            val value = mapper[item]!!
            mapper[item] = value + 1
        } else {
            mapper[item] = 1
        }
    }

    val s = "5"
    println("${1 + 10}".plus(s).plus("${1 + 10}"))

    return mapper.entries.find { it.value % 2 != 0 }?.key ?: -1
}


/*
 * Complete the 'fizzBuzz' function below.
 *
 * The function accepts INTEGER n as parameter.
 */

fun fizzBuzz(n: Int) {
    val message = "Hello, dear the OTP is: 234390"
    val sms = Regex("[0-9]{6}")
    println(sms.find(message)?.value)

    for (i in 1..n) {
        val output = if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
        else if (i % 3 == 0 && i % 5 != 0) "Fizz"
        else if (i % 3 != 0 && i % 5 == 0) "Buzz"
        else "$i"
        println(output)
    }
}

// Careem Technical Question....
fun isAnagram(s1: String, s2: String): Boolean {
    val str1 = s1.trim()
    var str2 = s2.trim()
    if (str1.length != str2.length) return false
    for (i in str1) {
        if (str2.contains(i)) {
            str2 = str2.replaceFirst(i.toString(), "")
        }
    }
    return str2.isEmpty()
}

// Google tech question...
fun assumeSum(items: List<Int>, targetSum: Int): Boolean {
    var low = 0
    var high = items.size - 1
    println(items)
    for (i in items.indices) {
        val sum = items[low] + items[high]
        if (sum == targetSum) {
            println("indices: $low, $high")
            println("values: ${items[low]}, ${items[high]}")
            return true
        } else if (sum > targetSum) high--
        else low++
    }
    return false
}

typealias IntPredicate1 = (i: Int) -> Boolean
typealias IntPredicate2 = (i: Int) -> Boolean

fun test(predicate1: IntPredicate1) = predicate1.invoke(1)

fun testX(): Int = TODO("")

