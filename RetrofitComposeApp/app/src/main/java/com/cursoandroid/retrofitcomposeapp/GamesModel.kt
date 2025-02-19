package com.cursoandroid.retrofitcomposeapp


//https://rawg.io/
// https://rickandmortyapi.com/documentation
data class GamesModel (
    val count: Int,
   // val results: List<GameList>,
    val results: List<Personaje>
)

data class GameList(
    val id: Int,
    val name: String,
    val background_image: String
)

data class Personaje (
    val id: Int,
    val name: String,
    val image: String
)