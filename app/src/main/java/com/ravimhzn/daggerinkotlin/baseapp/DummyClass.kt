package com.ravimhzn.daggerinkotlin.baseapp

class DummyClass(private val firstname: String, var age: Int) {

    init {
        this.age = age + 10
        println("After changing:: $age")
    }



    fun dummyFun() {
        println("FirstName:: $firstname")
        println("Age:: $age")
    }

}

fun main(args: Array<String>) {
    DummyClass("Ravi", 27).dummyFun()
}