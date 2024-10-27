package com.example.miprimerproyecto.PrimerPaquete.Ejemplo

fun main(){
    obtenerMes(4);
    obtenerTrimestre(4)
}

fun obtenerMes(mes:Int){
    when(mes){
        1->println("Enero")
        2->println("Febrero")
        3->println("Marzo")
        4->println("Abril")
        5->println("Mayo")
        6->println("Junio")
        7->println("Julio")
        8->println("Agosto")
        9->println("Septiembre")
        10->println("Octubre")
        11->println("Noviembre")
        else -> println("Diciembre")}}

fun obtenerTrimestre(mes:Int){
    when(mes){
        1,2,3 ->println("primer trimestre")
        4,5,6 ->println("segundo trimestre")
        7,8,9 ->println("tercer trimestre")
        10,11,12 ->println("cuarto trimestre")}
}

fun obtenerSemestre(mes:Int){
    when(mes){
        in 1..6 -> println("1er semestre")
        in 7..12 -> println("2º semestre")}
}
