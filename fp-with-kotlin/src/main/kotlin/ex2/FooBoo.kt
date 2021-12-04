package ex2

interface Foo {
    fun printFoo()
}

interface Boo {
    fun printBar()
}

class FooBoo : Foo, Boo{
    override fun printFoo() {
        TODO("Not yet implemented")
    }

    override fun printBar() {
        TODO("Not yet implemented")
    }

}