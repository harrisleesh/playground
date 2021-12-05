package ex3

import kotlin.math.sqrt

fun main(args: Array<String>) {
    println(trampoline(sqrtTrampoline(9999999999999999.0)))
}

fun sqrtTrampoline(num: Double): Bounce<Double> = when {
    num < 1 -> Done(num)
    else -> More{divideByTwoTrampoline(sqrt(num))}

}

fun divideByTwoTrampoline(num: Double): Bounce<Double> = when {
    num < 1 -> Done(num)
    else -> More{sqrtTrampoline(num / 2)}
}


class `ex3-18` {
}