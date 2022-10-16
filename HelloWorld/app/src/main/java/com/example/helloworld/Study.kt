package com.example.helloworld

interface Study {
    fun readBooks()
    fun doHomework() {
        println("do homework default implementation.") //Kotlin允许对接口中定义的函数进行默认实现，就不用在类里override了
    }
}