package com.example.retrofitcomposeapp.di

import com.example.retrofitcomposeapp.data.ApiGame
import com.example.retrofitcomposeapp.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/*
    Cada vez que en algún sitio se requiera de Retrofit ,
    como por ejemplo en la interface, automáticamente se proveerá este singleton,
    o sea la misma instancia de Retrofit
    La interfaz ApiGame provee la conexión remota a este recurso con @GET

 */
@Module
@InstallIn(Singleton::class)
class AppModule {

    fun providerRetrofit(): ApiGame {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiGame::class.java)
    }

}