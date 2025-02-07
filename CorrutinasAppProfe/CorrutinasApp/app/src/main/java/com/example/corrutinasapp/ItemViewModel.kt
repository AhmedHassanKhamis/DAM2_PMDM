package com.example.corrutinasapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemViewModel : ViewModel() {

    var itemList = mutableStateListOf(ItemsModel())
        private set

    var _lista : MutableStateFlow<List<ItemsModel>> = MutableStateFlow(emptyList())
    var lista = _lista

    var isLoading by mutableStateOf(false)
        private set

//    init{
//        fetchData()
//    }

    fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                llamarApi()
            } catch (e: Exception) {
                println("Error,${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    private suspend fun llamarApi() {
        val resultado = withContext(Dispatchers.IO) {
            delay(4000)
            listOf(
                ItemsModel(1, "elemento 2"),
                ItemsModel(1, "elemento 2"),
                ItemsModel(1, "elemento 2"),
                ItemsModel(1, "elemento 2"),
                ItemsModel(1, "elemento 2"),
                ItemsModel(1, "elemento 2"),
                ItemsModel(1, "elemento 2"),
                ItemsModel(1, "elemento 2"),
                ItemsModel(1, "elemento 2"),
                ItemsModel(1, "elemento 2"),
                )
        }
        itemList.addAll(resultado)
        _lista.value = resultado
    }
}