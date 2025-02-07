package com.example.corrutinasapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrincipalViewModel: ViewModel() {

    var resultadoState  by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                llamarApi()
            }catch (e:Exception) {
                println("Error,${e.message}")
            }finally {
                isLoading = false
            }

            llamarApi()
        }
    }

     private suspend fun llamarApi() {
        val resultado = withContext(Dispatchers.IO) {
            delay(4000)
            "esto es la respuesta a la llamada de la API"
        }
        resultadoState = resultado
    }

//    fun bloqueoApp() {
//        Thread.sleep(4000)
//        resultadoState = "respuesta de la API"
//    }
}