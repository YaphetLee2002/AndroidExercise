package com.example.broadcastbestpractice

import java.lang.StringBuilder

fun num1AndNum2(num1: Int, num2: Int, operator: (Int, Int) -> Int): Int {
    return operator(num1, num2)
}

fun StringBuilder.build(block : StringBuilder.() -> Unit) : StringBuilder {
    this.block()
    return this
}

fun main() {
    val list = listOf<String>("A", "B", "C", "D", "E")
    val result = StringBuilder().build {
        for (i in list) {
            append(i)
        }
        append("F")
    }
    println(result.toString())
}