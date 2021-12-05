package ex3

fun main(args: Array<String>) {
    println(factoFP(6))
}

fun factoFP(n: Int):Int = factoFP(n, 1, 1)

tailrec fun factoFP(n: Int, first: Int, result: Int) : Int = when(n){
    1 -> result
    else -> factoFP(n-1, first + 1, result * first )
}

class `ex3-11` {
}