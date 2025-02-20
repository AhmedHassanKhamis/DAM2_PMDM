package com.cursoandroid.retrofitcomposeapp


//https://rawg.io/
// https://rickandmortyapi.com/documentation
data class TelefonosModel (
    val telefonos: List<Telefono>
)

data class Telefono(
    val id: Int,
    val name: String
)