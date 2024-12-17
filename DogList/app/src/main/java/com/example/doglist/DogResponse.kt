package com.example.doglist

import com.google.gson.annotations.SerializedName

data class DogResponse(@SerializedName("status") val status: String,@SerializedName("message") val imagenes: List<String>);


