package com.example.contadorvmapp.viewModels

import android.view.View
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ContadorVIewModel:ViewModel(){
    private val _contador= mutableStateOf(0)

    val contador:State<Int> =_contador
    fun add() {
        _contador.value=_contador.value+1
    }


}