package ex3

fun main(args: Array<String>) {
    println(factorial(5))
    println(factorial(0))
}

fun factorial(i: Int): Int = when (i) {
    0 -> 1
    1 -> 1
    else -> i * factorial(i - 1)
}

class `ex3-3` {
}