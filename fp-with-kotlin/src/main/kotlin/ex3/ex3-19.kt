package ex3

import java.math.BigDecimal


fun main(args: Array<String>) {
    println(trampoline(factoTr(100000)))
}

fun factoTr(n: Int): Bounce<BigDecimal> = factoTr(n, 1, BigDecimal(1))

fun factoTr(n: Int, first: Int, result: BigDecimal): Bounce<BigDecimal> = when (n) {
    1 -> Done(result)
    else -> More{factoTr(n - 1, first + 1, result * BigDecimal(first))}
}

class `ex3-19` {
}