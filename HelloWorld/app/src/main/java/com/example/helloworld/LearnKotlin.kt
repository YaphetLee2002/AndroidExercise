package com.example.helloworld

fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val mutableList = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
    mutableList.add("Watermelon")
    val set = setOf("Apple", "Banana", "Orange", "Pear", "Grape")

    val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    val num = map["Apple"] //提取“Apple”对应的键值
    for ((fruit, number) in map) //使用for遍历map
        println("fruit is " + fruit + ", number is " + number)

    val newList = list.filter { it.length <= 5 }
                      .map { it.toUpperCase() }
    for (fruit in newList)
        println(fruit)

    val anyResult = list.any { it.length <= 5 }
    val allResult = list.all { it.length <= 5 }
    println("anyResult is " + anyResult + ", allResult is " + allResult)

//    val builder = StringBuilder()
//    builder.append("Start eating fruits.\n")
//    for (fruit in list) {
//        builder.append(fruit).append("\n")
//    }
//    builder.append("Ate all fruits.")
//    val result = builder.toString()
//    println(result)
//    下面是使用with的写法
//    val result = with(StringBuilder()) {
//        append("Start eating fruits.\n")
//        for (fruit in list) {
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//        toString()
//    }
//    下面是使用run的写法，与with类似，只是改为调用了对象的run函数，with的方式是调用with函数传入对象
//    val result = StringBuilder().run {
//        append("Start eating fruits.\n")
//        for (fruit in list) {
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//        toString()
//    }
//    下面是使用apply的写法，但是apply不能自己定义返回值，最终只能返回对象本身
//    val result = StringBuilder().apply {
//        append("Start eating fruits.\n")
//        for (fruit in list) {
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//    }
}
/*
fun main() {
    val cellphone1 = CellPhone("Samsung", 1299.99)
    val cellphone2 = CellPhone("Samsung", 1299.99)
    println(cellphone1)
    println("cellphone1 equals cellphone2 " + (cellphone1 == cellphone2))
}*/
/*
fun main() {
    val student = Student("Jack", 19)
    doStudy(student)
}*/

//几个版本的doStudy函数
fun doStudy1(study: Study) {
    study.readBooks()
    study.doHomework()
}
fun doStudy2(study: Study?) {
    if (study != null) {
        study.doHomework()
        study.readBooks()
    }
}
fun doStudy3(study: Study?) {
    study?.readBooks()
    study?.doHomework()
}
fun doStudy4(study: Study?) {
    study?.let{stu ->
        stu.doHomework()
        stu.readBooks()
    }
}
fun doStudy5(study: Study?) {
    study?.let {
        it.readBooks()
        it.doHomework()
    }
}