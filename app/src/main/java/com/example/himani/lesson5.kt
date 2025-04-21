package com.example.himani

fun main(){
    var number:Any = readln()!!.toInt()

    if(number.toString().toInt() % 2 ==0){
        println("$number is even")
    }else{
        println("$number is odd")
    }


    print("Please enter your age :: ")
    var yourAge: Int = readln()!!.toInt()
    if (yourAge < 13) {
        print("You are a chlid")
    }else if (yourAge < 19) {
        print("You are a teenager")
    } else {
        if (yourAge < 50) {
            print("You are an adult")
        } else {
            print("You are a senior")
        }
    }

    println("Please enter 3 numbers : ")
    var number1: Int = readln()!!.toInt()
    var number2: Int = readln()!!.toInt()
    var number3: Int = readln()!!.toInt()
    var largestNumber: Int
    if (number1 >= number2) {
        if (number1 >= number3) {
            largestNumber = number1
        } else {
            largestNumber = number3
        }
    } else {
        if (number2 >= number3) {
            largestNumber = number2
        } else {
            largestNumber = number3
        }
    }
    println("The largest number is $largestNumber")


    print("Please enter a day number of week : - ")
    var dayNumber : Int = readln()!!.toInt()
    var day:String
    when(dayNumber)
    {
        1 -> day = "Sunday"
        2 -> day = "Monday"
        3 -> day = "Tuesday"
        4 -> day = "Wednesday"
        5 -> day = "Thursday"
        6 -> day = "Friday"
        7 -> day = "Saturday"
        else -> day = "Invalid day choice"
    }
    println(day)


   
}