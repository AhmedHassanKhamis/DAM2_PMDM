package com.cursoandroid.retrofitcomposeapp.data

import com.cursoandroid.retrofitcomposeapp.GamesModel
import com.cursoandroid.retrofitcomposeapp.models.Result
import com.cursoandroid.retrofitcomposeapp.util.Constantes.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApi {

    @GET(ENDPOINT)
    suspend fun getGames(): Response<GamesModel>


    @GET("$ENDPOINT/{id}")
    suspend fun getGameById(@Path(value= "id")id: Int): Response<Result>
}