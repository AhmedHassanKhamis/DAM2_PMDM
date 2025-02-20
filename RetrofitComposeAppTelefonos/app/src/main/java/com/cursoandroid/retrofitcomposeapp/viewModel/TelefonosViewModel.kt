package com.cursoandroid.retrofitcomposeapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.cursoandroid.retrofitcomposeapp.Telefono

import com.cursoandroid.retrofitcomposeapp.repositorio.TelefonosRepository
import com.cursoandroid.retrofitcomposeapp.state.TelefonoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TelefonosViewModel @Inject constructor(private val repo: TelefonosRepository) : ViewModel(){


    private val _telefonos = MutableStateFlow <List<Telefono>>(emptyList())
    val telefonos = _telefonos.asStateFlow()

    var state by mutableStateOf(TelefonoState())  // estas variables que maneja GameState las presentaremos directamente en las vistas
        private set



    init {
       // fetchGames()
        fetchTelefonos()
    }

//    private fun fetchGames() {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                val result = repo.getGames()
//               _games.value = result ?: emptyList()
//            }
//        }
//    }

    private fun fetchTelefonos() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repo.getTelefonos()
                _telefonos.value = result ?: emptyList()
            }
        }
    }

    fun getSingleTelefonoById(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repo.getSingleTelefonoById(id)
                state = state.copy(
                    name = result?.name?: "",
                    id = result?.id?.toInt()?: 0
                )
            }
        }
    }


    // esta función la llamaremos en el DetailView en un método DisposableEffect()
    // efectos que requieren limpieza:
    // https://developer.android.com/develop/ui/compose/side-effects?hl=es-419#disposableeffect
    fun clean() {
        state = state.copy(
            name ="",
            id =  0
        )
    }
}

