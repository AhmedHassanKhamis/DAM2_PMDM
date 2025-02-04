package com.example.corrutinasapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PrincipalViewModel: ViewModel() {

    var resultadoState by mutableStateOf("")



    fun bloqueoApp(){
        Thread.sleep(4000)
        resultadoState = "respuesta de la API"
    }


}