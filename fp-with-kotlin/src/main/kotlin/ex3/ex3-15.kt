package ex3

fun main(args: Array<String>) {
    println(replicateFP(3, 5))
}

fun replicateFP(n: Int, element: Int): List<Int> = replicateFP(n, element, listOf())

fun replicateFP(n: Int, element: Int, acc: List<Int>) : List<Int> = when {
    n == 1 -> acc + element
    else -> replicateFP(n-1, element, acc + element)
}
class `ex3-15` {
}