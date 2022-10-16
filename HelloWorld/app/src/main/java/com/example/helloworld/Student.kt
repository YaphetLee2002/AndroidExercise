package com.example.helloworld
class Student (name: String, age: Int) :
    Person(name, age), Study {
    override fun readBooks() {
        println(name + " is reading.")
    }

    override fun doHomework() { //对接口定义的函数加上默认实现以后，这里可以去掉
        println(name + " is doing homework.")
    }
}
/*
class Student : Person {
    constructor(name: String, age: Int) : super(name, age)
}
*/