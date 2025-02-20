package com.cursoandroid.retrofitcomposeapp.repositorio

import com.cursoandroid.retrofitcomposeapp.Telefono
import com.cursoandroid.retrofitcomposeapp.data.TelefonosApi
import javax.inject.Inject

class TelefonosRepository @Inject constructor(private val apiTelefonosApi: TelefonosApi) {

//    suspend fun getGames(): List<GameList>? {
//        val response = apiGames.getGames()
//        if (response.isSuccessful) {
//            return response.body()?.results
//        }
//        return null
//    }

    suspend fun getTelefonos(): List<Telefono>? {
        return apiTelefonosApi.getTelefonos()
    }

    suspend fun getSingleTelefonoById(id: Int): Telefono? {
        return apiTelefonosApi.getSingleTelefonoById(id)
    }

}