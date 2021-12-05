package ex3

fun main(args: Array<String>) {
    println(maximum(listOf(2,9,3,7,1)))
}

fun List<Int>.head() = first()
fun List<Int>.tail() = drop(1)
fun maximum(items: List<Int>): Int = when {
   items.isEmpty() -> error("empty list")
   items.size == 1 -> items[0]
    else -> {
        val head = items.head()
        val tail = items.tail()
        val maxVal = maximum(tail)
        if(head > maxVal) head else maxVal
    }
}

class Maximum {
}