package ex3

fun main(args: Array<String>) {

    println(toBinary(10))
}

fun toBinary(n: Int): String = when {
    n == 1 -> "1"
    n % 2 == 1 -> toBinary(n / 2) + "1"
    else -> toBinary(n / 2) + "0"
}

class `ex3-4` {
}