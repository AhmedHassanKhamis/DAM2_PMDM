package com.cursoandroid.retrofitcomposeapp.state

import com.cursoandroid.retrofitcomposeapp.models.Location
import com.cursoandroid.retrofitcomposeapp.models.Origin

data class GameState(
    val created: String = "",
    val episode: List<String>? = null,
    val gender: String = "",
    val id: Int = 0,
    val image: String = "",
    val location: Location? = null,
    val name: String = "",
    val origin: Origin? = null,
    val species: String ="",
    val status: String = "",
    val type: String = "",
    val url: String = ""
)
