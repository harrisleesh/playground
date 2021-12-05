package ex3

fun main(args: Array<String>) {
    println(factorialWithMemo(6))
}
var memo = Array(100, { -1})

fun factorialWithMemo(n: Int): Int = when {
    n == 0 -> 0
    n == 1 -> 1
    memo[n] != -1 -> memo[n]
    else -> {
        memo[n] = n * factorialWithMemo(n-1)
        memo[n]
    }
}

class `ex3-10` {
}