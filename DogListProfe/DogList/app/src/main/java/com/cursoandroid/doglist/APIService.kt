package com.cursoandroid.doglist

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    // tipo de llamada, lo tomamos de Retrofit
    @GET
    suspend fun getPerrosPorRaza(@Url url:String): Response<DogResponse>
    // la url es la parte que cambia, la query y la pasamos como string de tipo url de retrofit
    // en nuestro caso: labrador/images
}