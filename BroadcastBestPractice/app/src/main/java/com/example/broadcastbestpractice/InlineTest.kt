package com.example.broadcastbestpractice

inline fun printString(str : String, block : (String) -> Unit) {
    println("Print string begin")
    block(str)
    println("Print string end")
}

fun main() {
    println("main start")
    val str = ""
    printString(str) { s ->
        println("lambda start")
        if (s.isEmpty()) return //进行局部返回，不在执行剩余代码
        println(s)
        println("lambda end")
    }
    println("main end")
}