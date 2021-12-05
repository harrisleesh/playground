package ex3

fun main(args: Array<String>) {
    println(power(2.0,5))
}
fun power(x: Double, n: Int):Double = when(n){
    0 -> 1.0
    else -> x * power(x, n-1)
}
class `ex3-2` {
}