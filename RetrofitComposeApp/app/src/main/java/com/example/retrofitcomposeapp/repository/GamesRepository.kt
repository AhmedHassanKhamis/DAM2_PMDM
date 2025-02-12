package com.example.retrofitcomposeapp.repository

import com.example.retrofitcomposeapp.data.ApiGame
import com.example.retrofitcomposeapp.models.Personaje
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGame){

    suspend fun getRickMorty(): List<Personaje>? {
        val response = apiGames.getGames()
        if(response.isSuccessful) {
            return response.body()?.results
        }
        return null
    }
}  