package ex2

fun String.hello(): String{
    return "Hello, $this"
}

fun main(args: Array<String>) {
    println("World".hello())
    println("Kotlin".hello())
}
class HelloStringExample {

}