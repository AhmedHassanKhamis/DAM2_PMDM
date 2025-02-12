package com.example.retrofitcomposeapp.data

import com.example.retrofitcomposeapp.models.GamesModel
import com.example.retrofitcomposeapp.util.Constants.Companion.END_POINT
import retrofit2.Response
import retrofit2.http.GET


interface ApiGame {

    @GET(END_POINT)
    suspend fun getGames(): Response<GamesModel>

}