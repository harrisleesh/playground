package ex3

fun main(args: Array<String>) {
    println(reverse("abcd"))
}
fun String.head() = first()
fun String.tail() = drop(1)
fun reverse(str: String) : String = when {
    str.isEmpty() -> ""
    else -> reverse(str.tail()) + str.head()
}
class reverse {
}