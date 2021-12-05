package ex3

fun main(args: Array<String>) {
    println(toBinaryFP(10))
}



fun toBinaryFP(n: Int): String = toBinaryFP(n, "")

tailrec fun toBinaryFP(n: Int, acc: String): String = when {
    n == 1 -> "" + n + acc
    n % 2 == 1 -> toBinaryFP(n / 2, acc + "1")
    else -> toBinaryFP(n / 2, acc + "0")
}
class `ex3-14` {
}