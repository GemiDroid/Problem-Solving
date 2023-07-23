package com.gemidroid.problem_solving.codility

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