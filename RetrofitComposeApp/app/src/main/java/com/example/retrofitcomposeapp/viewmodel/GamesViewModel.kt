package com.example.retrofitcomposeapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitcomposeapp.models.Personaje
import com.example.retrofitcomposeapp.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repo: GamesRepository):ViewModel() {

    private val _personajes = MutableStateFlow<List<Personaje>>(emptyList())
    val personajes = _personajes.asStateFlow()

    init {
        fetchRickMorty()
    }

    private fun fetchRickMorty() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repo.getRickMorty()
                _personajes.value = result ?: emptyList()
            }
        }
    }

}