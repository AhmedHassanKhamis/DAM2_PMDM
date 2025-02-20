package com.cursoandroid.retrofitcomposeapp.data

import com.cursoandroid.retrofitcomposeapp.Telefono
import com.cursoandroid.retrofitcomposeapp.TelefonosModel
import com.cursoandroid.retrofitcomposeapp.util.ConstantesAhmed.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TelefonosApi {

    @GET(ENDPOINT)
    suspend fun getTelefonos(): List<Telefono>

    @GET("$ENDPOINT/{id}")
    suspend fun getSingleTelefonoById(@Path("id") id: Int): Telefono
}