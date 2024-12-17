package com.example.doglist

import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun getDogsPorRazas(@Url)
}