package com.example.retrofitcomposeapp.models

data class GamesModel (
   // val count: Int,
    val info: Informacion,
    val results: List<Personaje>
)

data class Personaje(
    val id: Int,
    val name: String,
    val image: String
)

data class Informacion(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)