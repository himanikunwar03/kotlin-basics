package com.example.himani

fun main(args: Array<String>) {
    var age = arrayOf(1, 2, 3)
    println(age)
    println("The first element of age is " + age[0])
    println("The second element of age is " + age[1])
    println("The third element of age is " + age[2])

    println("*******************")

    var name = arrayOf("ram", "shyam", "Hari")
    name[1] = "Himani"
    println("The first element of name is " + name[0])
    println("The second element of name is " + name[1])
    println("The third element of name is " + name[2])
    println(" *********************** ")

    println(name.size)



    var age1 = ArrayList<Int>()
    age1.add(1)
    age1.add(1, 20)
    age1.add(5)

// we can add value directly in array while initializing variables.
    var age2 = arrayListOf<Int>(1, 20, 5)

    var name1 = arrayListOf<String>("Himani", "ram", "shyam")
    name1.add("hari")
    name1.add(4,  "Sita")

    name1.remove( "shyam")
    name1.removeAt( 0)

    println(name1)


    var mixArrayList = arrayListOf<Any>("hello", 5, 2.0)
    println(mixArrayList[0]);
    println(mixArrayList[1]);
    println(mixArrayList[2]);

}

// we can add value only after our array is initialize

