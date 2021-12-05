package ex3

fun main(args: Array<String>) {
    println(fiboRecursion(10))
}

fun fiboRecursion(n: Int): Int = when (n) {
    0 -> 0
    1 -> 1
    else -> fiboRecursion(n - 1) + fiboRecursion(n - 2)
}
class Fibo {
}