package com.example.himani


fun main() {
    //Immutable List
    val lst = listOf("one", "two", "three")
    println("Mutable List")
    for (i in lst.indices) {
        println(lst[i])
    }
    println()
    //Mutable List
    val mutableLst = mutableListOf("one", "two", "three")
    mutableLst.add("Four")
    println("Immutable list")
    for (i in mutableLst.indices) {
        println(mutableLst[i])
    }
}

fun set() {
    val numbers = setOf(1, 2, 3, 4)
    for (elements in numbers) {
        println(elements)
    }
    val numbersBackwards = setOf(4, 3, 2, 1)
    println("The sets are equal : ${numbers == numbersBackwards}")


}

fun displayList() {
    val numbers: List<String> = listOf("one", "two", "three", "four")

    println("Number of element: ${numbers.size}")
    println("Third  element: ${numbers.get(2)}")
    println("Fourth element: ${numbers[3]}")
    println("Index of element\"two\" ${numbers.indexOf("two")}")
}