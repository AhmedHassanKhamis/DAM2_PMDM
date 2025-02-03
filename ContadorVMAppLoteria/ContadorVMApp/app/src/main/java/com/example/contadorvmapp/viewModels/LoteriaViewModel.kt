package com.example.contadorvmapp.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoteriaViewModel:ViewModel() {
    private val _numeroLoteria= mutableStateOf(emptyList<Int>())

    val numeroLoteria: State<List<Int>> =_numeroLoteria
    fun generarNumerosLoteria(){
        _numeroLoteria.value = (1..60).shuffled().take(6).sorted()
    }
}