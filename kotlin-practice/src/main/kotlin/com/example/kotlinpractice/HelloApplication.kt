package com.example.kotlinpractice

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

@ApplicationPath("/api")
class HelloApplication : Application()

fun main() {
    println("hi")
    val javaPrinter = JavaPrinter()
    javaPrinter.filePrinter()
}

fun filePrinter() {
    val file = File(".")
    val currentFile = File(file.absolutePath + "/a.txt")
    val bufferedReader = BufferedReader(FileReader(currentFile))
    println(bufferedReader.readLine())
    bufferedReader.close()
}

fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}

/**
boolean startsWithA1(String str){
if (str == null) {
throw new IllegalArgumentException("null이 들어왔습니다.");
}
return str.startsWith("A");
}

Boolean startsWithA2(String str) {
if (str == null) {
return null;
}
return str.startsWith("A");
}

boolean startsWithA3(String str) {
if (str == null) {
return false;
}
return str.startsWith("A");
}
 */

fun startsWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw java.lang.IllegalArgumentException("null이 들어왔습니다.")
}

fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}
