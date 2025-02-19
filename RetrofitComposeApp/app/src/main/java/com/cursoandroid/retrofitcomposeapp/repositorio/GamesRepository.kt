package com.cursoandroid.retrofitcomposeapp.repositorio

import com.cursoandroid.retrofitcomposeapp.GameList
import com.cursoandroid.retrofitcomposeapp.Personaje
import com.cursoandroid.retrofitcomposeapp.data.GameApi
import com.cursoandroid.retrofitcomposeapp.models.Result
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: GameApi) {

//    suspend fun getGames(): List<GameList>? {
//        val response = apiGames.getGames()
//        if (response.isSuccessful) {
//            return response.body()?.results
//        }
//        return null
//    }

    suspend fun getRickMorty(): List<Personaje>? {
        val response = apiGames.getGames()
        if (response.isSuccessful) {
            return response.body()?.results
        }
        return null
    }

    suspend fun getSingleCharacter(id: Int): Result? {
        val response = apiGames.getGameById(id)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

}