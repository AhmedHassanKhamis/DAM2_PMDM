package com.example.myprimerproyecto.ejemplosKotlin

fun main() {

    obtenerMes(4)
    obtenerTrimestre(2)
    obtenerSemestre(1)

}

fun obtenerMes(mes:Int) {
    when(mes) {
        1 -> println("enero")
        2 -> println("febrero")
        3 -> println("marzo")
        4 -> println("abril")
        5 -> println("mayo")
        6 -> println("junio")
        else -> println("no es un mes válido")
    }

}

fun obtenerTrimestre(mes: Int) {
    when(mes) {
        1, 2,3 -> println("primer trimesre")
        4,5,6 -> println("segundo trimestre")
        else -> println("no es un trimestre válido")
    }

}

fun obtenerSemestre(mes: Int){
    when(mes){
        in 1..6 -> println("primer semestre")
        in 7..12 -> println("segundo semestre")
        else -> println("no es un mes válido")
    }
}