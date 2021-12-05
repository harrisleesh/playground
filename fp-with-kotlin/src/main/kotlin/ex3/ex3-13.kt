package ex3

fun main(args: Array<String>) {
    println(powerFP(2.0,5))
}

fun powerFP(num: Double, pow: Int): Double = powerFP(num, pow, 1.0);

tailrec fun powerFP(num: Double, pow: Int, result : Double): Double = when (pow) {
    0 -> result
    else -> powerFP(num, pow -1, result * num)
}

class `ex3-13` {
}