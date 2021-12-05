package ex3


fun main(args: Array<String>) {
    println(replicate(3, 5))
}

fun replicate(n: Int, element: Int): List<Int> = when {
    n == 1 -> listOf(element)
    else -> replicate(n-1, element).plus(element)
}

class `ex3-5` {
}