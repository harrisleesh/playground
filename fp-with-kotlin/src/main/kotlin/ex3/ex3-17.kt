package ex3

import kotlin.math.sqrt

fun main(args: Array<String>) {
    println(mysqrt(10.0))
}

fun mysqrt(num: Double): Double = when {
    num < 1 -> num
    else -> divideByTwo(sqrt(num))

}

fun divideByTwo(num: Double): Double {
    return mysqrt(num / 2)
}

class `ex3-17` {
}