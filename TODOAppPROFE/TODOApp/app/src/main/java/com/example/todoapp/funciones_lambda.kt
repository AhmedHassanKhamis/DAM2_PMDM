package com.example.todoapp


fun main() {
    val suma: (Int, Int) -> Int = {a, b -> a + b}

    val resultado = suma(5, 5)
    println(resultado)

    var mult = {x: Int, y: Int -> x * y}

    println(mult(6,8))

    val duplicar: (Int) -> Int = {it * 2}

    println(duplicar(4))
}