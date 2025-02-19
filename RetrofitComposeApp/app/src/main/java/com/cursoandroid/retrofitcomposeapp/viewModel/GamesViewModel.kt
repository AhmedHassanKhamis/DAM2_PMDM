package com.cursoandroid.retrofitcomposeapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursoandroid.retrofitcomposeapp.GameList
import com.cursoandroid.retrofitcomposeapp.Personaje
import com.cursoandroid.retrofitcomposeapp.models.Result
import com.cursoandroid.retrofitcomposeapp.repositorio.GamesRepository
import com.cursoandroid.retrofitcomposeapp.state.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repo: GamesRepository) : ViewModel(){

    private val _games = MutableStateFlow <List<GameList>>(emptyList())
    val games = _games.asStateFlow()

    private val _personajes = MutableStateFlow <List<Personaje>>(emptyList())
    val personajes = _personajes.asStateFlow()

    var state by mutableStateOf(GameState())  // estas variables que maneja GameState las presentaremos directamente en las vistas
        private set



    init {
       // fetchGames()
        fetchRickMorty()
    }

//    private fun fetchGames() {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                val result = repo.getGames()
//               _games.value = result ?: emptyList()
//            }
//        }
//    }

    private fun fetchRickMorty() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repo.getRickMorty()
                _personajes.value = result ?: emptyList()
            }
        }
    }

    // esta función no la hacemos privada porque la llamaré desde la vista

     fun getSingleCharacterById(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repo.getSingleCharacter(id)
                state = state.copy(
                    name = result?.name ?: "",
                    gender = result?.gender ?: "",
                    species = result?.species ?: "",
                    image = result?.image ?: "",
                    id = result?.id ?: 0
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
            gender =  "",
            species =  "",
            image =  "",
            id =  0
        )
    }
}

