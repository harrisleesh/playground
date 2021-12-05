package ex3
fun main(args: Array<String>) {
    println(elem(1, listOf(1,2,3,4,5,6)))
    println(elem(7, listOf(1,2,3,4,5,6)))
    println(elem(5, listOf(1,2,3,4,5,6)))
}

tailrec fun elemFP(num: Int, list: List<Int>): Boolean = when {
    list.isEmpty() -> false
    num == list.head() -> true
    else -> elemFP(num, list.drop(1))
}

class `ex3-16` {
}