package com.example.retrofitcomposeapp.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.retrofitcomposeapp.viewmodel.GamesViewModel

@Composable
fun HomeView(modifier: Modifier = Modifier,  viewModel: GamesViewModel) {
    val personajes by viewModel.personajes.collectAsState()

    LazyColumn {
        items(personajes) {
            item->
              Text(text=item.name)
              Text(text=item.image)
        }
    }
}