package ex3

fun main(args: Array<String>) {
    println(trampoline(even(99999)))
    println(trampoline(odd(99999)))
}

fun odd(n: Int): Bounce<Boolean> = when(n){
    0 -> Done(false)
    else -> More{even(n-1)}
}

fun even(n: Int): Bounce<Boolean> = when(n) {
    0 -> Done(true)
    else -> More{odd(n -1)}
}

class OddEven {
}